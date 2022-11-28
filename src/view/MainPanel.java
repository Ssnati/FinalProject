package view;

import view.user.UsersDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {
    private Image image;
    private JButton users, books, rent;

    public MainPanel(ActionListener actionListener, MouseListener mouseListener) {
        setLayout(null);
        initComponent(actionListener, mouseListener);
    }

    private void initComponent(ActionListener actionListener, MouseListener mouseListener) {
        image = new ImageIcon("sources/Background.png").getImage();

        addUsersButton(actionListener, mouseListener);
        addBooksButton(actionListener, mouseListener);
        addRentButton(actionListener, mouseListener);
    }

    private void addUsersButton(ActionListener actionListener, MouseListener mouseListener) {
        users = new JButton(new ImageIcon("sources/Users.png"));
        users.setBounds(93, 163, 290, 290);
        setButtonFeatures(users);
        users.setActionCommand("Users");
        users.addMouseListener(mouseListener);
        users.addActionListener(actionListener);
    }

    private void addBooksButton(ActionListener actionListener, MouseListener mouseListener) {
        books = new JButton(new ImageIcon("sources/Books.png"));
        books.setBounds(480,234,290,290);
        setButtonFeatures(books);
        books.setActionCommand("Books");
        books.addActionListener(actionListener);
        books.addMouseListener(mouseListener);
    }

    private void addRentButton(ActionListener actionListener, MouseListener mouseListener) {
        rent = new JButton(new ImageIcon("sources/Rent Book.png"));
        rent.setBounds(867, 72, 290, 290);
        setButtonFeatures(rent);
        rent.setActionCommand("Rent");
        rent.addActionListener(actionListener);
        rent.addMouseListener(mouseListener);
    }

    private void setButtonFeatures(JButton button) {
        button.setUI(new OvalButton(button.getWidth(), button.getHeight(), 25, 25, new Color(0, 0, 0, 128)));
        button.setBorderPainted(false);
        button.setBackground(new Color(0, 0, 0, 0));
        button.setFocusable(false);
        button.setContentAreaFilled(false);
        add(button);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
