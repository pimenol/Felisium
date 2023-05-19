package cvut.fel.pjv.pimenol1.inventorys;

import cvut.fel.pjv.pimenol1.entity.Player;
import cvut.fel.pjv.pimenol1.utils.MusicPlayer;

public class Key extends Item {

    private MusicPlayer musicPlayer = new MusicPlayer();

    public Key(int i, int x, int y) {
        super("key",i,x,y);
        name = "key";
        collision = true;
    }

    @Override
    public void pickUp(Player player, int inx) {
        musicPlayer.play("/music/UrrCat.wav");
        musicPlayer.stop();
        player.setKeyCount(player.getKeyCount() + 1);
    }
}
