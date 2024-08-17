import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {
    private int lastX, lastY;
    private boolean isDrawing = false;
    private final ArrayList<Line> lines = new ArrayList<>();
    private Color currentColor = Color.WHITE;

    public DrawingPanel(){
        setBackground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isDrawing = true;
                lastX = e.getX();
                lastY = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isDrawing = false;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isDrawing) {
                    Line line = new Line(lastX, lastY, e.getX(), e.getY(), currentColor);
                    lines.add(line);
                    repaint();
                    lastX = e.getX();
                    lastY = e.getY();
                }
            }
        });
        requestFocusInWindow();

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), "undo");

        getActionMap().put("undo", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lines.isEmpty()) {
                    lines.remove(lines.size() - 1);
                    repaint();
                }
            }
        });

        setVisible(true);
        requestFocusInWindow();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        for (Line line : lines) {
            g.setColor(line.getColor());
            g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
        }
    }

    public void setCurrentColor(Color color) {
        currentColor = color;
    }

    public void clear() {
        lines.clear();
        repaint();
    }
}
