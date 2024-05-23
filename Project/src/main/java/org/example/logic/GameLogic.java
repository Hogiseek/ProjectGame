package org.example.logic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;


public class GameLogic extends Player implements KeyListener {

    ArrayList<Island> islands;
    Island island, island1, island2, island3, island4, island5, island6, island7, island8, island9, island10, island11, island12, island13, island14, island15, island16, island17, island18, island19, island20, island21, island22, island23, island24, island25;
    Player player;
    BackGround backGround;
    ArrayList<BackGround> backGrounds;
    ArrayList<Bird> birds;
    Bird bird;
    boolean GameActive;




    public GameLogic() {
        int screenHeight= 720;
        int screenWidth= 1080;
        islands= new ArrayList<>();
        backGrounds= new ArrayList<>();
        player= new Player();
        birds= new ArrayList<>();
        backGround= new BackGround("BackgroundDone.png",0);
        backGrounds.add(backGround);

        bird= new Bird("Bird_UP.png", 1, 50, 50, 50, screenWidth);

        birds.add(bird);



        island= new Island("Island.png", 40, 150, 50, 50, screenHeight);
        island1= new Island("Island.png", 180, 250, 50, 50, screenHeight);
        island2= new Island("Island.png", 25, 600, 50, 50, screenHeight);
        island3= new Island("Island.png", 300, 480, 50, 50, screenHeight);
        island4= new Island("Island.png", 490, 420, 50, 50, screenHeight); // pod Playerem
        island5= new Island("Island.png", 380, 200, 50, 50, screenHeight);
        island6= new Island("Island.png", 400, 600, 50, 50, screenHeight);
        island7= new Island("Island.png", 630, 300, 50, 50, screenHeight);
        island8= new Island("Island.png", 570, 90, 50, 50, screenHeight);
        island9= new Island("Island.png", 200, 50, 50, 50, screenHeight);
        //island10= new Island("Island.png", 130, 480, 50, 50, screenHeight);
        island11= new Island("Island.png", 140, 700, 50, 50, screenHeight);
        island12= new Island("Island.png", 770, 200, 50, 50, screenHeight);
        island13= new Island("Island.png", 950, 320, 50, 50, screenHeight);
        island14= new Island("Island.png", 910, 90, 50, 50, screenHeight);
        island15= new Island("Island.png", 780, 410, 50, 50, screenHeight);
        island16= new Island("Island.png", 640, 530, 50, 50, screenHeight);
        island17= new Island("Island.png", 760, 650, 50, 50, screenHeight);
        island18= new Island("Island.png", 910, 520, 50, 50, screenHeight);
        island19= new Island("Island.png", 10, 370, 50, 50, screenHeight);
        island20= new Island("Island.png", 500, 700, 50, 50, screenHeight);
        //island21= new Island("Island.png", 5, 5, 50, 50, screenHeight);
        island22= new Island("Island.png", 400, 10, 50, 50, screenHeight);
        island23= new Island("Island.png", 700, 10, 50, 50, screenHeight);
        //island24= new Island("Island.png", 860, 710, 50, 50, screenHeight);
        island25= new Island("Island.png", 1040, 730, 50, 50, screenHeight);


        islands.add(island);
        islands.add(island1);
        islands.add(island2);
        islands.add(island3);
        islands.add(island4);
        islands.add(island5);
        islands.add(island6);
        islands.add(island7);
        islands.add(island8);
        islands.add(island9);
        //islands.add(island10);
        islands.add(island11);
        islands.add(island12);
        islands.add(island13);
        islands.add(island14);
        islands.add(island15);
        islands.add(island16);
        islands.add(island17);
        islands.add(island18);
        islands.add(island19);
        islands.add(island20);
        //islands.add(island21);
        islands.add(island22);
        islands.add(island23);
        //islands.add(island24);
        islands.add(island25);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Island island: islands) {
            g.fillRect(island.getX(), island.getY(), island.getWidth(), island.getHeight());
        }
    }


    public void update() {
        player.update(islands);
        backGround.update();
        bird.update();

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
