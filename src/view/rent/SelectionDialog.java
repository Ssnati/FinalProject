package view.rent;

import view.books.BooksDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class SelectionDialog extends JDialog {
    private SelectionPanel selectionPanel;
    private OperationPanel operationPanel;

    public SelectionDialog(JFrame frame, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        super(frame, modal);
        setTitle("Selection");
        this.setSize(744,338);
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        selectionPanel = new SelectionPanel(actionListener);
        operationPanel = new OperationPanel(actionListener);

        new UsersDialog(this, true, actionListener, mouseListener, keyListener);
        new BooksDialog(this, true, actionListener, mouseListener, keyListener);

        getContentPane().add(selectionPanel);
        getContentPane().add(operationPanel);
    }
}
