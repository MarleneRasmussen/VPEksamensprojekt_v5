package dungeonCrawlerGame.controller;

import dungeonCrawlerGame.gameWindow.GameInit;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyAction implements KeyListener {

    public static boolean up, down, left, right, attack, usePotion, useKey = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            up = true;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = true;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = true;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = true;
        }
        if (key == KeyEvent.VK_ESCAPE) {
            if (GameInit.gameState == GameInit.gameRunning){
                GameInit.gameState = GameInit.gamePaused;
            } else if (GameInit.gameState == GameInit.gamePaused){
                GameInit.gameState = GameInit.gameRunning;
            }
        }
        if (key == KeyEvent.VK_SPACE) {
            attack = true;
        }
        if (key == KeyEvent.VK_P){
            usePotion = true;
        }
        if (key == KeyEvent.VK_K){
            useKey = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_UP) {
            up = false;
        }
        if (key == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (key == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (key == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (key == KeyEvent.VK_SPACE) {
            attack = false;
        }
        if (key == KeyEvent.VK_P){
            usePotion = false;
        }
        if (key == KeyEvent.VK_K){
            useKey = false;
        }
    }
}