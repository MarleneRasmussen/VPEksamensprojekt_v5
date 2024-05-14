package dungeonCrawlerGame.entities.player;

import java.awt.*;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.KeyAction;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.ItemProperties;

import static dungeonCrawlerGame.gameWindow.GameInit.player;

public class PlayerState {

    private static int coins;
    private static int keys;
    private static int potions;
    private static int potionCounter = 9;
    private static int keyCounter = 9;

    public static void addItemToInventory(ItemObject item) {
        if(item.getItemProperties() == ItemProperties.COIN) {
            coins++;
        }
        if(item.getItemProperties() == ItemProperties.KEY) {
            keys++;
        }
        if(item.getItemProperties() == ItemProperties.POTION) {
            potions++;
        }
    }

    public static void updateInventory(ItemObject item) {
        if(item.getItemProperties() == ItemProperties.DOOR && keys > 0) {
            item.pickUp(true);
            keys--;
        }
    }

    public static void useFromInventory() {
        if(potions > 0 && player.getHealth() < Config.DEFAULT_PLAYER_HEALTH && KeyAction.usePotion) {
            potionCounter++;
            if (potionCounter == 10) {
                    player.setHealth(Config.DEFAULT_PLAYER_HEALTH- player.getHealth());
                    potions--;
                }
                potionCounter = 0;
        }
    }

    public void renderInventoryValue(Graphics2D g2d) {
        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRoundRect(1130, 10, 575, 70, 10, 10);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString(String.valueOf(coins), 1220, 65);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString(String.valueOf(keys), 1420, 65);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 50));
        g2d.drawString(String.valueOf(potions), 1620, 65);
    }

    public void renderInventoryImages(Graphics2D g2d) {
        g2d.drawImage(ItemProperties.COIN.getImage(), 1150, 20, 50,50, null);
        g2d.drawImage(ItemProperties.KEY.getImage(), 1350, 20, 50,50,null);
        g2d.drawImage(ItemProperties.POTION.getImage(), 1550, 20, 50,50,null);
    }

    public void renderPlayerHP(Graphics2D g2d) {

        double playerHealth = player.getHealth();
        double playerMaxHealth = Config.DEFAULT_PLAYER_HEALTH;
        int barWidth = 200;
        int playerHealthBar = (int) ((playerHealth / playerMaxHealth) * barWidth);

        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRoundRect(100, 10,320, 50, 10, 10);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("HEALTH:" ,110, 43);

        g2d.setColor(new Color(50,0,0));
        g2d.fillRoundRect( 200, 20, barWidth + 6, 31, 10, 10);

        g2d.setColor(new Color(255,0,60));
        g2d.fillRoundRect( 203, 23, playerHealthBar, 25, 10, 10);
    }

    public void renderPlayerStamina(Graphics2D g2d) {

        double playerStamina = player.getStamina();
        double playerMaxStamina = Config.DEFAULT_PLAYER_STAMINA;
        int barWidth = 200;
        int playerStaminaBar = (int) ((playerStamina / playerMaxStamina) * barWidth);

        g2d.setColor(new Color(0,0,0,150));
        g2d.fillRoundRect(500, 10,330, 50, 10, 10);

        g2d.setColor(new Color(255,255,255));
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString("STAMINA:" ,510, 43);

        g2d.setColor(new Color(20,0,90));
        g2d.fillRoundRect( 610, 20, barWidth + 6, 31, 10, 10);

        g2d.setColor(new Color(50,100,255));
        g2d.fillRoundRect( 613, 23, playerStaminaBar, 25, 10, 10);
    }
}

