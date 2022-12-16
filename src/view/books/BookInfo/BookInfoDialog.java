package view.books.BookInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class BookInfoDialog extends JDialog {
    private BookInfoPanel bookInfoPanel;
    private BookHistoryDialog bookHistoryDialog;

    public BookInfoDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        super(dialog, modal);
        setTitle(properties.getBookInfoDialogTitle());
        this.setSize(923,452);
        bookInfoPanel = new BookInfoPanel(actionListener, mouseListener, properties);
        getContentPane().add(bookInfoPanel);
        bookHistoryDialog = new BookHistoryDialog(this, true, properties);
        setLocationRelativeTo(null);
    }

    public void showBookInfo(String bookToView) {
        bookInfoPanel.showBookInfo(bookToView);
        bookInfoPanel.updateUI();
    }

    public void showHistoryDialog(List<String> rentHistory) {
        bookHistoryDialog.showHistory(rentHistory);
        bookHistoryDialog.setVisible(true);
    }
}
