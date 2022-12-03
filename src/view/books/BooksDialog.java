package view.books;

import view.books.BookInfo.BookInfoDialog;
import view.books.addBook.AddBookDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BooksDialog extends JDialog {
    private BooksPanel booksPanel;
    private AddBookDialog addBookDialog;

    private BookInfoDialog bookInfoDialog;

    public BooksDialog(JFrame frame, boolean modal, ActionListener listener) {
        super(frame, modal);
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle("Books");
        initComponent(listener);
    }

    private void initComponent(ActionListener listener) {
        addBooksPanel(listener);
//        addAddBookDialog(listener);
        addBookInfoDialog(listener);
    }

    private void addBookInfoDialog(ActionListener listener) {
        bookInfoDialog = new BookInfoDialog(this, true, listener);
        bookInfoDialog.setVisible(true);
    }

    private void addAddBookDialog(ActionListener listener) {
        addBookDialog = new AddBookDialog(this, true, listener);
        addBookDialog.setVisible(true);
    }

    private void addBooksPanel(ActionListener listener) {
        booksPanel = new BooksPanel(listener);
        JScrollPane scrollPane = new JScrollPane(booksPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        getContentPane().add(scrollPane);
    }
}
