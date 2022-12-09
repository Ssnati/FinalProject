package view.user.addUser;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class AddUserPanel extends JPanel {
    private final PrivateProperties properties;
    private JLabel nameLabel,mailLabel,addressLabel,phoneLabel;
    private JTextField nameTextField,mailTextField,addressTextField,phoneTextField;
    private IconPanel iconPanel;
    private JButton saveUserButton;
    private final Font labelsFont = new Font("Sans Serif", Font.BOLD, 20), textFieldsFont = new Font("Sans Serif", Font.PLAIN, 20);

    public AddUserPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        setLayout(new GridBagLayout());
        setBackground(Color.black);
        initComponents(actionListener, mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        nameLabel = new JLabel(properties.btn_txt_userPanelName());
        addNameLabel();
        nameTextField = new JTextField(14);
        addNameTextField();
        mailLabel = new JLabel(properties.btn_txt_userInfoPanelEmail());
        addMailLabel();
        mailTextField = new JTextField(14);
        addMailTextField();
        addressLabel = new JLabel(properties.btn_txt_userInfoPanelAddress());
        addAddressLabel();
        addressTextField = new JTextField(14);
        addAddressTextField();
        phoneLabel = new JLabel(properties.btn_txt_userInfoPanelPhone());
        addPhoneLabel();
        phoneTextField = new JTextField(14);
        addPhoneTextField();
        iconPanel = new IconPanel(actionListener, mouseListener, properties);
        addIconPanel();
        saveUserButton = new JButton(properties.btn_txt_userInfoPanelSaveUserButton());
        addSaveUserButton(actionListener, mouseListener);
    }

    private void addNameLabel() {
        nameLabel.setFont(labelsFont);
        nameLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);
    }

    private void addNameTextField() {
        nameTextField.setFont(textFieldsFont);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameTextField, gbc);
    }

    private void addMailLabel() {
        mailLabel.setFont(labelsFont);
        mailLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(mailLabel, gbc);
    }

    private void addMailTextField() {
        mailTextField.setFont(textFieldsFont);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(mailTextField, gbc);
    }

    private void addAddressLabel() {
        addressLabel.setFont(labelsFont);
        addressLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(addressLabel, gbc);
    }

    private void addAddressTextField() {
        addressTextField.setFont(textFieldsFont);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(addressTextField, gbc);
    }

    private void addPhoneLabel() {
        phoneLabel.setFont(labelsFont);
        phoneLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(phoneLabel, gbc);
    }

    private void addPhoneTextField() {
        phoneTextField.setFont(textFieldsFont);
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
        saveUserButton.setActionCommand(properties.ac_userInfoPanelSaveUserButton());
        saveUserButton.setFont(labelsFont);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        add(saveUserButton, gbc);
    }

    public String getNewUserInfo() {
        return  iconPanel.getSelectedIconPath()+properties.getSplitter()+nameTextField.getText() + properties.getSplitter() + mailTextField.getText() + properties.getSplitter() + addressTextField.getText() + properties.getSplitter() + phoneTextField.getText();
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
