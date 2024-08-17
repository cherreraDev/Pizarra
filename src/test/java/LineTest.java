package test.java;
import main.java.Line;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class LineTest {

    @Test
    public void testLineCreation() {
        Line line = new Line(10, 20, 30, 40, Color.RED);

        assertEquals(10, line.x1());
        assertEquals(20, line.y1());
        assertEquals(30, line.x2());
        assertEquals(40, line.y2());
        assertEquals(Color.RED, line.color());
    }
}
