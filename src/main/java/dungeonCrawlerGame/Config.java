package dungeonCrawlerGame;

public class Config {
    public static final int CELL_PIXEL = 32;
    public static final int SCALE = 3;

    public static final int CELL_SIZE = CELL_PIXEL * SCALE; //48x48 pixel
    public static final int LOCATION_COLUMN = 18;
    public static final int LOCATION_ROW = 10;
    public static final int LOCATION_WIDTH = LOCATION_COLUMN * CELL_SIZE;
    public static final int LOCATION_HEIGHT = LOCATION_ROW * CELL_SIZE;
    public static final int FPS = 60;
    public static final double INTERVAL = (double) 1000000000 /FPS;
    public static final int DEFAULT_PLAYER_SPEED = 4;
    public static final int DEFAULT_PLAYER_HEALTH = 100;
    public static final int DEFAULT_PLAYER_DAMAGE = 20;
    public static final int DEFAULT_PLAYER_STAMINA = 100;
    public static final int STAMINA_REDUCE = 10;
}
