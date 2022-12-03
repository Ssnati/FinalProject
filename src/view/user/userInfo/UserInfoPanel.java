package view.user.userInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserInfoPanel extends JPanel {
    private JLabel imageIcon, nameLabel, emailLabel, addressLabel, phoneLabel, rentedBooksLabel;
    private JButton deleteUserButton;

    public UserInfoPanel(ActionListener listener) {
        setLayout(new GridBagLayout());
        setBackground(new java.awt.Color(231, 90, 30));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        addImageIcon();
        addNameLabel();
        addEmailLabel();
        addAddressLabel();
        addPhoneLabel();
        addRentedBooksLabel();
        addDeleteUserButton(listener);
    }

    private void addImageIcon() {
        imageIcon = new JLabel();
        imageIcon.setIcon(new ImageIcon("sources/userIcons/Male Icon 1.png"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        add(imageIcon, gbc);
    }

    private void addNameLabel() {
        nameLabel = new JLabel("Name: Santiago");
        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        nameLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);
    }

    private void addEmailLabel() {
        emailLabel = new JLabel("Email: Santiago@uptc.edu.co");
        emailLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        emailLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
    }

    private void addAddressLabel() {
        addressLabel = new JLabel("Address: Cra 1 # 2 - 3");
        addressLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        addressLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(addressLabel, gbc);
    }

    private void addPhoneLabel() {
        phoneLabel = new JLabel("Phone: 123456789");
        phoneLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        phoneLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(phoneLabel, gbc);
    }

    private void addRentedBooksLabel() {
        rentedBooksLabel = new JLabel("Rented Books: 0");
        rentedBooksLabel.setFont(new Font("Sans Serif", Font.BOLD, 20));
        rentedBooksLabel.setForeground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(rentedBooksLabel, gbc);
    }

    private void addDeleteUserButton(ActionListener listener) {
        deleteUserButton = new JButton("Delete User");
        deleteUserButton.setUI(new SpecialButton(140, deleteUserButton.getPreferredSize().height*2,
                25, 25, new Color(255, 193, 193)));
        deleteUserButton.setBorderPainted(false);
        deleteUserButton.setBackground(new Color(255, 193, 193));
        deleteUserButton.setFont(new Font("Sans Serif", Font.BOLD, 20));
        deleteUserButton.setFocusPainted(false);
        deleteUserButton.setContentAreaFilled(false);
        deleteUserButton.addActionListener(listener);
        deleteUserButton.setActionCommand("DELETE_USER");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(20, 0, 0, 0);
        add(deleteUserButton, gbc);
    }
}
