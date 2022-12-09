package view.user;

import persistence.PrivateProperties;
import view.user.addUser.AddUserDialog;
import view.user.userInfo.UserInfoDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
public class UsersDialog extends JDialog {
    private final PrivateProperties properties;
    private UsersPanel usersPanel;
    private UserInfoDialog userInfoDialog;
    private AddUserDialog addUserDialog;
    private JScrollPane scrollPane;

    public UserInfoDialog getUserInfoDialog() {
        return userInfoDialog;
    }

    public UsersPanel getUsersPanel() {
        return usersPanel;
    }

    public AddUserDialog getAddUserDialog() {
        return addUserDialog;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public UsersDialog(JFrame frame, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener, PrivateProperties properties) {
        super(frame, modal);
        this.properties = properties;
        setTitle(properties.getUsersDialogTitle());
        setSize(382, 723);
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        usersPanel = new UsersPanel(actionListener, mouseListener, keyListener, properties);
        scrollPane = new JScrollPane(usersPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);

        addAddUserDialog(actionListener, mouseListener);
        addUserInfoDialog(actionListener, mouseListener);
        getContentPane().add(scrollPane);
    }

    private void addAddUserDialog(ActionListener actionListener, MouseListener mouseListener) {
        addUserDialog = new AddUserDialog(this, true, actionListener, mouseListener, properties);
        addUserDialog.setVisible(false);
    }

    private void addUserInfoDialog(ActionListener actionListener, MouseListener mouseListener) {
        userInfoDialog = new UserInfoDialog(this, true, actionListener, mouseListener, properties);
        userInfoDialog.setVisible(false);
    }

    public void loadUsers(List<String> users) {
        usersPanel.loadUsers(users);
        usersPanel.updateUI();
    }

    public void showUserInfo(String userInfo) {
        userInfoDialog.showUserInfo(userInfo);
        userInfoDialog.setVisible(true);
    }

    public boolean addUserDialogIsVisible() {
        return addUserDialog.isVisible();
    }

    public boolean userInfoDialogIsVisible() {
        return userInfoDialog.isVisible();
    }

    public void loadNewUser(String newUserInfo) {
        usersPanel.loadNewUser(newUserInfo);
        addUserDialog.clearFields();
        addUserDialog.setVisible(false);
        usersPanel.updateUI();
    }

    public void updateUsersPanel() {
        usersPanel.updateUI();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }
}