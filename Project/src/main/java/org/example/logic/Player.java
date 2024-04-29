package org.example.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Entity implements KeyListener {
    boolean LEFT, RIGHT;

    public Player() {
        setImage("King_JumpR.png");
        setHeight(100);
        setWidth(100);
        setX(1000/2);
        setY(600-getHeight());

    }
    public void update(){
        if (LEFT) {
            x-= 1;
        }
        if (RIGHT) {
            x+= 1;
        }
        if (LEFT) {
            setImage("King_JumpL.png");
        } else if (RIGHT) {
            setImage("King_JumpR.png");

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

    }
}
