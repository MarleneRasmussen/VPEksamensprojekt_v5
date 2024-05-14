package dungeonCrawlerGame.gameWindow.menu;

import dungeonCrawlerGame.Config;
import dungeonCrawlerGame.gameManager.GameLoop;
import dungeonCrawlerGame.gameWindow.GameFrame;
import dungeonCrawlerGame.gameWindow.GameInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartMenu extends JFrame implements ActionListener {

    private JButton startButton;
    private JButton exitButton;

    public StartMenu() {

        setTitle("Dungeon Crawler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        startButton = new JButton("START GAME!");
        startButton.setBounds(200, 200, 400, 50);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Arial", Font.PLAIN, 50));

        exitButton = new JButton("Exit Game");
        exitButton.setBounds(300, 300, 200, 50);
        exitButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("Arial", Font.PLAIN, 30));

        add(startButton);
        add(exitButton);

        startButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                startButton.setFont(new Font("Arial", Font.BOLD, 50));
            }

            public void mouseExited(MouseEvent e) {
                startButton.setFont(new Font("Arial", Font.PLAIN, 50));
            }
        });

        exitButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                exitButton.setFont(new Font("Arial", Font.BOLD, 30));
            }

            public void mouseExited(MouseEvent e) {
                exitButton.setFont(new Font("Arial", Font.PLAIN, 30));
            }
        });

        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            GameInit game = new GameInit(Config.LOCATION_WIDTH, Config.LOCATION_HEIGHT);
            new Thread(new GameLoop(game)).start();

        }
        if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}