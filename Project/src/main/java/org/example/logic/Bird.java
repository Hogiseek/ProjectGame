package org.example.logic;

import java.util.ArrayList;

public class Bird extends Draw {
    private int moveRight= 2; // rychlost při které se pohybuje doprava
    private int screenWidth; // šířka screenu

    public Bird(String file, int x, int y, int width, int height, int screenWidth){
        setImage(file);
        setWidth(50);
        setHeight(50);
        setX(x);
        setY(y);
        this.screenWidth= screenWidth;
    }
    public void update() {
        x+= moveRight; // pohybuje ptáka doprava
        if (x > screenWidth) {
            resetPosition();
        }
    }
    private void resetPosition() {
        x= -width; // přemístí ptáčka doleva
    }
}
