package view.books.BookInfo;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class BookInfoDialog extends JDialog {
    private BookInfoPanel bookInfoPanel;
    private BookHistoryDialog bookHistoryDialog;

    public BookInfoDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener) {
        super(dialog, modal);
        setTitle("Book Info");
        this.setSize(803,402);
        bookInfoPanel = new BookInfoPanel(actionListener, mouseListener);
        getContentPane().add(bookInfoPanel);
        bookHistoryDialog = new BookHistoryDialog(this, true, actionListener, mouseListener);
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
