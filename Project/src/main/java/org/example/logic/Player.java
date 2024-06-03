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
    GameLogic logic;


    public Player(GameLogic logic) {
        this.logic = logic;
        setImage("King_JumpR.png");
        setHeight(80);
        setWidth(80);
        setX(500);
        setY(100 - getHeight());
        addKeyListener(this);
        jumpTimer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canJump= true; // resetuje skok
                jumpTimer.stop(); // Zastaví timer po resetování

            }
        });
    }

    public void update(ArrayList<Island> islands, ArrayList<Bird> birds, ArrayList<Arrow> arrows){
        for (Island island : islands) {
            island.update(); // updatí každého islandu pozici
            if (getRect().intersects(island.getRect())) {
                Rectangle playerRect = getRect();
                Rectangle islandRect = island.getRect();

                // Kontrola kolize shora
                if (velocity > 0 && playerRect.y + playerRect.height - velocity <= islandRect.y) {
                    y = islandRect.y - height; // umístí playera nahoře islandu
                    velocity = 0; // přestane padat
                }
                // Kontrola kolize zespodu
                else if (velocity < 0 && playerRect.y - velocity >= islandRect.y + islandRect.height) {
                    y = islandRect.y + islandRect.height; // umístí playera zespodu islandu
                    velocity = 1; // přestane se pohybovat vzhůru
                }
            }
        }
        for (Bird bird: birds){
            bird.update(); // updatí každého ptáka pozici
            if (getRect().intersects(bird.getRect())) {
                Rectangle playerRect = getRect();
                Rectangle birdRect = bird.getRect();

                if (velocity > 0 && playerRect.y + playerRect.height - velocity <= birdRect.y) {
                    x= birdRect.x - width;
                }
            }
        }
        for (Arrow arrow: arrows){
            arrow.update(); // updatí každého šípu pozici
            if (getRect().intersects(arrow.getRect())) {
                Rectangle playerRect = getRect();
                Rectangle arrowRect = arrow.getRect();

                if (velocity > 0 && playerRect.y + playerRect.height - velocity <= arrowRect.y) {
                    x= arrowRect.x - width;
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
            for (Bird bird: birds){
                if (bird.getRect().intersects(getRect())){
                    logic.phase = 3;
                }
            }
            for (Arrow arrow: arrows){
                if (arrow.getRect().intersects(getRect())){
                    logic.phase = 3;
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
            for (Bird bird: birds){
                if (bird.getRect().intersects(getRect())){
                    logic.phase = 3;
                }
            }
            for (Arrow arrow: arrows){
                if (arrow.getRect().intersects(getRect())){
                    logic.phase = 3;
                }
            }
        }

        if (LEFT) {
            setImage("King_JumpL.png");// padá dolů
        } else if (RIGHT) {
            setImage("King_JumpR.png");// obnoví rychlost když skáče
        }
        if (JUMP && canJump) {
            velocity-= 20;
            canJump= false;
        } else if (JUMP){
        y+= 2;
        }
        y+= velocity; // aktivuje rychlost
        velocity+= 1; // dělá to gravitaci
        // zajistí aby se hra obnovila
        if (y > frameHeight - height) {
            setX(500);
            setY(100 - getHeight());
            logic.phase = 3;
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
}
