package org.example.logic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{
    int width= 1080, height= 720;
    GameLogic logic;
    BufferedImage menu;
    BufferedImage rules;
    BufferedImage gameover;

    GamePanel(){
        logic = new GameLogic();
        setPreferredSize(new Dimension(width, height));
        Thread thread= new Thread(this);
        thread.start();
        addKeyListener(logic.player);
        addKeyListener(logic);
        setFocusable(true);
        requestFocus();
        try {
            menu= ImageIO.read(getClass().getResource("/Menu_Project.png"));
            rules= ImageIO.read(getClass().getResource("/Rules_Project.png"));
            gameover= ImageIO.read(getClass().getResource("/GameOver_Project.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (logic.phase== 3) {
            g.drawImage(gameover, 0, 0, width, height, null);
            logic.stopTimer();
        }
        if (logic.phase== 0){
            g.drawImage(menu, 0, 0, 1080, 720, null);
            if(logic.rules){
                g.drawImage(rules,0,0,width,height, null);
            }
        }
        if (logic.phase== 1){
            logic.backGround.draw(g);
            for (Island island: logic.islands){
                island.draw(g);
            }
            logic.player.draw(g);
            for (Bird bird: logic.birds){
                bird.draw(g);
            }
            for (Arrow arrow: logic.arrows){
                arrow.draw(g);
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font("Kristen ITC", Font.BOLD, 16));
            g.drawString("Time: " + logic.formatTime(logic.gameDurationInSeconds), 10, 20);
        }
    }

    @Override
    public void run() {
        while (true){
            if(logic.phase != 0 && logic.phase != 3){
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
