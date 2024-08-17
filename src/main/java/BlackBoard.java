package main.java;

import javax.swing.*;
import java.awt.*;


public class BlackBoard extends JFrame {

    public BlackBoard() {
        setTitle("main.java.BlackBoard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel();

        add(drawingPanel, BorderLayout.CENTER);

        ControlPanel controlPanel = new ControlPanel(drawingPanel);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
