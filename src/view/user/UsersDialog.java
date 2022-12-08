package view.user;

import view.books.BooksPanel;
import view.user.addUser.AddUserDialog;
import view.user.userInfo.UserInfoDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

public class UsersDialog extends JDialog {
    private UsersPanel usersPanel;
    private UserInfoDialog userInfoDialog;
    private AddUserDialog addUserDialog;
    private JScrollPane scrollPane;

    public UsersDialog(JFrame frame, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        super(frame, modal);
        setTitle("Users");
        setSize(382, 723);
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    public UsersDialog(JDialog dialog, boolean modal, ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        super(dialog, modal);
        setTitle("Users");
        setSize(382, 723);
        initContent(actionListener, mouseListener, keyListener);
        setLocationRelativeTo(null);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        usersPanel = new UsersPanel(actionListener, mouseListener, keyListener);
        scrollPane = new JScrollPane(usersPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);

        addAddUserDialog(actionListener, mouseListener);
        addUserInfoDialog(actionListener, mouseListener);
        getContentPane().add(scrollPane);
    }

    private void addAddUserDialog(ActionListener actionListener, MouseListener mouseListener) {
        addUserDialog = new AddUserDialog(this, true, actionListener, mouseListener);
        addUserDialog.setVisible(false);
    }

    private void addUserInfoDialog(ActionListener actionListener, MouseListener mouseListener) {
        userInfoDialog = new UserInfoDialog(this, true, actionListener, mouseListener);
        userInfoDialog.setVisible(false);
    }

    public void loadUsers(List<String> users) {
        usersPanel.loadUsers(users);
        usersPanel.updateUI();
    }

    public int getUsersListSize() {
        return usersPanel.getUsersListSize();
    }

    public void showUserInfo(String userInfo) {
        userInfoDialog.showUserInfo(userInfo);
        userInfoDialog.setVisible(true);
    }

    public String getUserInfo(int index) {
        return usersPanel.getUserInfo(index);
    }

    public void setTextInSearchFieldUsers() {
        usersPanel.setTextInSearchFieldUsers();
    }

    public String getSearchFieldTextUsers() {
        return usersPanel.getSearchFieldTextUsers();
    }

    public void showAddUserDialog() {
        addUserDialog.setVisible(true);
    }

    public boolean addUserDialogIsVisible() {
        return addUserDialog.isVisible();
    }

    public void setPahToUserIcon(String actionCommand) {
        addUserDialog.setPahToUserIcon(actionCommand);
    }

    public String getNewUserInfo() {
        return addUserDialog.getNewUserInfo();
    }

    public boolean userInfoDialogIsVisible() {
        return userInfoDialog.isVisible();
    }

    public void removeUser(int userIndex) {
        usersPanel.removeUser(userIndex);
        usersPanel.updateUI();
    }

    public void setUserIndex(int userIndex) {
        usersPanel.setUserIndex(userIndex);
    }

    public int getUserIndex() {
        return usersPanel.getUserIndex();
    }

    public void loadNewUser(String newUserInfo) {
        usersPanel.loadNewUser(newUserInfo);
        addUserDialog.clearFields();
        addUserDialog.setVisible(false);
        usersPanel.updateUI();
    }

    public String printSizeUserInfoDialog() {
        return userInfoDialog.printSize();
    }

    public AddUserDialog getAddUserDialog() {
        return addUserDialog;
    }

    public UsersPanel getUsersPanel() {
        return usersPanel;
    }
}