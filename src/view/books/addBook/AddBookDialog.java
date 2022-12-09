package view.books.addBook;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class AddBookDialog extends JDialog {

    private final PrivateProperties properties;
    private AddBookPanel addBookPanel;

    public AddBookDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) throws IOException {
        super(dialog, modal);
        this.properties = properties;
        setTitle(properties.getAddBookDialogTitle());
        this.setSize(431,749);
        addBookPanel=new AddBookPanel(actionListener, mouseListener, properties);
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
