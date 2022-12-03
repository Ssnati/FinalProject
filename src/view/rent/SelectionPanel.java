package view.rent;

import view.OvalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SelectionPanel extends JPanel {
    private JButton rentButton, returnButton;
    private Image image;

    public SelectionPanel(ActionListener actionListener) {
        initComponent();
        setLayout(null);
        add(rentButton);
        add(returnButton);
    }

    private void initComponent() {
        image = new ImageIcon("sources/Background 2.png").getImage();
        rentButton = new JButton("Rent");
        returnButton = new JButton("Return");

        rentButton.setBounds(34,22,290,134);
        returnButton.setBounds(400,141,290,134);

        buttonFeatures(returnButton);

        buttonFeatures(rentButton);

    }

    private void buttonFeatures(JButton button) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 50,50, new Color(0, 0, 0, 128)));
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
