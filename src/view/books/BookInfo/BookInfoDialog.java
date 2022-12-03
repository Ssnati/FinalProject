package view.books.BookInfo;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BookInfoDialog extends JDialog {
    private BookInfoPanel bookInfoPanel;
    private BookHistoryPanel bookHistoryPanel;

    public BookInfoDialog(JDialog dialog, boolean modal, ActionListener listener) {
        super(dialog, modal);
        setTitle("Book Info");
        this.setSize(803,402);
        bookInfoPanel = new BookInfoPanel(listener);
        bookHistoryPanel = new BookHistoryPanel(listener);
        getContentPane().add(bookInfoPanel);
        getContentPane().add(bookHistoryPanel);
        setLocationRelativeTo(null);
    }
}
