package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class OvalButton extends BasicButtonUI {
    private int width, height, arcWidth, arcHeight;
    private Color backgroundColor;

    public OvalButton(int width, int height, int arcWidth, int arcHeight, Color backgroundColor) {
        this.width = width;
        this.height = height;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(backgroundColor);
        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
        super.paint(g2d, c);
    }
}
