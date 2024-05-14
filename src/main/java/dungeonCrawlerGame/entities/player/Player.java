package dungeonCrawlerGame.entities.player;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.items.Items;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.Cells;

import java.awt.*;

public class Player implements Entity {

    private static int x;
    private static int y;
    private int health;
    private int locationNumber;
    public Direction direction;
    private Image image;
    private int damage;
    private boolean dead;
    private boolean playerAttacks = false;

    private int playerSpeed;
    public boolean collision = false;
    public boolean monsterCollision;
    private int imageCounter = 0;
    private int imageNum = 1;
    private int stamina;
    private int staminaCounter = 0;
    public Rectangle entityBounds = new Rectangle(x, y, Config.CELL_SIZE, Config.CELL_SIZE);
    private int monsterIndex;
    private int itemIndex;
    private int attackCounter;

    public Player() {
        setDefaultSettings();
    }

    public void setDefaultSettings() {
        x = 1500;
        y = 200;
        //playerSpeed = Config.DEFAULT_PLAYER_SPEED;
        playerSpeed = 10;
        health = Config.DEFAULT_PLAYER_HEALTH;
        stamina = Config.DEFAULT_PLAYER_STAMINA;
        this.damage = Config.DEFAULT_PLAYER_DAMAGE;
        direction = Direction.DOWN;
    }

    public void setPlayerSpeed(Cells cell) {
        //playerSpeed = cell.getSpeedImpact();
    }

    @Override
    public void moveEntity() {
        playerAttacks = false;
        if (KeyAction.down || KeyAction.up || KeyAction.left || KeyAction.right || KeyAction.attack) {
            if (KeyAction.up) {
                direction = Direction.UP;}
            else if (KeyAction.down) {
                direction = Direction.DOWN;}
            else if (KeyAction.left) {
                direction = Direction.LEFT;}
            else if (KeyAction.right) {
                direction = Direction.RIGHT;}
            else if (KeyAction.attack) {
                playerAttacks = true;}

                    collision = false;
                    monsterCollision = false;
                    //Check collision only inside current location if moving
                    if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH
                            && y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {

                        CollisionChecker.checkCellCollision(this);
                        setPlayerSpeed(CollisionChecker.getCurrentCell(this));
                        CollisionChecker.checkItemCollision(this);

                        itemIndex = CollisionChecker.checkItemCollision(this);
                        if (itemIndex != -1){
                            PlayerState.updateInventory(Items.getItem().get(itemIndex));
                        }

                        monsterIndex = CollisionChecker.checkEntityCollision(this, Monsters.getMonsters());
                        if (monsterIndex != -1) {
                            attacks();
                        }
                    }

                    if (direction != null && !collision && !playerAttacks){
                        switch (direction) {
                            case UP:
                                if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH) {
                                    y -= playerSpeed;
                                }
                                break;
                            case DOWN:
                                if (x >= 5 && x + Config.CELL_SIZE + 5 <= Config.LOCATION_WIDTH) {
                                    y += playerSpeed;
                                }
                                break;
                            case LEFT:
                                if (y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {
                                    x -= playerSpeed;
                                }
                                break;
                            case RIGHT:
                                if (y + Config.CELL_SIZE + 5 <= Config.LOCATION_HEIGHT && y >= 5) {
                                    x += playerSpeed;
                                }
                        }
                        imageCounter++;
                        if (imageCounter > 10) {
                            if (imageNum == 1) {
                                imageNum = 2;
                            } else if (imageNum == 2) {
                                imageNum = 1;
                            }
                            imageCounter = 0;
                        }
                        DungeonMap.getCurrentWorldLocation(this);
                    }
        }
    }

    public void increaseStamina() {
        if (stamina < Config.DEFAULT_PLAYER_STAMINA) {
            staminaCounter++;
            if(staminaCounter > 50) {
                staminaCounter = 0;
                stamina++;
            }
        }
    }

    @Override
    public Image getImage() {

        if(stamina <= 0) {
            playerAttacks = false;
        }
        switch (direction) {
            case UP:
                if (!playerAttacks) {
                    if (imageNum == 1) {
                        image = PlayerImage.PLAYER_UP1.getImage();
                    } else if (imageNum == 2) {
                        image = PlayerImage.PLAYER_UP2.getImage();
                    }
                } else {
                    //image = Cells.BL.getImage();
                }
                break;
            case DOWN:
                if (!playerAttacks){
                    if (imageNum == 1) {
                        image = PlayerImage.PLAYER_DOWN1.getImage();
                    } else if (imageNum == 2) {
                        image = PlayerImage.PLAYER_DOWN2.getImage();
                    }
                } else {
                    //image = Cells.BL.getImage();
                }
                break;
            case LEFT:
                if (!playerAttacks) {
                    if (imageNum == 1) {
                        image = PlayerImage.PLAYER_LEFT1.getImage();
                    } else if (imageNum == 2) {
                        image = PlayerImage.PLAYER_LEFT2.getImage();
                    }
                }
                else {
                    //image = Cells.BL.getImage();
                }
                break;
            case RIGHT:
                if (!playerAttacks) {
                    if (imageNum == 1) {
                        image = PlayerImage.PLAYER_RIGHT1.getImage();
                    } else if (imageNum == 2) {
                        image = PlayerImage.PLAYER_RIGHT2.getImage();
                    }
                }
                else {
                    //image = Cells.BL.getImage();
                }
                break;
        }
        return image;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getSpeed() {
        return this.playerSpeed;
    }

    @Override
    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    @Override
    public void setLocationNumber(int locationNumber) {
        this.locationNumber = locationNumber;
    }

    @Override
    public void setPlayerMonsterCollision(boolean playerMonsterCollision) {
        this.monsterCollision = playerMonsterCollision;
    }

    @Override
    public Rectangle getBounds() {
        return entityBounds;
    }

    @Override
    public void takeDamage(int i) {
        health = health - i;
    }

    @Override
    public int getPosX() {
        return x;
    }

    @Override
    public int getPosY() {
        return y;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getLocationNumber() {
        return this.locationNumber;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void attacks() {
        if(stamina > 0 && playerAttacks){

            attackCounter++;
            if( attackCounter>10) {
                Monsters.getMonsters().get(monsterIndex).takeDamage(this.damage);
                attackCounter = 0;
                stamina -= Config.STAMINA_REDUCE;
            }
        }
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = this.stamina + stamina;
    }

    public void setHealth(int health) {
        this.health = this.health + health;
    }
}
