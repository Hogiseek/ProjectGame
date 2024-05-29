package org.example.logic;

import java.util.ArrayList;

public class Arrow extends Draw {
    public static int fallspeed= 6; // rychlost při které se pohybuje dolů
    private int screenHeight; // výška screenu

    public Arrow(String file, int x, int y, int width, int height, int screenHeight) {
        setImage(file);
        setWidth(50);
        setHeight(50);
        setX(x);
        setY(y);
        this.screenHeight= screenHeight;
    }

    public void update() {
        y+= fallspeed; // pohybuje šípem dolů
        if (y > screenHeight) {
            resetPosition();
        }
    }
    private void resetPosition() {
        y= -height; // přemístí šíp nahoru
    }
}
