package view.rent;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class MidPanel extends JPanel {
    private OperationPanel rentPanel, returnPanel;

    public MidPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        setBackground(new Color(158, 107, 189));

        rentPanel = new OperationPanel(actionListener, mouseListener, properties);
        rentPanel.addRentButton();
        rentPanel.setVisible(false);

        returnPanel = new OperationPanel(actionListener, mouseListener, properties);
        returnPanel.addReturnButton();
        returnPanel.setVisible(false);

        add(rentPanel);
        add(returnPanel);
    }

    public void showRentPanel() {
        rentPanel.setVisible(true);
        returnPanel.setVisible(false);
    }

    public void showReturnPanel() {
        rentPanel.setVisible(false);
        returnPanel.setVisible(true);
    }

    public void setUserSelectedPath(String userImageSource) {
        rentPanel.setUserInfo(userImageSource);
        returnPanel.setUserInfo(userImageSource);
        rentPanel.updateUI();
        returnPanel.updateUI();
    }

    public void setBookSelectedPath(String bookImageSource) {
        rentPanel.setBookInfo(bookImageSource);
        returnPanel.setBookInfo(bookImageSource);
        rentPanel.updateUI();
        returnPanel.updateUI();
    }

    public void clearOperationPanel() {
        rentPanel.clearFields();
        returnPanel.clearFields();
    }
}
