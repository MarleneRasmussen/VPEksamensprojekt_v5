package dungeonCrawlerGame.gameWindow;

import dungeonCrawlerGame.controller.KeyAction;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static Canvas canvas;

    public GameFrame(int width, int height) {
        setTitle("Dungeon Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);

        addKeyListener(new KeyAction());
        add(canvas);
        pack();

        canvas.createBufferStrategy(2);

        setLocationRelativeTo(null);
        setVisible(true);
    }

}
