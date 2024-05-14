package dungeonCrawlerGame.items;

import java.awt.image.BufferedImage;

public interface Item {

    public void use();
    public void drop();
    public void pickUp(boolean pickedUp);
    public BufferedImage getImage();
    public int getPosX();
    public int getPosY();
    public int getLocationNumber();
    public ItemProperties getItemProperties();
    public void setPosX(int posX);
    public void setPosY(int posY);
    public void setLocationNumber(int locationNumber);
    public boolean isPickedUp();
    public void setInRange(boolean inRange);
}
