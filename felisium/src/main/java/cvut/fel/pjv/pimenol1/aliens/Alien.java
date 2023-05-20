package cvut.fel.pjv.pimenol1.aliens;

import cvut.fel.pjv.pimenol1.entity.Entity;
import cvut.fel.pjv.pimenol1.main.Constants;
import cvut.fel.pjv.pimenol1.main.PlayingPage;
import cvut.fel.pjv.pimenol1.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Alien extends Entity {

    private int imgSize = 30;
    protected int damage=1;
    private BufferedImage[] imgLeft = new BufferedImage[4];
    private BufferedImage[] imgRight = new BufferedImage[4];
    private int sum =25;

    public Alien(String path, String name, int x, int y, PlayingPage pp) {
        super(name, pp);

        xWorld = x;
        yWorld = y;

        speed = 1;
        maxLife = 3;
        life = maxLife;


        hitBox.height=Constants.TILE_SIZE+sum;
        hitBox.width=Constants.TILE_SIZE+sum;
        defultHitBoxX = hitBox.x;
        defultHitBoxY = hitBox.y;

        direction="right";
        maxSprite=4;
        this.timeUpdate=12;
        getEntityImg("enemy");

        for (int i = 0; i < maxSprite; i++) {

            left_a[i] = Utils.scaleImg(left_a[i], Constants.TILE_SIZE+sum, Constants.TILE_SIZE+sum);
            right_a[i] = Utils.scaleImg(right_a[i], Constants.TILE_SIZE+sum, Constants.TILE_SIZE+sum);
            up_a[i] = Utils.scaleImg(up_a[i], Constants.TILE_SIZE+sum, Constants.TILE_SIZE+sum);
            down_a[i] = Utils.scaleImg(down_a[i], Constants.TILE_SIZE+sum, Constants.TILE_SIZE+sum);
        }

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
