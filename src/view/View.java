package view;

import view.books.BooksDialog;
import view.rent.SelectionDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class View extends JFrame {
    private MainPanel mainPanel;
    private BooksDialog booksDialog;
    private UsersDialog usersDialog;
    private SelectionDialog selectionDialog;

    public View(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        setTitle("Library");
        setSize(1220, 600);
        initContent(actionListener, mouseListener, keyListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        mainPanel = new MainPanel(actionListener, mouseListener);
        getContentPane().add(mainPanel);

        usersDialog = new UsersDialog(this, true, actionListener);
        usersDialog.setVisible(false);

        booksDialog = new BooksDialog(this, true, actionListener);
        booksDialog.setVisible(false);

        selectionDialog = new SelectionDialog(this, true, actionListener);
        selectionDialog.setVisible(false);
    }

    public void mainPanelMouseOverButton(JButton button) {
        mainPanel.mouseOverButton(button);
    }

    public void mainPanelMouseExitedButton(JButton button) {
        mainPanel.mouseExitButton(button);
    }

    public void showRentDialog() {
        selectionDialog.setVisible(true);
    }

    public void showBooksDialog() {
        booksDialog.setVisible(true);
    }

    public void showUsersDialog() {
        usersDialog.setVisible(true);
    }
}
