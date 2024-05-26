package org.example.logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    int width= 1080, height= 720;
    Draw draw;
    GameLogic logic;
    BufferedImage menu, background;



    GamePanel(){
        addKeyListener(logic);
        logic = new GameLogic();
        draw = new Draw(logic);
        setPreferredSize(new Dimension(width, height));
        Thread thread= new Thread(this);
        thread.start();
        addKeyListener(logic.player);
        setFocusable(true);
        requestFocus();
        try {
            menu= ImageIO.read(new File("src/main/resources/Menu_Project.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw.render(g);
        if (logic.phase== 0){
            g.drawImage(menu, 0, 0, 1080, 720, null);
        }
        if (logic.phase== 1){
            g.drawImage(background, 0, 0, 1080, 720, null);
                logic.backGround.draw(g);
                logic.player.draw(g);
                for (Island island: logic.islands){
                    island.draw(g);

                }
                for (Bird bird: logic.birds){
                    bird.draw(g);
                }
            }
        }

    @Override
    public void run() {
        while (true){
            if (logic.phase== 1){
                logic.update();
            }
            repaint();

            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
