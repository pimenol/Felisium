package Entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, rigth2,sleep;
    public int spriteCounter=0, waitCounter=0;
    public int spriteNum=1, waitNum=1;
    public String direction;
    public int armor;
    public Life live;


}
