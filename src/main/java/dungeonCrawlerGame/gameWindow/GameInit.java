package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.controller.Direction;
import dungeonCrawlerGame.entities.monster.BatProperties;
import dungeonCrawlerGame.entities.monster.Monster;
import dungeonCrawlerGame.entities.player.Player;
import dungeonCrawlerGame.entities.monster.Monsters;
import dungeonCrawlerGame.entities.player.PlayerState;
import dungeonCrawlerGame.gameManager.GameUpdate;
import dungeonCrawlerGame.items.ItemObject;
import dungeonCrawlerGame.items.ItemProperties;
import dungeonCrawlerGame.locations.DungeonMap;
import dungeonCrawlerGame.gameManager.GameRender;

public class GameInit {

    public static Monsters monsters;
    public static Player player;
    public static dungeonCrawlerGame.items.Items items;
    public static PlayerState playerState;
    public static int currentLocationNum;

    public static int gameState;

    public static final int gameRunning = 1;
    public static final int gamePaused = 2;
    public static final int gameOver = 3;

    public GameInit(int width, int height) {
        GameFrame gameFrame = new GameFrame(width, height);

        gameState = gameRunning;

        DungeonMap.setDefaultLocation();

        player = new Player();
        playerState = new PlayerState();

        items = new dungeonCrawlerGame.items.Items();
        monsters = new Monsters();

        //Location 1
        items.addItem(new ItemObject(2 * Config.CELL_SIZE,2 * Config.CELL_SIZE, 1, ItemProperties.KEY));
        items.addItem(new ItemObject(14 * Config.CELL_SIZE,9 * Config.CELL_SIZE, 1, ItemProperties.DOOR));
        monsters.addMonster(new Monster(600,600,1, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,1, Direction.UP, BatProperties.BAT_UP1));

        //Location 2
        items.addItem(new ItemObject(7 * Config.CELL_SIZE,5 * Config.CELL_SIZE, 2, ItemProperties.DOOR));
        items.addItem(new ItemObject(6 * Config.CELL_SIZE, Config.CELL_SIZE, 2, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,2, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,2, Direction.UP, BatProperties.BAT_UP1));

        //Location 3
        items.addItem(new ItemObject(3 * Config.CELL_SIZE,5 * Config.CELL_SIZE, 3, ItemProperties.DOOR));
        items.addItem(new ItemObject(13 * Config.CELL_SIZE,9 * Config.CELL_SIZE, 3, ItemProperties.DOOR));
        items.addItem(new ItemObject(10 * Config.CELL_SIZE, 3 * Config.CELL_SIZE, 3, ItemProperties.KEY));
        items.addItem(new ItemObject(Config.CELL_SIZE,8 * Config.CELL_SIZE, 3, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,3, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,3, Direction.UP, BatProperties.BAT_UP1));

        //Location 4
        items.addItem(new ItemObject(5 * Config.CELL_SIZE,9 * Config.CELL_SIZE, 4, ItemProperties.DOOR));
        monsters.addMonster(new Monster(600,600,4, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,4, Direction.UP, BatProperties.BAT_UP1));

        //Location 5
        items.addItem(new ItemObject(14 * Config.CELL_SIZE,6 * Config.CELL_SIZE, 5, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,5, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,5, Direction.UP, BatProperties.BAT_UP1));

        //Location 6
        items.addItem(new ItemObject(13 * Config.CELL_SIZE,9 * Config.CELL_SIZE, 6, ItemProperties.DOOR));
        items.addItem(new ItemObject(2* Config.CELL_SIZE,2 * Config.CELL_SIZE, 6, ItemProperties.KEY));
        monsters.addMonster(new Monster(600,600,6, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,6, Direction.UP, BatProperties.BAT_UP1));

        //Location 7
        items.addItem(new ItemObject(6 * Config.CELL_SIZE,2*Config.CELL_SIZE, 7, ItemProperties.KEY));
        items.addItem(new ItemObject(16 * Config.CELL_SIZE,8*Config.CELL_SIZE, 7, ItemProperties.KEY));
        items.addItem(new ItemObject(3 * Config.CELL_SIZE,Config.CELL_SIZE, 7, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,7, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,7, Direction.UP, BatProperties.BAT_UP1));

        //Location 8
        monsters.addMonster(new Monster(600,600,8, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,8, Direction.UP, BatProperties.BAT_UP1));

        //Location 9
        items.addItem(new ItemObject(2*Config.CELL_SIZE,2 * Config.CELL_SIZE, 9, ItemProperties.KEY));
        monsters.addMonster(new Monster(600,600,9, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,9, Direction.UP, BatProperties.BAT_UP1));

        //Location 10
        items.addItem(new ItemObject(11 * Config.CELL_SIZE,6 * Config.CELL_SIZE, 10, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,10, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,10, Direction.UP, BatProperties.BAT_UP1));

        //Location 11
        items.addItem(new ItemObject(5*Config.CELL_SIZE,8 * Config.CELL_SIZE, 11, ItemProperties.KEY));
        monsters.addMonster(new Monster(600,600,11, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,11, Direction.UP, BatProperties.BAT_UP1));

        //Location 12
        items.addItem(new ItemObject(8 * Config.CELL_SIZE,6 * Config.CELL_SIZE, 12, ItemProperties.DOOR));
        items.addItem(new ItemObject(9 * Config.CELL_SIZE,4 * Config.CELL_SIZE, 12, ItemProperties.POTION));
        monsters.addMonster(new Monster(600,600,12, Direction.UP, BatProperties.BAT_UP1));
        monsters.addMonster(new Monster(600,600,12, Direction.UP, BatProperties.BAT_UP1));

    }

    public static void renderGame() {
        GameRender.renderGame();
    }

    public static void updateGame() {
        GameUpdate.updateGame();
    }
}
