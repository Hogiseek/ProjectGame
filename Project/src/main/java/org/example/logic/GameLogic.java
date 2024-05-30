package org.example.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class GameLogic implements KeyListener {

    ArrayList<Island> islands;
    Island island, island1, island2, island3, island4, island5, island6, island7, island8, island9, island10, island11, island12, island13, island14, island15, island16, island17, island18, island19, island20, island21, island22, island23, island24, island25;
    Player player;
    BackGround backGround;
    ArrayList<Bird> birds;
    Bird bird, bird1, bird2, bird3;
    Timer birdTimer;
    ArrayList<Arrow> arrows;
    Arrow arrow, arrow1, arrow2, arrow3, arrow4, arrow5, arrow6, arrow7;
    Timer arrowTimer;
    int phase;
    boolean rules;
    long Time;
    int gameDurationInSeconds;
    boolean isVisible;

    public GameLogic() {
        Time = 0;
        this.isVisible= true;
        gameDurationInSeconds = 0;
        int screenHeight= 720;
        islands= new ArrayList<>();
        player= new Player(this);
        birds= new ArrayList<>();
        arrows= new ArrayList<>();
        backGround= new BackGround("BackgroundDone.png",0);
        birdTimer= new Timer();
        birdTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (phase== 1){
                    addBird();
                }

            }
        }, 0, 5000); // spuštění každých 5 sekund

        arrowTimer= new Timer();
        arrowTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                addArrow();
            }
        },0 , 5000); // spuštění každých 5 sekund


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
    public void update() {
        player.update(islands, birds, arrows);
        backGround.update();
        if (phase== 1 && gameDurationInSeconds<= 10){
            isVisible= true;
        }
        if (Time > 0) {
            gameDurationInSeconds = (int) ((System.currentTimeMillis() - Time) / 1000);
        }
    }
    //spustění časovače
    private void startTimer() {
        Time= System.currentTimeMillis();
    }
    //zastavení časovače, výpočet délky hraní
    public void stopTimer() {
        long endTime = System.currentTimeMillis();
        gameDurationInSeconds= (int) ((endTime- Time) / 1000); // Převod na sekundy
    }
    public String formatTime(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, secs);
    }
    private void addBird() {
        int screenWidth= 1080;
        bird= new Bird("Bird_UP.png", 0, 50, 50, 50, screenWidth);
        bird1= new Bird("Bird_DOWN.png", 0, 200, 50, 50, screenWidth);
        bird2= new Bird("Bird_UP.png", 0, 380, 50, 50, screenWidth);
        bird3= new Bird("Bird_DOWN.png", 0, 600, 50, 50, screenWidth);

        if (gameDurationInSeconds>= 25 && gameDurationInSeconds<= 27){
            birds.add(bird);
        }
        if (gameDurationInSeconds>= 28 && gameDurationInSeconds<= 33){
            birds.add(bird1);
        }
        if (gameDurationInSeconds>= 35 && gameDurationInSeconds<= 45){
            birds.add(bird2);
        }
        if (gameDurationInSeconds>= 55 && gameDurationInSeconds<= 60){
            birds.add(bird3);
        }
    }
    private void addArrow() {
        int screenHeight= 720;
        arrow= new Arrow("Arrow.png", 20, 0, 50, 50, screenHeight);
        arrow1= new Arrow("Arrow.png", 150, 0, 50, 50, screenHeight);
        arrow2= new Arrow("Arrow.png", 275, 0, 50, 50, screenHeight);
        arrow3= new Arrow("Arrow.png", 400, 0, 50, 50, screenHeight);
        arrow4= new Arrow("Arrow.png", 570, 0, 50, 50, screenHeight);
        arrow5= new Arrow("Arrow.png", 775, 0, 50, 50, screenHeight);
        arrow6= new Arrow("Arrow.png", 950, 0, 50, 50, screenHeight);
        arrow7= new Arrow("Arrow.png", 1100, 0, 50, 50, screenHeight);

        if (gameDurationInSeconds>= 70 && gameDurationInSeconds<= 72){
            arrows.add(arrow);
        }
        if (gameDurationInSeconds>= 80 && gameDurationInSeconds<= 82){
            arrows.add(arrow1);
        }
        if (gameDurationInSeconds>= 95 && gameDurationInSeconds<= 98){
            arrows.add(arrow2);
        }
        if (gameDurationInSeconds>= 107 && gameDurationInSeconds<= 110){
            arrows.add(arrow3);
        }
        if (gameDurationInSeconds>= 120 && gameDurationInSeconds<= 123){
            arrows.add(arrow4);
        }
        if (gameDurationInSeconds>= 132 && gameDurationInSeconds<= 135){
            arrows.add(arrow5);
        }
        if (gameDurationInSeconds>= 150 && gameDurationInSeconds<= 155){
            arrows.add(arrow6);
        }
        if (gameDurationInSeconds>= 168 && gameDurationInSeconds<= 172){
            arrows.add(arrow7);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys== KeyEvent.VK_ENTER && phase== 0){
            phase= 1;
            startTimer();
        }
        if (keys== KeyEvent.VK_H && phase== 0 && !rules){
            rules = true;
        } else if (keys == KeyEvent.VK_H && phase == 0) {
            rules = false;
        }
        if (keys== KeyEvent.VK_ESCAPE  && phase == 0){
            System.exit(0);
        }
        if (keys== KeyEvent.VK_ENTER && phase== 3){
            phase= 0;
        }
        if (keys== KeyEvent.VK_ESCAPE  && phase == 3){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public ArrayList<Bird> getBirds() {
        return birds;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
