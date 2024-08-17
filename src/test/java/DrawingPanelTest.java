package test.java;

import main.java.DrawingPanel;
import org.junit.Test;

import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.Assert.*;


public class DrawingPanelTest {

    @Test
    public void testSetCurrentColor() {
        DrawingPanel panel = new DrawingPanel();
        panel.setCurrentColor(Color.BLUE);

        panel.dispatchEvent(new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 10, 10, 1, false));
        panel.dispatchEvent(new MouseEvent(panel, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, 20, 20, 1, false));

        assertEquals(Color.BLUE, panel.getLines().get(0).color());

    }
    @Test
    public void testClear() {
        DrawingPanel panel = new DrawingPanel();
        panel.setCurrentColor(Color.GREEN);

        panel.dispatchEvent(new MouseEvent(panel, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 0, 10, 10, 1, false));
        panel.dispatchEvent(new MouseEvent(panel, MouseEvent.MOUSE_DRAGGED, System.currentTimeMillis(), 0, 20, 20, 1, false));

        assertFalse(panel.getLines().isEmpty());
        panel.clear();
        assertTrue(panel.getLines().isEmpty());
    }
}
