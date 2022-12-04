package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class SearchPanel extends JPanel {
    private JTextField searchTextField;
    private JButton addButton;
    private JLabel searchLabel;
    private StringBuilder textInSearchField;

    public SearchPanel(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        setLayout(new GridBagLayout());
        textInSearchField = new StringBuilder();
        initComponents(actionListener, mouseListener, keyListener);
        setBackground(new Color(0,0,0,0));
    }

    private void initComponents(ActionListener listener, MouseListener mouseListener, KeyListener keyListener) {
        searchTextField = new JTextField(14);

        addButton = new JButton(new ImageIcon("sources/Plus.png"));

        searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addSearchLabel();

        searchTextFieldFeatures(listener, keyListener);
        addSearchTextField();
        addButtonFeatures(listener, mouseListener);
        addAddButton();
    }

    private void addButtonFeatures(ActionListener listener, MouseListener mouseListener) {
        addButton.addActionListener(listener);
        addButton.addMouseListener(mouseListener);
        addButton.setBorderPainted(false);
        addButton.setBackground(new Color(0, 0, 0, 0));
        addButton.setBorderPainted(false);
        addButton.setFocusable(false);
        addButton.setContentAreaFilled(false);
    }

    private void searchTextFieldFeatures(ActionListener listener, KeyListener keyListener) {
        searchTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        searchTextField.addActionListener(listener);
        searchTextField.addKeyListener(keyListener);
    }

    public void setSearchActionCommand(String actionCommand) {
        searchTextField.setActionCommand(actionCommand);
    }

    public void setAddActionCommand(String actionCommand) {
        addButton.setActionCommand(actionCommand);
    }

    private void addSearchTextField() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(searchTextField, gbc);
    }

    private void addSearchLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(searchLabel, gbc);
    }

    private void addAddButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        add(addButton, gbc);
    }

    public void setWidthSearchBar(int width) {
        searchTextField.setColumns(width);
    }

    public void setTextInSearchField() {
        this.textInSearchField = new StringBuilder(searchTextField.getText());
    }

    public String getTextInSearchField() {
        return searchTextField.getText();
    }

    public void setActionCommandAddButton(String command) {
        addButton.setActionCommand(command);
    }
}
