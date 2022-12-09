package presenter;

import model.Library;
import persistence.PrivateProperties;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements ActionListener, MouseListener, KeyListener, WindowListener {
    private PrivateProperties properties;
    private Library library;
    private View view;

    public Presenter() {
        try {
            properties = new PrivateProperties();
            library = new Library(properties);
            view = new View(this, this, this, this, properties);
        } catch (IOException e) {
            view.showMessage(properties.msg_Error() + e.getMessage());
        }
        view.loadUsers(library.getUsersToView());
        view.loadBooks(library.getBooksToView());
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_RentButton())) {
            view.selectionDialog();
        }
        if (e.getActionCommand().equals(properties.ac_UsersButton())) {
            view.showUsersDialog();
        }
        if (e.getActionCommand().equals(properties.ac_BooksButton())) {
            view.loadBooks(library.getBooksToView());
            view.showBooksDialog();
        }
        view.showPlusButton();
        view.loadUsers(library.getUsersToView());
        if (view.selectionDialogIsVisible()) selectionMenu(e);
        else if (view.usersDialogIsVisible()) usersMenu(e);
        else if (view.booksDialogIsVisible()) booksMenu(e);
    }

    private void selectionMenu(ActionEvent e) {
        view.hidePlusButtons();
        showSelectionMenu(e);
        if (view.operationPanelIsVisible()) operationMenu(e);

        if (e.getActionCommand().equals(properties.ac_rentBookButton())) {
            rentBook();
        } else if (e.getActionCommand().equals(properties.ac_returnBookButton())) {
            returnBook();
        }
    }

    private void returnBook() {
        if ((view.getUserIndex() < 0) || view.getCopyId() == 0) view.showMessage(properties.msg_selectUserAndBook());
        else {
            library.returnBook(view.getUserInfo(view.getUserIndex()), view.getBookName(properties.ac_BookButtons_() + view.getBookIndex()), view.getCopyId());

            view.clearOperationPanel();
            view.showMessage(properties.msg_BookReturned());
        }
    }

    private void rentBook() {
        if ((view.getUserIndex() < 0) || view.getCopyId() == 0) view.showMessage(properties.msg_selectUserAndBook());
        else {
            library.rentBook(view.getUserInfo(view.getUserIndex()), view.getBookName(properties.ac_BookButtons_() + view.getBookIndex()), view.getCopyId());
            view.clearOperationPanel();
            view.showMessage(properties.msg_BookRented());
        }
    }

    private void operationMenu(ActionEvent e) {
        selectData(e);

        if (e.getActionCommand().equals(properties.ac_pnl_addBook())) view.showAddBookDialog();
        if (e.getActionCommand().equals(properties.ac_addUser())) view.showAddUserDialog();
        if (view.usersDialogIsVisible()) selectUserToRent(e);
        else if (view.booksDialogIsVisible() && !e.getActionCommand().equals(properties.ac_pnl_addBook()))
            selectBookToRent(e);
    }

    private void selectBookToRent(ActionEvent e) {
        selectBook(e);
        List<Integer> copiesList = new ArrayList<>();
        if (view.getOperationInDialog().equals(properties.ac_returnButtonSelectionPanel())) {
            copiesList = library.getAvailableListCopies(view.getBookName(e.getActionCommand()));
        } else if (view.getOperationInDialog().equals(properties.ac_rentButtonSelectionPanel())) {
            copiesList = library.getUserRentedListCopies(view.getUserInfo(view.getUserIndex()), view.getBookName(e.getActionCommand()));
        }
        int i = view.getIdToRent(copiesList);
        if (i != -1) {
            if (i == -2) {
                view.showMessage(properties.msg_NoCopies());
            } else {
                view.setCopyId(i);
                view.closeBooksDialog();
            }
        }
    }

    private void selectBook(ActionEvent e) {
        for (int i = 0; i < view.getBooksListSize(); i++) {
            if (e.getActionCommand().equals(properties.ac_BookButtons_() + i)) {
                view.setBookIndex(i);
                view.setBookSelectedPath(library.getBookImageSource(view.getBookName(e.getActionCommand())));
                break;
            }
        }
    }

    private void selectUserToRent(ActionEvent e) {
        for (int i = 0; i < view.getUsersListSize(); i++) {
            if (e.getActionCommand().equals(properties.ac_UserButtons_() + i)) {
                view.setUserIndex(i);
                view.setUserSelectedPath(library.getUserImageSource((view.getUserInfo(i))));
                view.closeUsersDialog();
                break;
            }
        }
    }

    private void selectData(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_selectUserButtonToRent())) view.showUsersDialog();
        else if (e.getActionCommand().equals(properties.ac_selectBookButtonToRent())) {
            selectDataRent();
        }
    }

    private void selectDataRent() {
        if (view.getOperationInDialog().equals(properties.ac_rentButtonSelectionPanel())) {
            selectionDialogRent();
        } else {
            view.loadBooks(library.getBooksToView());
            view.showBooksDialog();
        }
    }

    private void selectionDialogRent() {
        int index = view.getUserIndex();
        if (index != -1) {
            List<String> books = library.getUserRentedBooksToView(view.getUserInfo(index));
            if (books.size() > 0) {
                view.loadBooks(books);
                view.showBooksDialog();
            } else {
                view.showMessage(properties.msg_NoBooks());
            }
        } else {
            view.showMessage(properties.msg_SelectUserFirst());
        }
    }

    private void showSelectionMenu(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_returnButtonSelectionPanel()) || e.getActionCommand().equals(properties.ac_rentButtonSelectionPanel())) {
            view.clearOperationPanel();
            view.setOperationCommand(e.getActionCommand());

            if (e.getActionCommand().equals(properties.ac_returnButtonSelectionPanel())) {
                view.showRentDialog();
                view.loadBooks(library.getBooksToView());
            } else if (e.getActionCommand().equals(properties.ac_rentButtonSelectionPanel())) view.showReturnDialog();
        }
    }

    private void booksMenu(ActionEvent e) {
        selectBookMenu(e);
        if (view.booksInfoDialogIsVisible()) bookInfoMenu(e);
        if (view.addBookDialogIsVisible()) addBookMenu(e);
    }

    private void addBookMenu(ActionEvent e) {
        if (view.addBookDialogIsVisible()) {
            if (e.getActionCommand().equals(properties.ac_AddCover())) {
                view.showFileChooser(library.getNewPath());
                view.setPahCoverToNewBook(view.getNewBookPathCover());
            }
            if (e.getActionCommand().equals(properties.ac_SaveBook())) {
                saveBook();
            }
        }
    }

    private void saveBook() {
        if (newBookIsValid(view.getNewBookInfo())) {
            String[] bookInfo = view.getNewBookInfo().split(properties.getSplitter());
            library.addBook(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5]);
            library.addAllCopies(bookInfo[1], Integer.parseInt(bookInfo[6]));
            view.loadNewBook(view.getNewBookInfo());
            view.showMessage(properties.msg_BookAddedCorrectly());
        } else {
            view.showMessage(properties.msg_DataIncorrectly());
        }
    }

    private void bookInfoMenu(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_deleteBook())) deleteBookMenu();
        if (e.getActionCommand().equals(properties.ac_historyBook()))
            view.showHistoryDialog(library.getRentHistory(view.getSelectedBook()));

        if (e.getActionCommand().equals(properties.ac_addCopyBook())) {
            addCopyBookMenu();
        }
        if (e.getActionCommand().equals(properties.ac_removeCopyBook())) {
            int i = view.getIdToRemove(library.getAvailableListCopies(view.getSelectedBook()));
            if (i != -1) {
                library.removeCopy(view.getSelectedBook(), i);
                view.showBookInfo(library.getBookToView(view.getSelectedBook()));
            }
        }
    }

    private void addCopyBookMenu() {
        int i = view.getNewId();
        if (i != 0) {
            if (i == -1) {
                view.showMessage(properties.msg_IdNotValid());
            } else if (library.copyExist(view.getSelectedBook(), i)) view.showMessage(properties.msg_IdAlreadyExist());
            else {
                library.addCopy(view.getSelectedBook(), i);
                view.showBookInfo(library.getBookToView(view.getSelectedBook()));
            }
        }
    }

    private void deleteBookMenu() {
        if (!library.bookHasRentals(view.getSelectedBook())) {
            library.deleteBook(view.getSelectedBook());
            view.loadBooks(library.getBooksToView());
            view.showMessage(properties.msg_BookDeletedCorrectly());
        } else view.showMessage(properties.msg_BookHasRentals());
    }

    private void selectBookMenu(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_pnl_addBook())) view.showAddBookDialog();
        else {
            for (int i = 0; i < view.getBooksListSize(); i++) {
                if (e.getActionCommand().equals(properties.ac_BookButtons_() + i)) {
                    view.setBookIndex(i);
                    view.showBookInfo(library.getBookToView(view.getBookName(properties.ac_BookButtons_() + i)));
                }
            }
        }
    }

    private void selectUserMenu(ActionEvent e) {
        for (int i = 0; i < view.getUsersListSize(); i++) {
            if (e.getActionCommand().equals(properties.ac_UserButtons_() + i)) {
                view.setUserIndex(i);
                view.showUserInfo(library.getUserToView(view.getUserInfo(i)));
            }
        }
    }

    private void usersMenu(ActionEvent e) {
        if (view.usersDialogIsVisible()) selectUserMenu(e);
        if (view.userInfoDialogIsVisible()) deleteUserMenu(e);

        if (e.getActionCommand().equals(properties.ac_addUser())) view.showAddUserDialog();

        if (view.addUserDialogIsVisible() && !e.getActionCommand().equals(properties.ac_userInfoPanelSaveUserButton()))
            view.setPahToUserIcon(e.getActionCommand());

        saveUserMenu(e);
    }

    private void saveUserMenu(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_userInfoPanelSaveUserButton())) {
            if (newUserIsValid(view.getNewUserInfo())) {
                String[] userInfo = view.getNewUserInfo().split(properties.getSplitter());
                library.addUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
                view.loadNewUser(view.getNewUserInfo() + properties.getSplitter() + "0");
                view.showMessage(properties.msg_UserAddedCorrectly());
            }
        }
    }

    private boolean newBookIsValid(String newBookInfo) {
        boolean isValid = false;
        try {
            String[] bookInfo = newBookInfo.split(properties.getSplitter());
            if (bookInfo.length == 7) {
                if (bookInfo[0].length() > 0 && bookInfo[1].length() > 0 && bookInfo[2].length() > 0 && bookInfo[3].length() > 0 && bookInfo[4].length() > 0 && bookInfo[5].length() > 0 && Integer.parseInt(bookInfo[6]) > 0) {
                    int i = Integer.parseInt(bookInfo[4]);
                    int j = Integer.parseInt(bookInfo[6]);
                    if (i > 0 && j > 0) {
                        isValid = true;
                    }
                }
            }
        } catch (Exception e) {
            view.showMessage(properties.msg_DataIncorrectly());
        }
        return isValid;
    }

    private void deleteUserMenu(ActionEvent e) {
        if (e.getActionCommand().equals(properties.ac_deleteUserButtonUserInfoPanel())) {
            if (library.userHasBooks(view.getUserInfo(view.getUserIndex()))) {
                view.showMessage(properties.msg_UserHasBooks());
            } else {
                library.deleteUser(view.getUserInfo(view.getUserIndex()));
                view.loadUsers(library.getUsersToView());
                view.showMessage(properties.msg_UserDeletedCorrectly());
            }
        }
    }


    private boolean newUserIsValid(String newUserInfo) {
        boolean isValid = false;
        try {
            String[] userInfo = newUserInfo.split(properties.getSplitter());
            if (isElectronicMailValid(userInfo[3])) throw new Exception();
            if ((userInfo[0].equals("") || userInfo[1].equals("") || userInfo[2].equals("") || userInfo[3].equals("") || userInfo[4].equals(""))) {
                throw new Exception();
            } else {
                int i = Integer.parseInt(userInfo[4]);
                isValid = i > 0 && isElectronicMailValid(userInfo[2]);
            }
        } catch (Exception e) {
            view.showMessage(properties.msg_DataIncorrectly());
        }
        return isValid;
    }

    private boolean isElectronicMailValid(String mail) {
        boolean isValid = false;
        if (mail.contains(properties.getMailAt())) {
            String[] mailSplit = mail.split(properties.getMailAt());
            if (mailSplit.length == 2) {
                if (mailSplit[0].length() > 0 && mailSplit[1].length() > 0) {
                    if (mailSplit[1].contains(".")) {
                        String[] domain = mailSplit[1].split("\\.");
                        if (domain.length >= 2) {
                            if (domain[0].length() > 0 && domain[1].length() > 0) {
                                isValid = true;
                            }
                        }
                    }
                }
            }
        }
        return isValid;
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            if (view.isOneOfMainPanelButtons(button)) view.mainPanelMouseOverButton(button);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            if (view.isOneOfMainPanelButtons(button)) view.mainPanelMouseExitedButton(button);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (view.usersDialogIsVisible()) {
            view.setTextInSearchFieldUsers();
        }
        if (view.booksDialogIsVisible()) {
            view.setTextInSearchFieldBooks();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (view.usersDialogIsVisible()) {
            view.setTextInSearchFieldUsers();
            view.loadUsers(library.searchUsersToView(view.getSearchFieldTextUsers()));
        }
        if (view.booksDialogIsVisible()) {
            view.setTextInSearchFieldBooks();
            view.loadBooks(library.searchBooksToView(view.getSearchFieldTextBooks()));
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() instanceof JFrame) {
            try {
                library.saveData();
            } catch (IOException ex) {
                view.showMessage(properties.msg_ErrorSavingData());
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
