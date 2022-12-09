package view.books.addBook;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class AddBookDialog extends JDialog {

    private AddBookPanel addBookPanel;

    public AddBookDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) throws IOException {
        super(dialog, modal);
        setTitle("Add Book");
        this.setSize(431,749);
        addBookPanel=new AddBookPanel(actionListener, mouseListener);
        getContentPane().add(addBookPanel);
        setLocationRelativeTo(null);
    }

    public void setPahCoverToNewBook(String bookName) {
        addBookPanel.setPahCoverToNewBook(bookName);
        addBookPanel.updateUI();
    }

    public String getNewBookInfo() {
        return addBookPanel.getNewBookInfo();
    }

    public AddBookPanel getAddBookPanel() {
        return addBookPanel;
    }
}
