package org.example;

import java.awt.event.KeyListener;

public class Game {

    private GameGraphics graphics;
    private GameLogic logic;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }

    public Game() {
        logic= new GameLogic();
        GameGraphics graphics= new GameGraphics(logic);
    }
    private void update() {
        graphics.update(logic);
        logic.update();
    }



    public GameGraphics getGraphics() {
        return graphics;
    }

    public GameLogic getLogic() {
        return logic;
    }
}
