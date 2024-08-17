import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BlackBoard extends JFrame {

    private final DrawingPanel drawingPanel;
    public BlackBoard() {
        setTitle("BlackBoard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        drawingPanel = new DrawingPanel();

        add(drawingPanel, BorderLayout.CENTER);

        ControlPanel controlPanel = new ControlPanel(drawingPanel);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
