package org.example.logic;

import org.example.Draw;

import java.awt.*;

public class BackGround extends Draw {

    public BackGround(String file, int y) {
        setWidth(1080);
        setHeight(720);
        setImage(file);
        setY(y);


    }
    public void update(){

    }
}
