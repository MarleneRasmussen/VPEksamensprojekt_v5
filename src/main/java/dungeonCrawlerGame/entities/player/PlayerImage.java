package dungeonCrawlerGame.entities.player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum PlayerImage {
    //Player
    PLAYER_UP1("/Player/PlayerUP_1.png"),
    PLAYER_UP2("/Player/PlayerUp_2.png"),
    PLAYER_DOWN1("/Player/PlayerDown_1.png"),
    PLAYER_DOWN2("/Player/PlayerDown_2.png"),
    PLAYER_LEFT1("/Player/PlayerLeft_1.png"),
    PLAYER_LEFT2("/Player/PlayerLeft_2.png"),
    PLAYER_RIGHT1("/Player/PlayerRight_1.png"),
    PLAYER_RIGHT2("/Player/PlayerRight_2.png");

    //Monsters
    //GHOST_UP1("/Monsters/GohstUp_1.png"),
    //GHOST_UP2("/Monsters/GohstUp_2.png"),
    //GHOST_DOWN1("/Monsters/GohstDown_1.png"),
    //GHOST_DOWN2("/Monsters/GohstDown_2.png"),
    //GHOST_LEFT1("/Monsters/GohstLeft_1.png"),
    //GHOST_LEFT2("/Monsters/GohstLeft_2.png"),
    //GHOST_RIGHT1("/Monsters/GohstRight_1.png"),
    //GHOST_RIGHT2("/Monsters/GohstRight_2.png");

    private final BufferedImage image;

    PlayerImage(String path) {
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage getImage() {
        return image;
    }
}
