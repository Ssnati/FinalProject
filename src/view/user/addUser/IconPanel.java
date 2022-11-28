package view.user.addUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class IconPanel extends JPanel {
    private JLabel iconLabel;
    private List<JButton> maleIcons, femaleIcons;

    public IconPanel(ActionListener listener) {
        setBackground(new Color(191, 189, 189));
        setLayout(new GridBagLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        maleIcons = new ArrayList<>();
        femaleIcons = new ArrayList<>();
        addIconLabel();
        addMaleIcon(listener);
        addFemaleIcon(listener);
    }

    private void addIconLabel() {
        iconLabel = new JLabel("Icono:");
        iconLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        add(iconLabel, gbc);
    }

    private void addMaleIcon(ActionListener listener) {
        for (int i = 0; i < 6; i++) {
            JButton icon = new JButton();
            Image image = new ImageIcon("sources/userIcons/Male Icon " + (i+1) + ".png").getImage();
            icon.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            icon.addActionListener(listener);
            icon.setActionCommand("icon" + i + 1);
            icon.setBorderPainted(false);
            icon.setBackground(new Color(0, 0, 0, 0));
            icon.setFocusable(false);
            setCoordinate(icon, i, 1);
            maleIcons.add(icon);
        }
    }

    private void addFemaleIcon(ActionListener listener) {
        for (int i = 0; i < 6; i++) {
            JButton icon = new JButton();
            Image image = new ImageIcon("sources/userIcons/Female Icon " + (i+1) + ".png").getImage();
            icon.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            icon.addActionListener(listener);
            icon.setActionCommand("icon" + i + 1);
            icon.setBorderPainted(false);
            icon.setFocusable(false);
            setCoordinate(icon, i, 2);
            femaleIcons.add(icon);
        }
    }

    private void setCoordinate(JButton icon, int xCoordinate, int yCoordinate) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = xCoordinate;
        gbc.gridy = yCoordinate;
        gbc.insets = new Insets(0, -5, 0, -5);
        add(icon, gbc);
    }

}
