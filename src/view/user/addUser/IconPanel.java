package view.user.addUser;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class IconPanel extends JPanel {
    private final PrivateProperties properties;
    private JLabel iconLabel;
    private List<JButton> maleIcons, femaleIcons;
    private String selectedIconPath;

    public IconPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        setBackground(new Color(191, 189, 189));
        setLayout(new GridBagLayout());
        initComponents(actionListener, mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        maleIcons = new ArrayList<>();
        femaleIcons = new ArrayList<>();
        iconLabel = new JLabel(properties.lbl_txt_icon());
        addIconLabel();
        addMaleIcon(actionListener, mouseListener);
        addFemaleIcon(actionListener, mouseListener);
    }

    private void addIconLabel() {
        iconLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 6;
        add(iconLabel, gbc);
    }

    private void addMaleIcon(ActionListener actionListener, MouseListener mouseListener) {
        for (int i = 0; i < 6; i++) {
            JButton icon = new JButton();
            Image image = new ImageIcon(properties.src_IconMaleBase() + (i + 1) + "."+properties.fc_extension_2()).getImage();
            icon.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            icon.addActionListener(actionListener);
            icon.addMouseListener(mouseListener);
            icon.setActionCommand(properties.ac_maleIcon_() + (i + 1));
            icon.setBorderPainted(false);
            icon.setBackground(new Color(0, 0, 0, 0));
            icon.setFocusable(false);
            icon.setContentAreaFilled(false);
            setCoordinate(icon, i, 1);
            maleIcons.add(icon);
        }
    }

    private void addFemaleIcon(ActionListener actionListener, MouseListener mouseListener) {
        for (int i = 0; i < 6; i++) {
            JButton icon = new JButton();
            Image image = new ImageIcon(properties.src_IconFemaleBase() + (i + 1) + "."+properties.fc_extension_2()).getImage();
            icon.setIcon(new ImageIcon(image.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            icon.addActionListener(actionListener);
            icon.addMouseListener(mouseListener);
            icon.setActionCommand(properties.ac_femaleIcon_() + (i + 1));
            icon.setBorderPainted(false);
            icon.setFocusable(false);
            icon.setContentAreaFilled(false);
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

    private String getIconPath(String actionCommand) {
        buttonBorderUnpainted();
        String path ="";
        for (JButton icon : maleIcons) {
            if (icon.getActionCommand().equals(actionCommand)){
                int pathNumber =  maleIcons.indexOf(icon) + 1;
                icon.setBorderPainted(true);
                path = properties.src_IconMaleBase() + pathNumber + "."+properties.fc_extension_2();
            }
        }
        for (JButton icon : femaleIcons) {
            if (icon.getActionCommand().equals(actionCommand)){
                int pathNumber =  femaleIcons.indexOf(icon) + 1;
                icon.setBorderPainted(true);
                path = properties.src_IconFemaleBase() + pathNumber + "."+properties.fc_extension_2();
            }
        }
        System.out.println(path);
        return path;
    }

    private void buttonBorderUnpainted() {
        for (JButton icon : maleIcons) {
            icon.setBorderPainted(false);
        }
        for (JButton icon : femaleIcons) {
            icon.setBorderPainted(false);
        }
    }

    public void setPathToUserIcon(String actionCommand) {
        selectedIconPath = getIconPath(actionCommand);
    }

    public String getSelectedIconPath() {
        return selectedIconPath;
    }

    public void clearIcon() {
        buttonBorderUnpainted();
    }
}
