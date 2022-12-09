package view.rent;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class SelectionDialog extends JDialog {
    private final PrivateProperties properties;
    private SelectionPanel selectionPanel;
    private OperationDialog operationDialog;

    public SelectionPanel getSelectionPanel() {
        return selectionPanel;
    }

    public OperationDialog getOperationDialog() {
        return operationDialog;
    }

    public SelectionDialog(JFrame frame, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener, PrivateProperties properties) {
        super(frame, modal);
        this.properties = properties;
        setTitle(properties.getSelectionDialogTitle());
        this.setSize(744,338);
        initContent(actionListener, mouseListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener) {
        selectionPanel = new SelectionPanel(actionListener, mouseListener, properties);
        operationDialog = new OperationDialog(this, true, actionListener, mouseListener, properties);
        operationDialog.setVisible(false);
        getContentPane().add(selectionPanel);
    }

    public void showRentDialog() {
        operationDialog.showRentPanel();
        operationDialog.setVisible(true);
    }

    public void showReturnDialog() {
        operationDialog.showReturnPanel();
        operationDialog.setVisible(true);
    }
}
