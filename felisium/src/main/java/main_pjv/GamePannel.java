package main_pjv;

import Entity.Player;
import Objects.Objects;
import background.TileManager;

import javax.swing.JPanel;
import java.awt.*;

public class GamePannel extends JPanel implements Runnable {
    // SCREEN SETTINGS
    private final int originalTileSize = 16;
    private final int scale = 3;

    private final int tileSize = originalTileSize * scale;
    private final int maxScreenCol = 16;
    private final int maxScreenRow = 12;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    //    WORLD SETTINGS
    private final int maxWorldCol = 50;
    private final int maxWorldRow = 50;
    private final int maxWorldHigh = maxWorldRow * tileSize;
    private final int maxWorldWidth = tileSize * maxWorldCol;


    private final int FPS = 100;
    private final KeyHandler kh = new KeyHandler();
    private final TileManager tileManager = new TileManager(this);
    private Thread gameThread;
    public Player player = new Player(this, kh);
    private CheckerCollision checkerCollision = new CheckerCollision(this);

    public Objects[] obj =new Objects[10];
    private AssetSetter assetSetter=new AssetSetter(this);

    public GamePannel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }
    public void setUpGame(){
        assetSetter.setObjects();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
//        MusicPlayer musicPlayer=new MusicPlayer();
//        musicPlayer.play("/music/musBegin.wav");
        double drawInterval = (double) 1000000000 / FPS;
        double nexDrowTime = System.nanoTime() + drawInterval;

        while (gameThread != null) {
            update();
            repaint();

            try {
                double remainingTime = nexDrowTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) remainingTime = 0;

                Thread.sleep((long) remainingTime);
                nexDrowTime += drawInterval;

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }


    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        for(int i=0;i<obj.length;i++){
            if(obj[i]!=null){
                obj[i].draw(g2,this);
            }
        }
        player.draw(g2);
        g2.dispose();
    }

    public int getOriginalTileSize() {
        return originalTileSize;
    }

    public int getScale() {
        return scale;
    }

    public int getFPS() {
        return FPS;
    }

    public KeyHandler getKh() {
        return kh;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMaxWorldCol() {
        return maxWorldCol;
    }

    public int getMaxWorldRow() {
        return maxWorldRow;
    }

    public int getMaxWorldHigh() {
        return maxWorldHigh;
    }

    public int getMaxWorldWidth() {
        return maxWorldWidth;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getMaxScreenCol() {
        return maxScreenCol;
    }

    public int getMaxScreenRow() {
        return maxScreenRow;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public CheckerCollision getCheckerCollision() {
        return checkerCollision;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCheckerCollision(CheckerCollision checkerCollision) {
        this.checkerCollision = checkerCollision;
    }

    public Object[] getObj() {
        return obj;
    }

    public AssetSetter getAssetSetter() {
        return assetSetter;
    }

    public void setAssetSetter(AssetSetter assetSetter) {
        this.assetSetter = assetSetter;
    }
}