package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {
    private JTextField searchTextField;
    private JButton addUserButton;

    public SearchPanel(ActionListener listener) {
        setLayout(new GridBagLayout());
        initComponents(listener);
        setBackground(new Color(0,0,0,0));
    }

    private void initComponents(ActionListener listener) {
        addSearchLabel();

        addTextField(listener);

        addUserButton = new JButton(new ImageIcon("sources/Plus.png"));
        addUserButton(listener);
    }

    private void addTextField(ActionListener listener) {
        searchTextField = new JTextField(14);
        searchTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        searchTextField.addActionListener(listener);
        searchTextField.setActionCommand("search");
        searchTextField.setToolTipText("Search");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(searchTextField, gbc);
    }

    private void addSearchLabel() {
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(searchLabel, gbc);
    }

    private void addUserButton(ActionListener listener) {
        addUserButton.addActionListener(listener);
        addUserButton.setActionCommand("Add User");
        addUserButton.setBorderPainted(false);
        addUserButton.setBackground(new Color(0, 0, 0, 0));
        addUserButton.setFocusable(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        add(addUserButton, gbc);
    }

    public void setWidthSearchBar(int width) {
        searchTextField.setColumns(width);
    }
}
