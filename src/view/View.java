package view;

import persistence.PrivateProperties;
import presenter.Presenter;
import view.books.BooksDialog;
import view.rent.SelectionDialog;
import view.user.UsersDialog;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

public class View extends JFrame {
    private final PrivateProperties properties;
    private MainPanel mainPanel;
    private BooksDialog booksDialog;
    private UsersDialog usersDialog;
    private SelectionDialog selectionDialog;
    private int copyId;

    public View(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener, WindowListener windowListener, PrivateProperties privateProperties) throws IOException {
        this.properties = privateProperties;
        addWindowListener(windowListener);
        setTitle(properties.getApplicationName());
        setSize(1220, 600);
        initContent(actionListener, mouseListener, keyListener);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initContent(ActionListener actionListener, MouseListener mouseListener, KeyListener keyListener) throws IOException {
        mainPanel = new MainPanel(actionListener, mouseListener, properties);
        getContentPane().add(mainPanel);

        usersDialog = new UsersDialog(this, true, actionListener, mouseListener, keyListener, properties);
        usersDialog.setVisible(false);

        booksDialog = new BooksDialog(this, true, actionListener, mouseListener, keyListener, properties);
        booksDialog.setVisible(false);

        selectionDialog = new SelectionDialog(this, true, actionListener, mouseListener, keyListener, properties);
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
        usersDialog.updateUsersPanel();
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
        booksDialog.getBooksPanel().setTextInSearchFieldBooks();
    }

    public String getSearchFieldTextBooks() {
        return booksDialog.getBooksPanel().getSearchFieldTextBooks();
    }

    public int getBooksListSize() {
        return booksDialog.getBooksPanel().getBooksListSize();
    }

    public void setBookIndex(int bookIndex) {
        booksDialog.getBooksPanel().setBookIndex(bookIndex);
    }

    public void showBookInfo(String bookToView) {
        booksDialog.getBookInfoDialog().showBookInfo(bookToView);
        booksDialog.getBookInfoDialog().setVisible(true);
    }

    public String getBookName(String actionCommand) {
        return booksDialog.getBooksPanel().getBookName(actionCommand);
    }

    public boolean booksInfoDialogIsVisible() {
        return booksDialog.getBookInfoDialog().isVisible();
    }

    public String getSelectedBook() {
        return booksDialog.getBooksPanel().getSelectedBook();
    }

    public void showHistoryDialog(List<String> rentHistory) {
        booksDialog.getBookInfoDialog().showHistoryDialog(rentHistory);
    }

    public int getIdToRemove(List<Integer> list) throws NumberFormatException, IndexOutOfBoundsException {
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
        booksDialog.getAddBookDialog().setVisible(true);
    }

    public boolean addBookDialogIsVisible() {
        return booksDialog.getAddBookDialog().isVisible();
    }

    public void setPahCoverToNewBook(String bookName) {
        booksDialog.getAddBookDialog().setPahCoverToNewBook(bookName);
    }

    public String getNewBookInfo() {
        return booksDialog.getAddBookDialog().getNewBookInfo();
    }

    public void loadNewBook(String newBookInfo) {
        booksDialog.getBooksPanel().loadNewBook(newBookInfo);
        closeAddBookDialog();
    }

    public void showRentDialog() {
        selectionDialog.showRentDialog();
    }

    public void showReturnDialog() {
        selectionDialog.showReturnDialog();
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
        return usersDialog.printSizeUserInfoDialog();
        //return usersDialog.userInfoDialog.printSize();
    }

    public void showFileChooser(int pathNumber) {
        booksDialog.getAddBookDialog().getAddBookPanel().showFileChooser(pathNumber);
        booksDialog.getAddBookDialog().getAddBookPanel().updateUI();
    }

    public String getNewBookPathCover() {
        return booksDialog.getAddBookDialog().getAddBookPanel().getPathCover();
    }

    public void closeAddBookDialog() {
        booksDialog.getAddBookDialog().setVisible(false);
        booksDialog.getAddBookDialog().getAddBookPanel().cleanFields();
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


    public int getBookIndex() {
        return booksDialog.getBooksPanel().getBookIndex();
    }

    public void hidePlusButtons() {
        booksDialog.getBooksPanel().hidePlusButtons();
        usersDialog.getUsersPanel().hidePlusButtons();
    }

    public void showPlusButton() {
        booksDialog.getBooksPanel().showPlusButton();
        usersDialog.getUsersPanel().showPlusButton();
        booksDialog.getBooksPanel().updateUI();
        usersDialog.getUsersPanel().updateUI();
    }
}
