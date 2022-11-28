package view.user.userInfo;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class SpecialButton extends BasicButtonUI {
    private int width, height, arcWidth, arcHeight;
    private Color backgroundColor;

    public SpecialButton(int width, int height, int arcWidth, int arcHeight, Color backgroundColor) {
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
        g2d.fillRect(0, (height/2), width, height/2);
        super.paint(g2d, c);
    }
}
