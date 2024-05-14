package dungeonCrawlerGame.locations;

import dungeonCrawlerGame.Config;

import java.awt.*;

public class LocationRender {

    private static Cells[][] currentLocation;
    static Cells cell;

    public static void getNewLocation() {
        currentLocation = Location.returnLocation(DungeonMap.getCurrentWorldLocation());
    }

    public static void drawCurrentLocation(Graphics g2) {

        int col = currentLocation.length;
        int row = currentLocation[0].length;

        int j = 0;
        int i = 0;

        int x = 0;
        int y = 0;

        for (i = 0; i < col; i++) {
            for (j = 0; j < row; j++) {
                cell = currentLocation[i][j];
                g2.drawImage(cell.getImage(), x, y, Config.CELL_SIZE, Config.CELL_SIZE, null);
                x += Config.CELL_SIZE;
            }
            y += Config.CELL_SIZE;
            x = 0;
        }
    }
}
