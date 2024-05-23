package org.example.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Player extends Draw implements KeyListener {
    boolean LEFT, RIGHT, JUMP;
    public int velocity = 0;
    private Timer jumpTimer;
    public boolean canJump = true;
    private final int frameHeight = 720;
    private final int frameWidth = 1080;


    public Player() {
        setImage("King_JumpR.png");
        setHeight(80);
        setWidth(80);
        setX(500);
        setY(100-getHeight());
        addKeyListener(this);
        jumpTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canJump= true; // resetuje skok
                jumpTimer.stop(); // Zastaví timer po resetování

            }
        });
    }

    public void update(ArrayList<Island> islands){
        boolean onGround = false;
        for (Island island: islands){
            island.update(); // updatí každého islandu pozici
            if (getRect().intersects(island.getRect())) {
                Rectangle playerRect = getRect();
                Rectangle islandRect = island.getRect();

                if (velocity > 0 && playerRect.y + playerRect.height - velocity <= islandRect.y) {
                    y = islandRect.y - height; // místo playera nahoře islandu
                    velocity = 0; // přestane padat
                    onGround = true; // player je na ostrově
                }
            }

        }
        if (LEFT) {
            x-= 6;
            for (Island island: islands){
                if (island.getRect().intersects(getRect())){
                    x+= 6;
                }
            }
        }
        if (RIGHT) {
            x+= 6;
            for (Island island: islands){
                if (island.getRect().intersects(getRect())){
                    x-= 6;
                }
            }
        }
        if (LEFT) {
            setImage("King_JumpL.png");
        } else if (RIGHT) {
            setImage("King_JumpR.png");
        }
        if (JUMP && canJump) {
            velocity-= 20; // obnoví rychlost když skáče
            canJump= false;
        } else if (JUMP){
            y+= 2; // padá dolů
        }
        y+= velocity; // aktivuje rychlost
        velocity+= 1; // dělá to gravitaci


        // zajistí aby se hra obnovila
        if (y > frameHeight - height) {
            restartGame();
        }
        // vpravo neprojde
        if (x> frameWidth -width) {
            x= frameWidth -width;
        }
        // vlevo neprojde
        if (x< 0) {
           x= 0;
        }

    }
    private void restartGame() {
        setX(500);
        setY(100 - getHeight());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_A) {
            LEFT = true;

        }
        if (keys == KeyEvent.VK_D) {
            RIGHT = true;
        }
        if (keys == KeyEvent.VK_SPACE && canJump) {
            velocity = -16; // Počáteční rychlost skoku
            canJump = false; // dělá dokud cooldown není dokončen
            jumpTimer.start(); // Startne cooldown
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_A) {
            LEFT = false;
        }
        if (keys == KeyEvent.VK_D) {
            RIGHT = false;
        }
        if (keys == KeyEvent.VK_SPACE) {
            JUMP = false;

        }
    }


    protected void paintComponent(Graphics g) {
    }
}
