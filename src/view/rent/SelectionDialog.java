package view.rent;

import view.books.BooksDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SelectionDialog extends JDialog {
    private SelectionPanel selectionPanel;
    private OperationPanel operationPanel;

    public SelectionDialog(JFrame frame, boolean modal, ActionListener actionListener) {
        super(frame, modal);
        setTitle("Selection");
        this.setSize(744,338);
        initContent(actionListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener) {
        selectionPanel = new SelectionPanel(actionListener);
        operationPanel = new OperationPanel(actionListener);

        new UsersDialog(this, true, actionListener);
        new BooksDialog(this, true, actionListener);

        getContentPane().add(selectionPanel);
        getContentPane().add(operationPanel);
    }
}
