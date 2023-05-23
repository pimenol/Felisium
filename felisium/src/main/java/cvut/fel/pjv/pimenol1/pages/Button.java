package cvut.fel.pjv.pimenol1.pages;

import cvut.fel.pjv.pimenol1.main.Constants;
import cvut.fel.pjv.pimenol1.main.Felisium;
import cvut.fel.pjv.pimenol1.main.GameState;
import cvut.fel.pjv.pimenol1.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {
    private final int buttonWidth = 290;
    private final int buttonHight = 75;
    private int originButtonWidth;
    private int originButtonHight;
    private int xPos, yPos, rowIndex, index;
    private GameState state;
    private BufferedImage[] images = new BufferedImage[3];
    private boolean mouseOver, mousePressed;
    private Rectangle hitBox;

    public Button(int xPos, int yPos, int rowIndex, String nameFile, int originButtonWidth, int originButtonHight, GameState state) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.rowIndex = rowIndex;
        this.originButtonHight = originButtonHight;
        this.originButtonWidth = originButtonWidth;
        this.state=state;
        loadButtonImages(nameFile);
        initHitBox();
    }

    private void initHitBox() {
        this.hitBox = new Rectangle(xPos, yPos, buttonWidth, buttonHight);
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(images[index], xPos, yPos, buttonWidth, buttonHight, null);
    }

    public void update() {
        this.index = 0;
        if (this.mouseOver)
            this.index = 1;
        if (this.mousePressed)
            this.index = 2;
    }

    private void loadButtonImages(String nameFile) {
        BufferedImage temp = Utils.load_image("button", nameFile);
        for (int i = 0; i < images.length; i++)
            images[i] = temp.getSubimage(i * originButtonWidth, rowIndex * originButtonHight, originButtonWidth, originButtonHight);
    }


    public void applyGameStatePlay() {
        Constants.gameStatePlay = state;
        Felisium.logger.info("Button " + state + "pressed.");
    }
    public void applyGameState() {
        Constants.gameState= state;
    }

    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
    }

    public boolean isMousePressed() {
        return this.mousePressed;
    }

    public void setMousePressed(boolean mousePressed) {
        this.mousePressed = mousePressed;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    public void resetBooleans() {
        this.mouseOver = false;
        this.mousePressed = false;
    }
}