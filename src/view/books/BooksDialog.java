package view.books;

import persistence.PrivateProperties;
import view.books.BookInfo.BookInfoDialog;
import view.books.addBook.AddBookDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.IOException;

public class BooksDialog extends JDialog {
    private final PrivateProperties properties;
    private BooksPanel booksPanel;
    private AddBookDialog addBookDialog;

    private BookInfoDialog bookInfoDialog;
    private JScrollPane scrollPane;

    public BooksPanel getBooksPanel() {
        return booksPanel;
    }

    public AddBookDialog getAddBookDialog() {
        return addBookDialog;
    }

    public BookInfoDialog getBookInfoDialog() {
        return bookInfoDialog;
    }

    public BooksDialog(JFrame frame, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener, WindowListener windowListener, PrivateProperties properties) throws IOException {
        super(frame, modal);
        this.properties = properties;
        addWindowListener(windowListener);
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
        scrollPane = new JScrollPane(booksPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        getContentPane().add(scrollPane);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}
