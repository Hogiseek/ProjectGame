package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameGraphics extends JFrame{
    Draw draw;
    GameLogic logic;
    BufferedImage image;

    public GameGraphics(GameLogic logic) throws HeadlessException {
        this.draw= new Draw();
        this.logic= logic;


        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Jumping Crown");

    }

    public void update(GameLogic logic) {
    }


    public class Draw extends JPanel {


    }
}
