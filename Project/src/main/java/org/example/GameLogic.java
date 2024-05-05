package org.example;

import org.example.logic.BackGround;
import org.example.logic.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameLogic implements KeyListener {

    Player player;
    BackGround backGround, backGround1;
    double Gravity = 1;
    double GravitySpeed = 0.1;
    ArrayList<BackGround> backGrounds;
    boolean UP;



    public GameLogic() {
        backGrounds = new ArrayList<>();
        player = new Player();
        backGround = new BackGround("Bg1.png",0);
        backGround1 = new BackGround("Bg1.png",-720);
        backGrounds.add(backGround);
        backGrounds.add(backGround1);



    }

    public void update() {
        player.update();
        backGround.update();

    }
    //public void moveBackground(){
        //for (BackGround backGround: backGrounds){
            //backGround.y += (int) Gravity;
            //if (backGround.y >= backGround.getHeight()){
                //backGround.y =- backGround.getHeight();
            //}
            //if (backGround.getHeight() <= 0){
                //backGround.y = backGround.getHeight()*2;
            //}
            //Gravity -= 1;

        //}


    //}


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keys = e.getKeyCode();
        if (keys == KeyEvent.VK_SPACE){
            Gravity += 10;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
