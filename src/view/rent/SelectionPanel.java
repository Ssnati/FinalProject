package view.rent;

import persistence.PrivateProperties;
import view.OvalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class SelectionPanel extends JPanel {
    private final PrivateProperties properties;
    private JButton rentButton, returnButton;
    private Image image;

    public SelectionPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        initComponent(actionListener, mouseListener);
        setLayout(null);
        add(rentButton);
        add(returnButton);
    }

    private void initComponent(ActionListener actionListener, MouseListener mouseListener) {
        image = new ImageIcon(properties.src_BackgroundImage2()).getImage();
        rentButton = new JButton(properties.btn_txt_rentButton());
        returnButton = new JButton(properties.btn_txt_returnButton());

        rentButton.setBounds(34, 22, 290, 134);
        returnButton.setBounds(400, 141, 290, 134);

        buttonFeatures(returnButton, actionListener, mouseListener, properties.ac_rentButtonSelectionPanel());

        buttonFeatures(rentButton, actionListener, mouseListener, properties.ac_returnButtonSelectionPanel());

    }

    private void buttonFeatures(JButton button, ActionListener actionListener, MouseListener mouseListener, String actionCommand) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 50, 50, new Color(0, 0, 0, 128)));
        button.addMouseListener(mouseListener);
        button.addActionListener(actionListener);
        button.setActionCommand(actionCommand);
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Sans Serif", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

}
