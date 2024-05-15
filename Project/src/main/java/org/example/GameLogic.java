package org.example;

import org.example.logic.BackGround;
import org.example.logic.Island;
import org.example.logic.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameLogic implements KeyListener {

    ArrayList<Island> islands;
    Island island, island1, island2, island3, island4;
    Player player;
    BackGround backGround;
    ArrayList<BackGround> backGrounds;



    public GameLogic() {
        islands= new ArrayList<>();
        backGrounds = new ArrayList<>();
        player = new Player();
        backGround = new BackGround("BackgroundGame.png",0);
        backGrounds.add(backGround);
        island= new Island("Island.png", 500, 420);
        island1= new Island("Island.png", 50, 100);



        islands.add(island);
        islands.add(island1);




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
