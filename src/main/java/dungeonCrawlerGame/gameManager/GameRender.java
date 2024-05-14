package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;

import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.locations.LocationRender;


import java.awt.*;
import java.awt.image.BufferStrategy;

import static dungeonCrawlerGame.gameWindow.GameFrame.game;

public class GameRender {

    public static void renderGame(){

        BufferStrategy bufferStrategy = game.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) graphics;

        //Set background color
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, game.getWidth(), game.getHeight());

        //Draw current location
        LocationRender.drawCurrentLocation(g2d);

        //Draw player
        g2d.drawImage(GameInit.player.getImage(),GameInit.player.getPosX(), GameInit.player.getPosY() , Config.CELL_SIZE, Config.CELL_SIZE, null);

        //Draw items in current location
        GameInit.items.drawItems(g2d);

        //Draw monsters in current location
        GameInit.monsters.drawMonsters(g2d);

        //Draw player health bar
        GameInit.playerState.renderPlayerHP(g2d);

        //Draw player attack bar
        GameInit.playerState.renderPlayerStamina(g2d);
        GameInit.playerState.renderInventoryValue(g2d);
        GameInit.playerState.renderInventoryImages(g2d);

        graphics.dispose();
        bufferStrategy.show();
    }
}
