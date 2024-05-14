package dungeonCrawlerGame.gameWindow.menu;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameManager.GameLoop;
import dungeonCrawlerGame.gameWindow.GameInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame implements ActionListener {

    private JButton exitButton;
    private JButton restartButton;

        public GameOver() {
            JLabel gameOver = new JLabel("Game Over");
            gameOver.setBounds(200, 200, 400, 50);
            gameOver.setForeground(Color.WHITE);
            gameOver.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 50));
            add(gameOver);

            exitButton = new JButton("Exit Game");
            exitButton.setBounds(300, 300, 200, 50);
            exitButton.addActionListener(this);
            exitButton.setFocusable(false);
            exitButton.setContentAreaFilled(false);
            exitButton.setBorderPainted(false);
            exitButton.setFocusPainted(false);
            exitButton.setForeground(Color.WHITE);
            exitButton.setFont(new Font("Arial", Font.PLAIN, 30));
            add(exitButton);

            restartButton = new JButton("Restart Game");
            restartButton.setBounds(300, 400, 200, 50);
            restartButton.addActionListener(this);
            restartButton.setFocusable(false);
            restartButton.setContentAreaFilled(false);
            restartButton.setBorderPainted(false);
            restartButton.setFocusPainted(false);
            restartButton.setForeground(Color.WHITE);
            restartButton.setFont(new Font("Arial", Font.PLAIN, 30));
            add(restartButton);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
        if (e.getSource() == restartButton) {
            GameInit game = new GameInit(Config.LOCATION_WIDTH, Config.LOCATION_HEIGHT);
            new Thread(new GameLoop(game)).start();
        }
    }
}
