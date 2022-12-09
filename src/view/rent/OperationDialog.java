package view.rent;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class OperationDialog extends JDialog {
    private final PrivateProperties properties;
    private MidPanel midPanel;
    private String operation;

    public MidPanel getMidPanel() {
        return midPanel;
    }

    public String getOperationCommand() {
        return operation;
    }

    public void setOperationCommand(String actionCommand) {
        operation = actionCommand;
    }

    public OperationDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties){
        super(dialog, modal);
        this.properties = properties;
        setTitle(properties.getOperationDialogTitle());
        this.setSize(744, 338);
        setLayout(new GridBagLayout());
        initContent(actionListener, mouseListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener){
        midPanel = new MidPanel(actionListener, mouseListener, properties);
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

    public boolean operationPanelIsVisible() {
        return midPanel.isVisible();
    }
}
