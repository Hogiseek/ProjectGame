package org.example.logic;

import org.example.Draw;

import java.awt.*;

public class Island extends Draw {

    public Island(String file,int x, int y) {
        setWidth(50);
        setHeight(50);
        setX(x);
        setImage(file);
        setY(y);


    }

    public void update(){
        y+= 1;
    }

}

