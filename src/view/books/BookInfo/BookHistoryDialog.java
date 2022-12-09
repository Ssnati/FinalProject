package view.books.BookInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.util.List;

public class BookHistoryDialog extends JDialog {
    private BookHistoryPanel bookHistoryPanel;

    public BookHistoryDialog(JDialog dialog, boolean modal, PrivateProperties properties) {
        super(dialog, modal);
        setTitle(properties.getBookHistoryDialogTitle());
        bookHistoryPanel = new BookHistoryPanel(properties);
        getContentPane().add(bookHistoryPanel);
        this.setSize(803,402);
        setLocationRelativeTo(null);
    }

    public void showHistory(List<String> rentHistory) {
        bookHistoryPanel.showHistory(rentHistory);
    }
}
