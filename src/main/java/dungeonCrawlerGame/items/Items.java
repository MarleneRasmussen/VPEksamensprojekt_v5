package dungeonCrawlerGame.items;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.entities.player.PlayerState;
import dungeonCrawlerGame.locations.DungeonMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Items {

    private static List<ItemObject> items;

    public Items() {
        items = new ArrayList<ItemObject>();
    }

    public void addItem(ItemObject item) {
        items.add(item);
    }


    public void checkIfPickedUp() {
        for (ItemObject item : items) {
            if (item.isPickedUp()) {
                //Location number 0 is for picked up items
                item.setLocationNumber(0);
                PlayerState.addItemToInventory(item);
                item.pickUp(false);
            }
        }
    }

    public static List<ItemObject> getItem() {
        return items;
    }

    public void drawItems(Graphics2D g2d) {
        for (ItemObject item : items) {
            if (item.getLocationNumber() == DungeonMap.getCurrentWorldLocation()) {
                if (item.getItemProperties() == ItemProperties.DOOR) {
                    g2d.drawImage(item.getImage(), item.getPosX(), item.getPosY(), Config.CELL_SIZE * 2, Config.CELL_SIZE, null);
                } else {
                    g2d.drawImage(item.getImage(), item.getPosX(), item.getPosY(), Config.CELL_SIZE, Config.CELL_SIZE, null);

                }
            }
        }
    }
}
