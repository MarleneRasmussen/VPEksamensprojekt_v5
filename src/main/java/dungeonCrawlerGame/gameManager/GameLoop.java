package dungeonCrawlerGame.gameManager;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameWindow.GameInit;

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

        while (running){
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
    }
}
