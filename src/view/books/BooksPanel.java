package view.books;

import view.SearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BooksPanel extends JPanel {
    private ActionListener actionListener;
    private MouseListener mouseListener;
    private JLabel titleLabel;
    private SearchPanel searchPanel;
    private List<JButton> bookButtons;
    private int bookIndex;
    private HashMap<String, String> bookInfo;

    public BooksPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        bookButtons = new ArrayList<>();
        bookInfo = new HashMap<>();
        this.actionListener = actionListener;
        this.mouseListener = mouseListener;
        setLayout(new GridBagLayout());
        setBackground(new Color(108, 135, 126));
        initComponents(keyListener);
    }

    private void initComponents(KeyListener keyListener) {
        titleLabel = new JLabel("Book List");
        searchPanel = new SearchPanel(actionListener, mouseListener, keyListener);
        searchPanel.setActionCommandAddButton("ADD_BOOK");
        addTitleLabel();
        addSearchPanel();
    }

    private void addBooksListPanel(String book, int index) {
        String[] bookArray = book.split(";");
        JButton bookButton = new JButton(new ImageIcon(new ImageIcon(bookArray[0]).getImage().getScaledInstance(136, 219, Image.SCALE_DEFAULT)));
        bookButton.setPreferredSize(new Dimension(136, 219));
        bookButton.setActionCommand("BOOK_" + index);
        bookInfo.put("BOOK_" + index, book);
        bookButton.addActionListener(actionListener);
        bookButton.addMouseListener(mouseListener);
        bookButton.setBackground(new Color(0, 0, 0));
        bookButton.setForeground(Color.WHITE);
        bookButton.setFocusable(false);
        bookButton.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        bookButtons.add(bookButton);
    }

    private void setButtonCoordinates(JButton bookButton, int counterX, int counterY) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = counterX;
        gbc.gridy = counterY;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.ipadx = 20;
        gbc.ipady = 20;
        add(bookButton, gbc);
    }

    private void addSearchPanel() {
        searchPanel.setWidthSearchBar(45);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(searchPanel, gbc);
    }

    private void addTitleLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.insets = new Insets(10, 0, 0, 0);
        titleLabel.setFont(new Font("Sans Serif", Font.BOLD, 30));
        add(titleLabel, gbc);
    }

    public void loadBooks(List<String> books) {
        bookButtons.forEach(this::remove);
        bookButtons.clear();
        for (int i = 0; i < books.size(); i++) {
            addBooksListPanel(books.get(i), i);
        }
        setBookCoordinates();
    }

    private void setBookCoordinates() {
        int counterX = 0;
        int counterY = 2;
        for (JButton bookButton : bookButtons) {
            if (bookButton != null) {
                if (counterX < 4) {
                    setButtonCoordinates(bookButton, counterX, counterY);
                    counterX++;
                } else if (counterX == 4) {
                    setButtonCoordinates(bookButton, counterX, counterY);
                    counterY++;
                    counterX = 0;
                }

            }
        }
    }

    public void setTextInSearchFieldBooks() {
        searchPanel.setTextInSearchField();
    }

    public String getSearchFieldTextBooks() {
        return searchPanel.getTextInSearchField();
    }

    public int getBooksListSize() {
        return bookButtons.size();
    }

    public void setBookIndex(int bookIndex) {
        this.bookIndex = bookIndex;
    }

    public String getIconPath(String actionCommand) {
        String[] bookArray = bookInfo.get(actionCommand).split(";");
        return bookArray[0];
    }

    public String getBookName(String actionCommand) {
        String[] bookArray = bookInfo.get(actionCommand).split(";");
        return bookArray[1];
    }

    public String getSelectedBook() {
        return getBookName("BOOK_" + bookIndex);
    }

    public void deleteBook() {
        bookButtons.remove(bookIndex);
        setBookCoordinates();
    }

    public void loadNewBook(String newBookInfo) {
        addBooksListPanel(newBookInfo, bookButtons.size());
        setBookCoordinates();
    }
}
