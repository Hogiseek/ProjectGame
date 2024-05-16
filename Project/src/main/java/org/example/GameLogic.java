package org.example;

import org.example.logic.BackGround;
import org.example.logic.Island;
import org.example.logic.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameLogic implements KeyListener {

    ArrayList<Island> islands; // vytvoření několika islandů
    Island island, island1, island2, island3, island4;
    Player player;
    BackGround backGround;
    ArrayList<BackGround> backGrounds;



    public GameLogic() {
        islands= new ArrayList<>();
        backGrounds = new ArrayList<>();
        player = new Player();
        backGround = new BackGround("BackGround2.png",0);
        backGrounds.add(backGround);
        island= new Island("Island.png", 500, 420);
        island1= new Island("Island.png", 400, 510);
        island2= new Island("Island.png", 720, 640);
        island3= new Island("Island.png", 500, 50);
        island4= new Island("Island.png", 600, 580);



        islands.add(island);
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);




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
