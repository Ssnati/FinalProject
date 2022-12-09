package view.books;

import persistence.PrivateProperties;
import view.books.BookInfo.BookInfoDialog;
import view.books.addBook.AddBookDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class BooksDialog extends JDialog {
    private final PrivateProperties properties;
    private BooksPanel booksPanel;
    private AddBookDialog addBookDialog;

    private BookInfoDialog bookInfoDialog;

    public BooksPanel getBooksPanel() {
        return booksPanel;
    }

    public void setBooksPanel(BooksPanel booksPanel) {
        this.booksPanel = booksPanel;
    }

    public AddBookDialog getAddBookDialog() {
        return addBookDialog;
    }

    public void setAddBookDialog(AddBookDialog addBookDialog) {
        this.addBookDialog = addBookDialog;
    }

    public BookInfoDialog getBookInfoDialog() {
        return bookInfoDialog;
    }

    public void setBookInfoDialog(BookInfoDialog bookInfoDialog) {
        this.bookInfoDialog = bookInfoDialog;
    }

    public BooksDialog(JFrame frame, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener, PrivateProperties properties) throws IOException {
        super(frame, modal);
        this.properties = properties;
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle(properties.getBooksDialogTitle());
        initComponent(listener, mouseListener, keyListener);
    }
    private void initComponent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        addBooksPanel(actionListener, mouseListener, keyListener);
        addAddBookDialog(actionListener, mouseListener);
        addBookInfoDialog(actionListener, mouseListener);
    }

    private void addBookInfoDialog(ActionListener actionListener, MouseListener mouseListener) {
        bookInfoDialog = new BookInfoDialog(this, true, actionListener, mouseListener, properties);
        bookInfoDialog.setVisible(false);
    }

    private void addAddBookDialog(ActionListener actionListener, MouseListener mouseListener) throws IOException {
        addBookDialog = new AddBookDialog(this, true, actionListener, mouseListener, properties);
        addBookDialog.setVisible(false);
    }

    private void addBooksPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        booksPanel = new BooksPanel(actionListener, mouseListener, keyListener, properties);
        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        getContentPane().add(scrollPane);
    }
}
