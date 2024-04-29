package org.example;

import javax.swing.*;
import java.awt.*;

public class Draw{
    GameLogic logic;
    Draw(GameLogic logic){
        this.logic = logic;

    }
    public void render(Graphics g){
        logic.backGround.draw(g);
        logic.player.draw(g);

    }

}
