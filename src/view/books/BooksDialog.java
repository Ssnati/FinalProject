package view.books;

import view.books.BookInfo.BookInfoDialog;
import view.books.addBook.AddBookDialog;
import view.rent.SelectionDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

public class BooksDialog extends JDialog {
    private BooksPanel booksPanel;
    private AddBookDialog addBookDialog;

    private BookInfoDialog bookInfoDialog;

    public BooksDialog(JFrame frame, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener) {
        super(frame, modal);
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle("Books");
        initComponent(listener, mouseListener, keyListener);
    }

    public BooksDialog(SelectionDialog dialog, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener) {
        super(dialog, modal);
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle("Books");
        initComponent(listener, mouseListener, keyListener);
    }

    private void initComponent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        addBooksPanel(actionListener, mouseListener, keyListener);
        addAddBookDialog(actionListener);
        addBookInfoDialog(actionListener);
    }

    private void addBookInfoDialog(ActionListener listener) {
        bookInfoDialog = new BookInfoDialog(this, true, listener);
        bookInfoDialog.setVisible(false);
    }

    private void addAddBookDialog(ActionListener listener) {
        addBookDialog = new AddBookDialog(this, true, listener);
        addBookDialog.setVisible(false);
    }

    private void addBooksPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        booksPanel = new BooksPanel(actionListener, mouseListener, keyListener);
        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        getContentPane().add(scrollPane);
    }

    public void loadBooks(List<String> books) {
        booksPanel.loadBooks(books);
    }

    public void setTextInSearchFieldBooks() {
        booksPanel.setTextInSearchFieldBooks();
    }

    public String getSearchFieldTextBooks() {
        return booksPanel.getSearchFieldTextBooks();
    }
}
