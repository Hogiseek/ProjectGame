package org.example.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Draw extends Coordinates {
    BufferedImage image;
    int width, height;

    Draw(){

    }
    private void loadImage(String file){
        try {
            image= ImageIO.read(getClass().getResource("/"+file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void draw (Graphics g) {
        g.drawImage(image, x, y, width, height, null);
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

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }
}

