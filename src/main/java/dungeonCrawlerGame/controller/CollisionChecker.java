package dungeonCrawlerGame.controller;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.Entity;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.ItemProperties;
import dungeonCrawlerGame.items.Items;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.locations.Location;

import dungeonCrawlerGame.locations.Cells;

import java.util.List;

public class CollisionChecker {

    public static void checkCellCollision(Entity entity) {
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int entityLeft = entity.getPosX() + Config.CELL_SIZE / 6;
        int entityRight = entity.getPosX() + (Config.CELL_SIZE / 6) * 5;
        int entityTop = entity.getPosY() + Config.CELL_SIZE / 3;
        int entityBottom = entity.getPosY() + Config.CELL_SIZE;

        int entityRightColumn = entityRight / Config.CELL_SIZE;
        int entityLeftColumn = entityLeft / Config.CELL_SIZE;
        int entityTopRow = entityTop / Config.CELL_SIZE;
        int entityBottomRow = entityBottom / Config.CELL_SIZE;

        Cells cell1;
        Cells cell2;

        switch (entity.getDirection()) {
            case UP:
                entityTopRow = (entityTop - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityLeftColumn];
                cell2 = currentLocation[entityTopRow][entityRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case DOWN:
                entityBottomRow = (entityBottom + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityBottomRow][entityLeftColumn];
                cell2 = currentLocation[entityBottomRow][entityRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case LEFT:
                entityLeftColumn = (entityLeft - entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityLeftColumn];
                cell2 = currentLocation[entityBottomRow][entityLeftColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);

                break;
            case RIGHT:
                entityRightColumn = (entityRight + entity.getSpeed()) / Config.CELL_SIZE;
                cell1 = currentLocation[entityTopRow][entityRightColumn];
                cell2 = currentLocation[entityBottomRow][entityRightColumn];
                if (cell1.isSolid() || cell2.isSolid())
                    entity.setCollision(true);
                break;
        }
    }

    public static Cells getCurrentCell(Player player) {
        Cells[][] currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());

        int playerCenter = player.getPosX() + Config.CELL_SIZE / 2;
        int playerBottom = player.getPosY() + Config.CELL_SIZE - 10;

        int playerColumn = playerCenter / Config.CELL_SIZE;
        int playerBottomRow = playerBottom / Config.CELL_SIZE;

        return currentLocation[playerBottomRow][playerColumn];
    }

    public static int checkEntityCollision(Entity entity, List<Monster> monsters) {

        int index = -1;
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {

                Monster monster = monsters.get(i);
                monster.getBounds().x = monster.getPosX();
                monster.getBounds().y = monster.getPosY();

                entity.getBounds().x = entity.getPosX();
                entity.getBounds().y = entity.getPosY();

                switch (entity.getDirection()) {
                    case UP:
                        entity.getBounds().y -= entity.getSpeed();
                        if (entity.getBounds().intersects(monster.getBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case DOWN:
                        entity.getBounds().y += entity.getSpeed();
                        if (entity.getBounds().intersects(monster.getBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case LEFT:
                        entity.getBounds().x -= entity.getSpeed();
                        if (entity.getBounds().intersects(monster.getBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                    case RIGHT:
                        entity.getBounds().x += entity.getSpeed();
                        if (entity.getBounds().intersects(monster.getBounds())) {
                            entity.setCollision(true);
                            index = i;
                        }
                        break;
                }
            }
        }
        return index;
    }

    public static void checkPlayerCollision(Entity entity) {

        entity.getBounds().x = entity.getPosX();
        entity.getBounds().y = entity.getPosY();

        GameInit.player.getBounds().x = GameInit.player.getPosX();
        GameInit.player.getBounds().y = GameInit.player.getPosY();

        switch(entity.getDirection()){
            case UP:
                entity.getBounds().y -= entity.getSpeed();
                if(entity.getBounds().intersects(GameInit.player.getBounds())){
                    entity.setCollision(true);
                }
                break;
            case DOWN:
                entity.getBounds().y += entity.getSpeed();
                if(entity.getBounds().intersects(GameInit.player.getBounds())){
                    entity.setCollision(true);
                }
                break;
            case LEFT:
                entity.getBounds().x -= entity.getSpeed();
                if(entity.getBounds().intersects(GameInit.player.getBounds())){
                    entity.setCollision(true);
                }
                break;
            case RIGHT:
                entity.getBounds().x += entity.getSpeed();
                if(entity.getBounds().intersects(GameInit.player.getBounds())){
                    entity.setCollision(true);
                }
                break;
        }
    }

    public static int checkItemCollision(Entity entity) {

        int index = -1;

        for (int i = 0; i < Items.getItem().size(); i++) {
            if (Items.getItem().get(i).getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {
                ItemObject item = Items.getItem().get(i);
                item.itemBounds.x = item.getPosX();
                item.itemBounds.y = item.getPosY();

                entity.getBounds().x = entity.getPosX();
                entity.getBounds().y = entity.getPosY();

                switch (entity.getDirection()) {
                    case UP:
                        entity.getBounds().y -= entity.getSpeed();
                        if (entity.getBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case DOWN:
                        entity.getBounds().y += entity.getSpeed();
                        if (entity.getBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case LEFT:
                        entity.getBounds().x -= entity.getSpeed();
                        if (entity.getBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                    case RIGHT:
                        entity.getBounds().x += entity.getSpeed();
                        if (entity.getBounds().intersects(item.itemBounds)) {
                            if(item.getItemProperties().isSolid()) {
                                entity.setCollision(true);
                                if (entity instanceof Player) {
                                    index = i;
                                }
                            }
                            else if(!item.getItemProperties().isSolid() && entity instanceof Player){
                                item.pickUp(true);
                            }
                        }
                        break;
                }
                entity.getBounds().x = entity.getPosX();
                entity.getBounds().y = entity.getPosY();
            }

        }
        return index;
    }
}

