package Inventorys;

import Entity.Player;
import main_pjv.GamePannel;
import main_pjv.MusicPlayer;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Wing extends Objects{

    private MusicPlayer musicPlayer=new MusicPlayer();
    public Wing(GamePannel gp) {
        name="wing";
        collision=true;
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/objects/wing.png"));
            img=utils.scaleImg(img,gp.getTileSize(),gp.getTileSize());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void pickUp(Player player, int inx){
        musicPlayer.play("/music/UrrCat.wav");
        musicPlayer.stop();
        player.getGp().obj[inx]=null;
        player.setHasWings(true);
        player.getGp().getUi().setGameFinished(true);
    }

}