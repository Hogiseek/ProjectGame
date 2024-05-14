package org.example.logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class Player extends Entity implements KeyListener, ActionListener {
    boolean LEFT, RIGHT, JUMP;
    private int velocity = 0;
    private Timer timer;
    private Timer jumpTimer;
    private boolean canJump = true;


    public Player() {
        setImage("King_JumpR.png");
        setHeight(80);
        setWidth(80);
        setX(1000/2);
        setY(100-getHeight());
        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        jumpTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                canJump = true; // resetuje skok
                jumpTimer.stop(); // zastaví timer po resetu

            }
        });
    }

    public void update(){
        if (LEFT) {
            x-= 3;
        }
        if (RIGHT) {
            x+= 3;
        }
        if (LEFT) {
            setImage("King_JumpL.png");
        } else if (RIGHT) {
            setImage("King_JumpR.png");
        }
        if (JUMP && canJump) {
            y-= 20;
            velocity = 0; // obnoví rychlost když skáče
            canJump = false;
        } else if (JUMP){
            y+= 2; // padá dolů
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        y += velocity; // aktivuje rychlost
        velocity += 1; // dělá to gravitaci
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
            velocity = -10; // Počáteční rychlost skoku
            canJump = false; // dělá dokud cooldown není dokončen
            jumpTimer.start(); // znovu začne cooldown
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
