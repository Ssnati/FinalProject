package view.user.userInfo;

import persistence.PrivateProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class UserInfoPanel extends JPanel {
    private JLabel imageIcon, nameLabel, emailLabel, addressLabel, phoneLabel, rentedBooksLabel;
    private JButton deleteUserButton;
    private final PrivateProperties properties;

    public UserInfoPanel(ActionListener actionListener, MouseListener mouseListener, PrivateProperties properties) {
        this.properties = properties;
        setLayout(new GridBagLayout());
        setBackground(new java.awt.Color(231, 90, 30));
        initComponents(actionListener, mouseListener);
    }

    private void initComponents(ActionListener actionListener, MouseListener mouseListener) {
        imageIcon = new JLabel(new ImageIcon());
        nameLabel = new JLabel();
        setLabelProperties(nameLabel);
        emailLabel = new JLabel();
        setLabelProperties(emailLabel);
        addressLabel = new JLabel();
        setLabelProperties(addressLabel);
        phoneLabel = new JLabel();
        setLabelProperties(phoneLabel);
        rentedBooksLabel = new JLabel();
        setLabelProperties(rentedBooksLabel);
        deleteUserButton = new JButton(properties.btn_txt_deleteUserButton());
        setDeleteUserButtonProperties(actionListener, mouseListener);
        addImageIcon();
        addNameLabel();
        addEmailLabel();
        addAddressLabel();
        addPhoneLabel();
        addRentedBooksLabel();
        addDeleteUserButton();
    }

    private void setDeleteUserButtonProperties(ActionListener actionListener, MouseListener mouseListener) {
        deleteUserButton.setUI(new SpecialButton(deleteUserButton.getPreferredSize().width*29/20, deleteUserButton.getPreferredSize().height * 2,
                25, 25, new Color(255, 193, 193)));
        deleteUserButton.setBorderPainted(false);
        deleteUserButton.setBackground(new Color(255, 193, 193));
        deleteUserButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        deleteUserButton.setFocusPainted(false);
        deleteUserButton.setContentAreaFilled(false);
        deleteUserButton.addActionListener(actionListener);
        deleteUserButton.addMouseListener(mouseListener);
        deleteUserButton.setActionCommand(properties.ac_deleteUserButtonUserInfoPanel());
    }

    private void setLabelProperties(JLabel label) {
        label.setFont(new Font("Sans Serif", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));
    }

    private void addImageIcon() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(imageIcon, gbc);
    }

    private void addNameLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);
    }

    private void addEmailLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(emailLabel, gbc);
    }

    private void addAddressLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(addressLabel, gbc);
    }

    private void addPhoneLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(phoneLabel, gbc);
    }

    private void addRentedBooksLabel() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(rentedBooksLabel, gbc);
    }

    private void addDeleteUserButton() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(deleteUserButton, gbc);
    }

    public void showUserInfo(String userInfo) {
        String[] info = userInfo.split(properties.getSplitter());
        imageIcon.setIcon(new ImageIcon(info[0]));
        nameLabel.setText(properties.btn_txt_userPanelName() + info[1]);
        emailLabel.setText(properties.btn_txt_userInfoPanelEmail() + info[2]);
        addressLabel.setText(properties.btn_txt_userInfoPanelAddress() + info[3]);
        phoneLabel.setText(properties.btn_txt_userInfoPanelPhone() + info[4]);
        rentedBooksLabel.setText(properties.btn_txt_userPanelRentedBooks() + info[5]);
    }
}
