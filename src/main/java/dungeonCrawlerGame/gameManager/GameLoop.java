package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameFrame;
import dungeonCrawlerGame.gameWindow.GameInit;
import dungeonCrawlerGame.gameWindow.menu.GameOver;

public class GameLoop implements Runnable{

    private GameInit game;
    private boolean running;

    public GameLoop(GameInit game){
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double nextDraw = System.nanoTime() + Config.INTERVAL;

        while (running && GameInit.gameState != GameInit.gameOver){
            GameInit.updateGame();
            GameInit.renderGame();

            try {
                double remaining = nextDraw - System.nanoTime();
                if(remaining > 0)
                    Thread.sleep((long) (remaining / 1000000));
                nextDraw += Config.INTERVAL;
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
        if (GameInit.gameState == GameInit.gameOver){
            Thread.currentThread().interrupt();
            GameFrame.game.setVisible(false);
            GameFrame.gameOver = new GameOver();
            GameFrame.gameOver.setVisible(true);
        }
    }
}
