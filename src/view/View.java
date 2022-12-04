package view;

import view.books.BooksDialog;
import view.rent.SelectionDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;

public class View extends JFrame {
    private MainPanel mainPanel;
    private BooksDialog booksDialog;
    private UsersDialog usersDialog;
    private SelectionDialog selectionDialog;

    public View(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        setTitle("Library");
        setSize(1220, 600);
        initContent(actionListener, mouseListener, keyListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) {
        mainPanel = new MainPanel(actionListener, mouseListener);
        getContentPane().add(mainPanel);

        usersDialog = new UsersDialog(this, true, actionListener, mouseListener, keyListener);
        usersDialog.setVisible(false);

        booksDialog = new BooksDialog(this, true, actionListener, mouseListener, keyListener);
        booksDialog.setVisible(false);

        selectionDialog = new SelectionDialog(this, true, actionListener, mouseListener, keyListener);
        selectionDialog.setVisible(false);
    }

    public void mainPanelMouseOverButton(JButton button) {
        mainPanel.mouseOverButton(button);
    }

    public void mainPanelMouseExitedButton(JButton button) {
        mainPanel.mouseExitButton(button);
    }

    public void showRentDialog() {
        selectionDialog.setVisible(true);
    }

    public void showBooksDialog() {
        booksDialog.setVisible(true);
    }

    public void showUsersDialog() {
        usersDialog.setVisible(true);
    }

    public boolean isOneOfMainPanelButtons(JButton button) {
        return mainPanel.isOneOfButtons(button);
    }

    public void loadUsers(List<String> users) {
        usersDialog.loadUsers(users);
    }

    public void loadBooks(List<String> books) {
        booksDialog.loadBooks(books);
    }

    public int getUsersListSize() {
        return usersDialog.getUsersListSize();
    }

    public void showUserInfo(String userInfo) {
        usersDialog.showUserInfo(userInfo);
    }

    public String getUserInfo(int index) {
        return usersDialog.getUserInfo(index);
    }

    public void setTextInSearchFieldUsers() {
        usersDialog.setTextInSearchFieldUsers();
    }

    public String getSearchFieldTextUsers() {
        return usersDialog.getSearchFieldTextUsers();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void showAddUserDialog() {
        usersDialog.showAddUserDialog();
    }

    public boolean usersDialogIsVisible() {
        return usersDialog.isVisible();
    }

    public boolean addUserDialogIsVisible() {
        return usersDialog.addUserDialogIsVisible();
    }

    public void setPahToUserIcon(String actionCommand) {
        usersDialog.setPahToUserIcon(actionCommand);
    }

    public String getNewUserInfo() {
        return usersDialog.getNewUserInfo();
    }

    public boolean userInfoDialogIsVisible() {
        return usersDialog.userInfoDialogIsVisible();
    }

    public boolean booksDialogIsVisible() {
        return booksDialog.isVisible();
    }

    public boolean selectionDialogIsVisible() {
        return selectionDialog.isVisible();
    }

    public void removeUser(int userIndex) {
        usersDialog.removeUser(userIndex);
    }

    public void setUserIndex(int userIndex) {
        usersDialog.setUserIndex(userIndex);
    }

    public int getUserIndex() {
        return usersDialog.getUserIndex();
    }

    public void loadNewUser(String newUserInfo) {
        usersDialog.loadNewUser(newUserInfo);
    }

    public void setTextInSearchFieldBooks() {
        booksDialog.setTextInSearchFieldBooks();
    }

    public String getSearchFieldTextBooks() {
        return booksDialog.getSearchFieldTextBooks();
    }
}
