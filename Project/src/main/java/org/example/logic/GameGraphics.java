package org.example.logic;

import javax.swing.*;
import java.awt.*;

public class GameGraphics extends JFrame{
    GamePanel panel;

    public GameGraphics() throws HeadlessException {
        panel = new GamePanel();
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Jumping Crown");
    }
}
