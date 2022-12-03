package view;

import view.books.BooksDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class View extends JFrame {
    private BooksDialog booksDialog;
    private UsersDialog usersDialog;

    public View(ActionListener actionListener, MouseListener mouseListener) {
        setTitle("Library");
        setSize(1220, 600);
//        usersDialog = new UsersDialog(this,true, actionListener);
//        usersDialog.setVisible(true);

        booksDialog = new BooksDialog(this, true,actionListener);
        booksDialog.setVisible(true);

        getContentPane().add(new MainPanel(actionListener, mouseListener));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String dialogSize() {
        return usersDialog.getDialogSize();
    }
}
