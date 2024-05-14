package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.controller.KeyAction;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static JPanel panel;
    public static Canvas game;
    public static Canvas start;
    public static Canvas gameOver;
    public static JFrame frame;

    public GameFrame(int width, int height) {
        setTitle("Dungeon Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        frame = this;

        /*panel = new JPanel();
        panel.setLayout(new CardLayout());
        panel.setPreferredSize(new Dimension(width, height));
        panel.setFocusable(false);

        start = new Canvas();
        start.setPreferredSize(new Dimension(width, height));
        start.setFocusable(false);

        gameOver = new Canvas();
        gameOver.setPreferredSize(new Dimension(width, height));
        gameOver.setFocusable(false);*/

        game = new Canvas();
        game.setPreferredSize(new Dimension(width, height));
        game.setFocusable(false);

        addKeyListener(new KeyAction());
        add(game);
        /*panel.add(start);
        panel.add(game);
        panel.add(gameOver);*/

        //add(panel);
        pack();
        game.createBufferStrategy(2);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
