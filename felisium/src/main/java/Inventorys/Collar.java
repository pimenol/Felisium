package Inventorys;

import Entity.Player;
import main_pjv.GamePannel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Collar extends Objects{
    public Collar(GamePannel gp) {
        name="collar";
        collision=true;
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/objects/collar.png"));
            img=utils.scaleImg(img,gp.getTileSize(),gp.getTileSize());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void pickUp(Player player,int inx){

    }
}
