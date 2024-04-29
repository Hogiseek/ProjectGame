package org.example;

import org.example.logic.BackGround;
import org.example.logic.Player;

public class GameLogic {
    Player player;
    BackGround backGround;
    double Gravity = 0;
    double GravitySpeed = 0.1;

    public GameLogic() {
        player = new Player();
        backGround = new BackGround();

    }

    public void update() {
        player.update();
        backGround.update();
        moveBackground();
    }
    public void moveBackground(){
        Gravity += GravitySpeed;
        backGround.y += (int) Gravity;


    }


}
