package view.user.addUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AddUserPanel extends JPanel {
    private JLabel nameLabel,mailLabel,addressLabel,phoneLabel;
    private JTextField nameTextField,mailTextField,addressTextField,phoneTextField;
    private IconPanel iconPanel;
    private JButton saveUserButton;

    public AddUserPanel(ActionListener actionListener, MouseListener mouseListener) {
        setBackground(Color.black);
        setLayout(new GridBagLayout());
        initComponents(actionListener, mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        nameLabel = new JLabel("Name:");
        addNameLabel();
        nameTextField = new JTextField(14);
        addNameTextField();
        mailLabel = new JLabel("Mail:");
        addMailLabel();
        mailTextField = new JTextField(14);
        addMailTextField();
        addressLabel = new JLabel("Address:");
        addAddressLabel();
        addressTextField = new JTextField(14);
        addAddressTextField();
        phoneLabel = new JLabel("Phone:");
        addPhoneLabel();
        phoneTextField = new JTextField(14);
        addPhoneTextField();
        iconPanel = new IconPanel(actionListener, mouseListener);
        addIconPanel();
        saveUserButton = new JButton("Save");
        addSaveUserButton(actionListener, mouseListener);
    }

    private void addNameLabel() {
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        nameLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
    }

    private void addNameTextField() {
        nameTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameTextField, gbc);
    }

    private void addMailLabel() {
        mailLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        mailLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(mailLabel, gbc);
    }

    private void addMailTextField() {
        mailTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(mailTextField, gbc);
    }

    private void addAddressLabel() {
        addressLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addressLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addressLabel, gbc);
    }

    private void addAddressTextField() {
        addressTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addressTextField, gbc);
    }

    private void addPhoneLabel() {
        phoneLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        phoneLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(phoneLabel, gbc);
    }

    private void addPhoneTextField() {
        phoneTextField.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(phoneTextField, gbc);
    }

    private void addIconPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 7;
        gbc.insets = new Insets(0, 10, 0, 0);
        add(iconPanel, gbc);
    }

    private void addSaveUserButton(ActionListener actionListener, MouseListener mouseListener) {
        saveUserButton.addActionListener(actionListener);
        saveUserButton.addMouseListener(mouseListener);
        saveUserButton.setActionCommand("SAVE_USER");
        saveUserButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(saveUserButton, gbc);
    }

    public String getNewUserInfo() {
        return  iconPanel.getSelectedIconPath()+";"+nameTextField.getText() + ";" + mailTextField.getText() + ";" + addressTextField.getText() + ";" + phoneTextField.getText();
    }

    public void setPahToUserIcon(String actionCommand) {
        iconPanel.setPathToUserIcon(actionCommand);
    }

    public void clearFields() {
        nameTextField.setText("");
        mailTextField.setText("");
        addressTextField.setText("");
        phoneTextField.setText("");
        iconPanel.clearIcon();
    }
}
