package dungeonCrawlerGame.entities.monster;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.CollisionChecker;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Monsters {

    private static List<Monster> monsters;
    private int damageCounter = 0;
    private int staminaCounter = 0;

    public Monsters()
    {
        monsters = new ArrayList<Monster>();
    }

    public void addMonster(Monster monster)
    {
        monsters.add(monster);
    }

    public void updateMonsters()
    {
        for (Monster monster : monsters)
        {
            monster.moveEntity();
        }
    }

    public void checkDead()
    {
        for (Monster monster : monsters)
        {
            if (monster.getHealth() <= 0)
            {
                //Location number 0 is the graveyard for monsters
                monster.setLocationNumber(0);
            }
        }
    }

    public void checkCollision()
    {
        for (int i = 0; i < monsters.size(); i++)
        {
            int index = CollisionChecker.checkEntityCollision(monsters.get(i),getMonsters());
            if (i == index)
            {
                monsters.get(i).setCollision(false);
            }
            CollisionChecker.checkCellCollision(monsters.get(i));
            CollisionChecker.checkPlayerCollision(monsters.get(i));
            CollisionChecker.checkItemCollision(monsters.get(i));
        }
    }

    public void checkForDamage(){
        for (Monster monster : monsters)
        {
            if (monster.getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {
                if (monster.playerCollision) {
                    monster.attacks();
                }
            }
        }

    }

    public static List<Monster> getMonsters()
    {
            return monsters;
    }

    public void drawMonsters(Graphics2D g2d)
    {
        for (Monster monster : monsters)
        {
            if (monster.getLocationNumber() == DungeonMap.getCurrentWorldLocation())
            {
                g2d.drawImage(monster.getImage(), monster.getPosX(), monster.getPosY(), Config.CELL_SIZE, Config.CELL_SIZE, null);

                double monsterHealth = monster.getHealth();
                double monsterMaxHealth = BatProperties.getHealth(monster.getEnemy());
                int monsterHealthBar = (int) ((monsterHealth / monsterMaxHealth) * Config.CELL_SIZE);

                g2d.setColor(new Color(50,0,0));
                g2d.fillRoundRect( monster.getPosX()-3, monster.getPosY() - 23, Config.CELL_SIZE+6, 21, 10, 10);

                g2d.setColor(new Color(255,0,60));
                g2d.fillRoundRect( monster.getPosX(), monster.getPosY() - 20, monsterHealthBar, 15, 10, 10);
            }
        }
    }
}
