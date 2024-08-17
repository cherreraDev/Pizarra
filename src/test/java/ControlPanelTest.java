package test.java;

import main.java.ControlPanel;
import main.java.DrawingPanel;
import org.junit.Test;
import javax.swing.*;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class ControlPanelTest {

    @Test
    public void testControlPanelButtons() {
        DrawingPanel drawingPanel = new DrawingPanel();
        ControlPanel controlPanel = new ControlPanel(drawingPanel);

        JButton colorButton = (JButton) controlPanel.getComponent(0);
        JButton clearButton = (JButton) controlPanel.getComponent(1);

        assertEquals("Choose color", colorButton.getText());
        assertEquals("Clear", clearButton.getText());

        ActionListener[] colorListeners = colorButton.getActionListeners();
        ActionListener[] clearListeners = clearButton.getActionListeners();

        assertEquals(1, colorListeners.length);
        assertEquals(1, clearListeners.length);
    }
}
