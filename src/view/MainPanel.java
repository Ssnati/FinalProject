package view;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {
    private final PrivateProperties properties;
    private Image image;
    private JButton users, books, rent;
    private final Color baseColor = new Color(0, 0, 0, 128), changeColor = new Color(0, 0, 0, 153);

    public MainPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        setLayout(null);
        initComponent(actionListener, mouseListener);
    }

    private void initComponent(ActionListener actionListener, MouseListener mouseListener) {
        image = new ImageIcon(properties.src_BackgroundImage()).getImage();

        addUsersButton(actionListener, mouseListener);
        addBooksButton(actionListener, mouseListener);
        addRentButton(actionListener, mouseListener);
    }

    private void addUsersButton(ActionListener actionListener, MouseListener mouseListener) {
        users = new JButton(new ImageIcon(properties.src_UsersButtonImage()));
        users.setBounds(93, 163, 290, 290);
        setButtonFeatures(users);
        users.setActionCommand(properties.ac_UsersButton());
        users.addMouseListener(mouseListener);
        users.addActionListener(actionListener);
    }

    private void addBooksButton(ActionListener actionListener, MouseListener mouseListener) {
        books = new JButton(new ImageIcon(properties.src_BooksButtonImage()));
        books.setBounds(480,234,290,290);
        setButtonFeatures(books);
        books.setActionCommand(properties.ac_BooksButton());
        books.addActionListener(actionListener);
        books.addMouseListener(mouseListener);
    }

    private void addRentButton(ActionListener actionListener, MouseListener mouseListener) {
        rent = new JButton(new ImageIcon(properties.src_RentButtonImage()));
        rent.setBounds(867, 72, 290, 290);
        setButtonFeatures(rent);
        rent.setActionCommand(properties.ac_RentButton());
        rent.addActionListener(actionListener);
        rent.addMouseListener(mouseListener);
    }

    private void setButtonFeatures(JButton button) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 25, 25, baseColor));
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        add(button);
    }

    public void mouseOverButton(JButton button) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 25, 25, changeColor));
    }

    public void mouseExitButton(JButton button) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 25, 25, baseColor));
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }

    public boolean isOneOfButtons(JButton button) {
        return button == users || button == books || button == rent;
    }
}
