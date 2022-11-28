package view.user.addUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddUserPanel extends JPanel {
    private JLabel nameLabel,mailLabel,addressLabel,phoneLabel;
    private JTextField nameTextField,mailTextField,addressTextField,phoneTextField;
    private IconPanel iconPanel;
    private JButton saveUserButton;

    public AddUserPanel(ActionListener listener) {
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        addNameLabel();
        addNameTextField(listener);
        addMailLabel();
        addMailTextField(listener);
        addAddressLabel();
        addAddressTextField(listener);
        addPhoneLabel();
        addPhoneTextField(listener);
        addIconPanel(listener);
        addSaveUserButton(listener);
    }

    private void addNameLabel() {
        nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        nameLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
    }

    private void addNameTextField(ActionListener listener) {
        nameTextField = new JTextField(14);
        nameTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameTextField, gbc);
    }

    private void addMailLabel() {
        mailLabel = new JLabel("Mail:");
        mailLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mailLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(mailLabel, gbc);
    }

    private void addMailTextField(ActionListener listener) {
        mailTextField = new JTextField(14);
        mailTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(mailTextField, gbc);
    }

    private void addAddressLabel() {
        addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addressLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addressLabel, gbc);
    }

    private void addAddressTextField(ActionListener listener) {
        addressTextField = new JTextField(14);
        addressTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addressTextField, gbc);
    }

    private void addPhoneLabel() {
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        phoneLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(phoneLabel, gbc);
    }

    private void addPhoneTextField(ActionListener listener) {
        phoneTextField = new JTextField(14);
        phoneTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(phoneTextField, gbc);
    }

    private void addIconPanel(ActionListener listener) {
        iconPanel = new IconPanel(listener);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(iconPanel, gbc);
    }

    private void addSaveUserButton(ActionListener listener) {
        saveUserButton = new JButton("Save");
        saveUserButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        saveUserButton.addActionListener(listener);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(saveUserButton, gbc);
    }
}
