package org.example;

import org.example.logic.BackGround;
import org.example.logic.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameLogic implements KeyListener {

    Player player;
    BackGround backGround;
    ArrayList<BackGround> backGrounds;



    public GameLogic() {
        backGrounds = new ArrayList<>();
        player = new Player();
        backGround = new BackGround("BackgroundGame.png",0);
        backGrounds.add(backGround);



    }

    public void update() {
        player.update();
        backGround.update();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
