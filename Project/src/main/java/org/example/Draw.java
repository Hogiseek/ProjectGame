package org.example;

import org.example.logic.BackGround;
import org.example.logic.Coordinates;
import org.example.logic.Island;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Draw extends Coordinates {
    public Draw() {
    }

    public Rectangle getRect(){
        return new Rectangle(x, y, width, height);
    }
    int width, height;
    BufferedImage image;
    GameLogic logic;
    Draw(GameLogic logic){
        this.logic = logic;

    }
    private void loadImage(String file){
        try {
            image= ImageIO.read(new File("src/main/resources/"+file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void draw (Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }
    public void render(Graphics g){
        for (BackGround backGround: logic.backGrounds){
            backGround.draw(g);
        logic.player.draw(g);

        }
        for (Island island: logic.islands){
            island.draw(g);


        }

    }
    public void setImage(String file) {
        loadImage(file);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

