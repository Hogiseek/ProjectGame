package org.example.logic;

public class Island extends Draw {
    private int fallSpeed= 2; // rychlost při které padá
    private int screenHeight; // výška screenu

    public Island(String file,int x, int y, int width, int height, int screenHeight) {
        setWidth(50);
        setHeight(50);
        setX(x);
        setImage(file);
        setY(y);
        this.screenHeight= screenHeight;


    }

    public void update() {
        y+= fallSpeed; // pohybuje Island dolů
        if (y > screenHeight) {
            resetPosition();
        }

    }

    private void resetPosition() {
        y= -height; // přemístí island nahoru
    }

}

