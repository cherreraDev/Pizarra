import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public ControlPanel(DrawingPanel drawingPanel) {
        JButton colorButton = new JButton("Choose color");
        JButton clearButton = new JButton("Clear");

        colorButton.addActionListener(e -> {
            Color selectedColor = JColorChooser.showDialog(this, "Choose a color", drawingPanel.getForeground());
            if (selectedColor != null) {
                drawingPanel.setCurrentColor(selectedColor);
            }
        });

        clearButton.addActionListener(e -> drawingPanel.clear());

        add(colorButton);
        add(clearButton);
    }
}
