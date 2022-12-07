package view.books.BookInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class BookHistoryDialog extends JDialog {
    private BookHistoryPanel bookHistoryPanel;

    public BookHistoryDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener) {
        super(dialog, modal);
        setTitle("Book History");
        bookHistoryPanel = new BookHistoryPanel(actionListener, mouseListener);
        getContentPane().add(bookHistoryPanel);
        this.setSize(803,402);
        setLocationRelativeTo(null);
    }

    public void showHistory(List<String> rentHistory) {
        bookHistoryPanel.showHistory(rentHistory);
    }
}
