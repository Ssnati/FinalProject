package view.rent;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class SelectionDialog extends JDialog {
    private SelectionPanel selectionPanel;
    private OperationDialog operationDialog;

    public SelectionDialog(JFrame frame, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        super(frame, modal);
        setTitle("Selection");
        this.setSize(744,338);
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        selectionPanel = new SelectionPanel(actionListener, mouseListener);
        operationDialog = new OperationDialog(this, true, actionListener, mouseListener, keyListener);
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

    public boolean rentDialogIsVisible() {
        return operationDialog.isVisible();
    }

    public boolean returnDialogIsVisible() {
        return operationDialog.isVisible();
    }

    public boolean rentPanelIsVisible() {
        return operationDialog.rentPanelIsVisible();
    }

    public boolean returnPanelIsVisible() {
        return operationDialog.returnPanelIsVisible();
    }

    public void showOperationUsersDialog() {
        operationDialog.showOperationUsersDialog();
    }

    public void showOperationBooksDialog() {
        operationDialog.showOperationBooksDialog();
    }

    public boolean showRentDialogIsVisible() {
        return operationDialog.showRentDialogIsVisible();
    }

    public boolean operationPanelIsVisible() {
        return operationDialog.operationPanelIsVisible();
    }

    public void setOperationCommand(String actionCommand) {
        operationDialog.setOperationCommand(actionCommand);
    }

    public String getOperationDialog() {
        return operationDialog.getOperationDialog();
    }

    public void setUserSelectedPath(String userImageSource) {
        operationDialog.setUserSelectedPath(userImageSource);
    }

    public void setBookSelectedPath(String bookImageSource) {
        operationDialog.setBookSelectedPath(bookImageSource);
    }
}
