package view;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

public class OakButton extends BasicButtonUI {
    private final int width, height, arcWidth, arcHeight;
    private final Color backgroundColor;
    private final boolean northEast, southEast, southWest, northWest;

    public OakButton(int width, int height, int arcWidth, int arcHeight, Color backgroundColor, boolean northEast, boolean southEast, boolean southWest, boolean northWest) {
        this.width = width;
        this.height = height;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.backgroundColor = backgroundColor;
        this.northEast = northEast;
        this.southEast = southEast;
        this.southWest = southWest;
        this.northWest = northWest;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(backgroundColor);
        g2d.fillRoundRect(0, 0, width, height, arcWidth, arcHeight);
        if (northEast) g2d.fillRect((width / 2), 0, width / 2, height / 2);
        if (southEast) g2d.fillRect((width / 2)+1, height / 2, width / 2, height / 2);
        if (southWest) g2d.fillRect(0, height / 2, width / 2, height / 2);
        if (northWest) g2d.fillRect(0, 0, width / 2, height / 2);
        super.paint(g2d, c);
    }

}
