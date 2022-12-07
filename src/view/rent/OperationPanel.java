package view.rent;

import view.OakButton;
import view.OvalButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class OperationPanel extends JPanel {
    private ActionListener actionListener;
    private MouseListener mouseListener;
    private JButton selectUserButton, selectBookButton, rentButton, returnButton;

    public OperationPanel(ActionListener actionListener, MouseListener mouseListener) {
        setLayout(new GridBagLayout());
        this.actionListener = actionListener;
        this.mouseListener = mouseListener;
        initComponent();
        setBackground(new Color(158, 107, 189));
    }

    private void initComponent() {
        selectUserButton = new JButton("Select User");
        selectBookButton = new JButton("Select Book");

        rentButton = new JButton("  Rent   ");
        returnButton = new JButton(" Return ");

        selectButtonFeatures(selectUserButton, new Color(136, 164, 187), "sources/Add User.png","SELECT_USER_TO_OPERATION");
        selectButtonFeatures(selectBookButton, new Color(108, 135, 126), "sources/Add Book.png","SELECT_BOOK_TO_RENT");

        actionButtonFeatures(rentButton, true, false, true, false, "RENT_BOOK");
        actionButtonFeatures(returnButton, false, true, false, true, "RETURN_BOOK");

        addComponents();
    }

    private void actionButtonFeatures(JButton button, boolean northEast, boolean southWest, boolean southEast, boolean northWest, String actionCommand) {
        button.addActionListener(actionListener);
        button.addMouseListener(mouseListener);
        button.setActionCommand(actionCommand);
        button.setFocusable(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFont(new Font("Sans Serif", Font.BOLD, 30));
        button.setForeground(Color.WHITE);
        button.setUI(new OakButton(button.getPreferredSize().width + 1, button.getPreferredSize().height + 1, 75, 75,
                new Color(20, 0, 255), northEast, southWest, southEast, northWest));
    }

    private void selectButtonFeatures(JButton button, Color color, String source, String actionCommand) {
        button.addActionListener(actionListener);
        button.addMouseListener(mouseListener);
        button.setActionCommand(actionCommand);
        button.setPreferredSize(new Dimension(214,200));
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setIconTextGap(0);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.NORTH);
        button.setFont(new Font("Sans Serif", Font.BOLD, 30));
        button.setIcon(new ImageIcon(new ImageIcon(source).getImage().getScaledInstance(110, 165, Image.SCALE_DEFAULT)));
        button.setUI(new OvalButton(button.getPreferredSize().width, button.getPreferredSize().height,
                25, 25, color));
        button.setContentAreaFilled(false);
    }


    private void addComponents() {
        addSelectUsersButton();
        addSelectBooksButton();
    }

    public void addRentButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(90, 0, 0, 0);
        add(rentButton, gbc);
    }

    public void addReturnButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(100, 0, 0, 0);
        add(returnButton, gbc);
    }

    private void addSelectBooksButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 25, 0, 25);
        gbc.anchor = GridBagConstraints.CENTER;
        add(selectBookButton, gbc);
    }

    private void addSelectUsersButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(40, 0, 0, 25);
        gbc.anchor = GridBagConstraints.CENTER;
        add(selectUserButton, gbc);
    }

    public void setUserInfo(String userImageSource){
        selectUserButton.setIcon(new ImageIcon(new ImageIcon(userImageSource).getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT)));
    }

    public void setBookInfo(String bookImageSource){
        selectBookButton.setIcon(new ImageIcon(new ImageIcon(bookImageSource).getImage().getScaledInstance(110, 165, Image.SCALE_DEFAULT)));
    }
}
