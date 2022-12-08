package view.books;

import view.books.BookInfo.BookInfoDialog;
import view.books.addBook.AddBookDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

public class BooksDialog extends JDialog {
    private BooksPanel booksPanel;
    private AddBookDialog addBookDialog;

    private BookInfoDialog bookInfoDialog;

    public BooksDialog(JFrame frame, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        super(frame, modal);
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle("Books");
        initComponent(listener, mouseListener, keyListener);
    }

    public BooksDialog(JDialog dialog, boolean modal, ActionListener listener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        super(dialog, modal);
        setSize(945, 704);
        setLocationRelativeTo(null);
        setTitle("Books");
        initComponent(listener, mouseListener, keyListener);
    }

    private void initComponent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        addBooksPanel(actionListener, mouseListener, keyListener);
        addAddBookDialog(actionListener, mouseListener);
        addBookInfoDialog(actionListener, mouseListener);
    }

    private void addBookInfoDialog(ActionListener actionListener, MouseListener mouseListener) {
        bookInfoDialog = new BookInfoDialog(this, true, actionListener, mouseListener);
        bookInfoDialog.setVisible(false);
    }

    private void addAddBookDialog(ActionListener actionListener, MouseListener mouseListener) throws IOException {
        addBookDialog = new AddBookDialog(this, true, actionListener, mouseListener);
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
        booksPanel.updateUI();
    }

    public void setTextInSearchFieldBooks() {
        booksPanel.setTextInSearchFieldBooks();
    }

    public String getSearchFieldTextBooks() {
        return booksPanel.getSearchFieldTextBooks();
    }

    public int getBooksListSize() {
        return booksPanel.getBooksListSize();
    }

    public void setBookIndex(int bookIndex) {
        booksPanel.setBookIndex(bookIndex);
    }

    public String getPathToBook(String actionCommand) {
        return booksPanel.getIconPath(actionCommand);
    }

    public void showBookInfo(String bookToView) {
        bookInfoDialog.showBookInfo(bookToView);
        bookInfoDialog.setVisible(true);
    }

    public String getBookName(String actionCommand) {
        return booksPanel.getBookName(actionCommand);
    }

    public boolean booksInfoDialogIsVisible() {
        return bookInfoDialog.isVisible();
    }

    public String getSelectedBook() {
        return booksPanel.getSelectedBook();
    }

    public void deleteBook() {
        booksPanel.deleteBook();
    }

    public void showHistoryDialog(List<String> rentHistory) {
        bookInfoDialog.showHistoryDialog(rentHistory);
    }

    public void showAddBookDialog() {
        addBookDialog.setVisible(true);
    }

    public boolean addBookDialogIsVisible() {
        return addBookDialog.isVisible();
    }

    public void setPahCoverToNewBook(String bookName) {
        addBookDialog.setPahCoverToNewBook(bookName);
    }

    public String getNewBookInfo() {
        return addBookDialog.getNewBookInfo();
    }

    public void loadNewBook(String newBookInfo) {
        booksPanel.loadNewBook(newBookInfo);
        booksPanel.updateUI();
    }

    public BooksPanel getBooksPanel() {
        return booksPanel;
    }

    public void showFileChooser(int pathNumber) {
        addBookDialog.getAddBookPanel().showFileChooser(pathNumber);
        addBookDialog.getAddBookPanel().updateUI();
    }

    public String getBookPathCover() {
        return addBookDialog.getAddBookPanel().getPathCover();
    }

    public void closeAddBookDialog() {
        addBookDialog.setVisible(false);
        addBookDialog.getAddBookPanel().cleanFields();
    }

    public int getBookIndex() {
        return booksPanel.getBookIndex();
    }
}
