package view.rent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;

public class OperationDialog extends JDialog {
    private MidPanel midPanel;
    private String operation;

    public OperationDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        super(dialog, modal);
        setTitle("Operation");
        this.setSize(744, 338);
        setLayout(new GridBagLayout());
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener){
        midPanel = new MidPanel(actionListener, mouseListener);
        addMidPanel();
    }

    private void addMidPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        add(midPanel, gbc);
    }

    public void showRentPanel() {
        midPanel.showRentPanel();
        midPanel.updateUI();
    }

    public void showReturnPanel() {
        midPanel.showReturnPanel();
        midPanel.updateUI();
    }

    public boolean rentPanelIsVisible() {
        return midPanel.rentPanelIsVisible();
    }

    public boolean returnPanelIsVisible() {
        return midPanel.returnPanelIsVisible();
    }

    public boolean operationPanelIsVisible() {
        return midPanel.isVisible();
    }

    public void setOperationCommand(String actionCommand) {
        operation = actionCommand;
    }

    public String getOperationDialog() {
        return operation;
    }

    public void setUserSelectedPath(String userImageSource) {
        midPanel.setUserSelectedPath(userImageSource);
    }

    public void setBookSelectedPath(String bookImageSource) {
        midPanel.setBookSelectedPath(bookImageSource);
    }

    public void clearOperationPanel() {
        midPanel.clearOperationPanel();
    }
}
