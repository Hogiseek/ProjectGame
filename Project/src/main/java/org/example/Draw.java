package org.example;

import org.example.logic.BackGround;

import javax.swing.*;
import java.awt.*;

public class Draw{
    GameLogic logic;
    Draw(GameLogic logic){
        this.logic = logic;

    }
    public void render(Graphics g){
        for (BackGround backGround: logic.backGrounds){
            backGround.draw(g);
        logic.player.draw(g);


        }

    }

}
