package view.rent;

import view.OakButton;
import view.OvalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OperationPanel extends JPanel {
    private JButton selectUserButton, selectBookButton, rentButton, returnButton, backButton;

    public OperationPanel(ActionListener actionListener) {
        setLayout(new GridBagLayout());
        initComponent(actionListener);
        setBackground(new Color(158, 107, 189));
    }

    private void initComponent(ActionListener actionListener) {
        selectUserButton = new JButton("Select User");
        selectBookButton = new JButton("Select Book");

        rentButton = new JButton("  Rent   ");
        returnButton = new JButton(" Return ");

        backButton = new JButton(new ImageIcon("sources/Back.png"));
        addComponents();

        selectButtonFeatures(selectUserButton, new Color(136, 164, 187), "sources/Add User.png");
        selectButtonFeatures(selectBookButton, new Color(108, 135, 126), "sources/Add Book.png");

        actionButtonFeatures(rentButton, true, false, true, false);
        actionButtonFeatures(returnButton, false, true, false, true);

        backButtonFeatures();

    }

    private void actionButtonFeatures(JButton button, boolean northEast, boolean southWest, boolean southEast, boolean northWest) {
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Sans Serif", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setUI(new OakButton(button.getPreferredSize().width + 1, button.getPreferredSize().height + 1, 75, 75,
                new Color(20, 0, 255), northEast, southWest, southEast, northWest));
    }

    private void selectButtonFeatures(JButton button, Color color, String source) {
        Dimension dimension = new Dimension(230, 230);
//        button.setPreferredSize(dimension);
//        button.setMaximumSize(dimension);
//        button.setMinimumSize(dimension);
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setIconTextGap(0);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.NORTH);
        button.setFont(new Font("Sans Serif", Font.BOLD, 30));
        button.setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(110,165, Image.SCALE_DEFAULT)));
        button.setUI(new OvalButton(button.getPreferredSize().width, button.getPreferredSize().height,
                25, 25, color));
        button.setContentAreaFilled(false);
    }

    private void backButtonFeatures() {
        backButton.setBorderPainted(false);
        backButton.setBackground(new Color(0, 0, 0, 0));
        backButton.setFocusable(false);
        backButton.setContentAreaFilled(false);
    }

    private void addComponents() {
        addSelectUsersButton();
        addSelectBooksButton();
        addRentButton();
        addReturnButton();
        addBackButton();
    }

    private void addBackButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        add(backButton, gbc);
    }

    private void addReturnButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.NORTH;
        add(returnButton, gbc);
    }

    private void addRentButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(50, 0, 0, 0);
        add(rentButton, gbc);
    }

    private void addSelectBooksButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 50, 0, 25);
        add(selectBookButton, gbc);
    }

    private void addSelectUsersButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.insets = new Insets(0, 50, 0, 0);
        add(selectUserButton, gbc);
    }
}
