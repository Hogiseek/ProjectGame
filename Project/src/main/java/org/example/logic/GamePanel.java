package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    int width= 1080, height= 720;
    Draw draw;
    GameLogic logic;


    GamePanel(){
        logic = new GameLogic();
        draw = new Draw(logic);
        setPreferredSize(new Dimension(width, height));
        Thread thread= new Thread(this);
        thread.start();
        addKeyListener(logic.player);
        setFocusable(true);
        requestFocus();


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw.render(g);
    }

    @Override
    public void run() {
        while (true){
            logic.update();
            repaint();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
