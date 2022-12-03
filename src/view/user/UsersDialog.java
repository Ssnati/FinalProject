package view.user;

import view.user.addUser.AddUserDialog;
import view.user.userInfo.UserInfoDialog;

import javax.swing.*;
import java.awt.event.ActionListener;

public class UsersDialog extends JDialog {
    private UsersPanel usersPanel;
    private UserInfoDialog userInfoDialog;

    public UsersDialog(JFrame frame, boolean modal, ActionListener listener) {
        super(frame, modal);
        setTitle("Users");
        setSize(382, 723);
        usersPanel = new UsersPanel(listener);
        JScrollPane scrollPane = new JScrollPane(usersPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        addAddUserDialog(listener);
        addUserInfoDialog(listener);
        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
    }

    public UsersDialog(JDialog dialog, boolean modal, ActionListener listener) {
        super(dialog, modal);
        setTitle("Users");
        setSize(382, 723);
        usersPanel = new UsersPanel(listener);
        JScrollPane scrollPane = new JScrollPane(usersPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        addAddUserDialog(listener);
        addUserInfoDialog(listener);
        getContentPane().add(scrollPane);
        setLocationRelativeTo(null);
    }

    private void addAddUserDialog(ActionListener listener) {
        AddUserDialog addUserDialog = new AddUserDialog(this, true, listener);
        addUserDialog.setVisible(true);
    }

    private void addUserInfoDialog(ActionListener listener) {
        userInfoDialog = new UserInfoDialog(this, true, listener);
        userInfoDialog.setVisible(true);
    }
}