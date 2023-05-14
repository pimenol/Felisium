package Inventorys;

import Entity.Player;
import main_pjv.MusicPlayer;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Key extends Objects {

    private MusicPlayer musicPlayer=new MusicPlayer();
    public Key() {
        name="key";
        collision=true;
        try{
            img= ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void pickUp(Player player,int inx){
        musicPlayer.play("/music/UrrCat.wav");
        musicPlayer.stop();
        player.getGp().obj[inx]=null;
        player.setKeyCount(player.getKeyCount()+1);
    }
}
