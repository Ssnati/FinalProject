package view;

import view.books.BooksDialog;
import view.rent.SelectionDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.List;

public class View extends JFrame {
    private MainPanel mainPanel;
    private BooksDialog booksDialog;
    private UsersDialog usersDialog;
    private SelectionDialog selectionDialog;
    private int copyId;

    public View(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        setTitle("Library");
        setSize(1220, 600);
        initContent(actionListener, mouseListener, keyListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
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

    public void selectionDialog() {
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
        booksDialog.getBooksPanel().loadBooks(books);
        booksDialog.getBooksPanel().updateUI();
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
        usersDialog.getAddUserDialog().setVisible(true);
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

    public int getBooksListSize() {
        return booksDialog.getBooksListSize();
    }

    public void setBookIndex(int bookIndex) {
        booksDialog.setBookIndex(bookIndex);
    }

    public void showBookInfo(String bookToView) {
        booksDialog.showBookInfo(bookToView);
    }

    public String getBookName(String actionCommand) {
        return booksDialog.getBookName(actionCommand);
    }

    public boolean booksInfoDialogIsVisible() {
        return booksDialog.booksInfoDialogIsVisible();
    }

    public String getSelectedBook() {
        return booksDialog.getSelectedBook();
    }

    public void showHistoryDialog(List<String> rentHistory) {
        booksDialog.showHistoryDialog(rentHistory);
    }

    public int getIdToRemove(List<Integer> list) throws NumberFormatException, IndexOutOfBoundsException{
        try {
            return (int) JOptionPane.showInputDialog(null, "Select copy Id", "Remove Copy", JOptionPane.QUESTION_MESSAGE, null, list.toArray(), list.get(0));
        } catch (NullPointerException e) {
            return -1;
        } catch (IndexOutOfBoundsException e) {
            return -2;
        }
    }

    public int getNewId() {
        int newId;
        Object id = JOptionPane.showInputDialog(null, "Enter new copy Id", "Add Copy", JOptionPane.QUESTION_MESSAGE);
        if (id == null) {
            newId = 0;
        } else {
            try {
                newId = Integer.parseInt(id.toString());
            } catch (NumberFormatException e) {
                newId = -1;
            }
        }
        if (newId < 0) {
            newId = -1;
        }
        return newId;
    }

    public void showAddBookDialog() {
        booksDialog.showAddBookDialog();
    }

    public boolean addBookDialogIsVisible() {
        return booksDialog.addBookDialogIsVisible();
    }

    public void setPahCoverToNewBook(String bookName) {
        booksDialog.setPahCoverToNewBook(bookName);
    }

    public String getNewBookInfo() {
        return booksDialog.getNewBookInfo();
    }

    public void loadNewBook(String newBookInfo) {
        booksDialog.loadNewBook(newBookInfo);
        closeAddBookDialog();
    }

    public void showRentDialog() {
        selectionDialog.showRentDialog();
    }

    public void showReturnDialog() {
        selectionDialog.showReturnDialog();
    }

    public boolean rentPanelIsVisible() {
        return selectionDialog.rentPanelIsVisible();
    }

    public boolean returnPanelIsVisible() {
        return selectionDialog.returnPanelIsVisible();
    }

    public void showOperationUsersDialog() {
        selectionDialog.showOperationUsersDialog();
    }

    public void showOperationBooksDialog() {
        selectionDialog.showOperationBooksDialog();
    }

    public boolean rentDialogIsVisible() {
        return selectionDialog.rentDialogIsVisible();
    }

    public boolean showRentDialogIsVisible() {
        return selectionDialog.showRentDialogIsVisible();
    }

    public boolean operationPanelIsVisible() {
        return selectionDialog.operationPanelIsVisible();
    }

    public void setOperationCommand(String actionCommand) {
        selectionDialog.setOperationCommand(actionCommand);
    }

    public String getOperationDialog() {
        return selectionDialog.getOperationDialog();
    }

    public void setUserSelectedPath(String userImageSource) {
        selectionDialog.setUserSelectedPath(userImageSource);
    }

    public void closeUsersDialog() {
        usersDialog.setVisible(false);
    }

    public void setBookSelectedPath(String bookImageSource) {
        selectionDialog.setBookSelectedPath(bookImageSource);
    }

    public int getIdToRent(List<Integer> books) {
        return getIdToRemove(books);
    }

    public void closeBooksDialog() {
        booksDialog.setVisible(false);
    }

    public String printSizeUserInfoDialog() {
        //call the method to get the size of user info dialog and return it with getters and setters
        return usersDialog.printSizeUserInfoDialog();
        //return usersDialog.userInfoDialog.printSize();
    }

    public void showFileChooser(int pathNumber) {
        booksDialog.showFileChooser(pathNumber);
    }

    public String getNewBookPathCover() {
        //get the object from the dialog and return it
        return booksDialog.getBookPathCover();
    }

    public void closeAddBookDialog() {
        booksDialog.closeAddBookDialog();
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public int getCopyId() {
        return copyId;
    }

    public void clearOperationPanel() {
        selectionDialog.clearOperationPanel();
    }

    public boolean operationDialogIsVisible() {
        return selectionDialog.operationDialogIsVisible();
    }

    public int getBookIndex() {
        return booksDialog.getBookIndex();
    }
}
