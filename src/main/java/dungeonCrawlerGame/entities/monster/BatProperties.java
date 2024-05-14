package dungeonCrawlerGame.entities.monster;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum BatProperties {
    BAT_UP1(50, 10, 1, 4,"/Monsters/Bat_Up1.png"),
    BAT_UP2(50, 10, 1, 4,"/Monsters/Bat_Up2.png"),
    BAT_DOWN1(50, 10, 1, 4,"/Monsters/Bat_Down1.png"),
    BAT_DOWN2(50, 10, 1, 4,"/Monsters/Bat_Down2.png"),
    BAT_RIGHT1(50, 10, 1, 4,"/Monsters/Bat_Right1.png"),
    BAT_RIGHT2(50, 10, 1, 4,"/Monsters/Bat_Right2.png"),
    BAT_LEFT1(50, 10, 1, 4,"/Monsters/Bat_Left1.png"),
    BAT_LEFT2(50, 10, 1, 4,"/Monsters/Bat_Left2.png");


    private final int health;
    private final int damage;
    private final int speed;
    private final int huntingSpeed;
    private final String path;
    private BufferedImage image;

    BatProperties(int health, int damage, int speed, int huntingSpeed, String path) {
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.huntingSpeed = huntingSpeed;
        this.path = path;
        try{
            this.image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getHealth(BatProperties enemy) {
        return enemy.health;
    }

    public static int getDamage(BatProperties enemy) {
        return enemy.damage;
    }

    public static int getSpeed(BatProperties enemy) {
        return enemy.speed;
    }

    public static int getHuntingSpeed(BatProperties enemy) {
        return enemy.huntingSpeed;
    }

    public BufferedImage getImage() {
        return image;
    }

}
