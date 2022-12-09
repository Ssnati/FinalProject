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
            view.showMessage("Error " + e.getMessage());
        }
        view.loadUsers(library.getUsersToView());
        view.loadBooks(library.getBooksToView());
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionPerformed: " + e.getActionCommand());
        if (e.getActionCommand().equals("RENT")) {
            view.selectionDialog();
        }
        if (e.getActionCommand().equals("USERS")) {
            view.showUsersDialog();
        }
        if (e.getActionCommand().equals("BOOKS")) {
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

        System.out.println("User: " + view.getUserIndex() + " Copy: " + view.getCopyId() + " Book: " + view.getBookIndex());
        if (e.getActionCommand().equals("RENT_BOOK")) {
            System.out.println("Action: " + view.getOperationInDialog());
            if ((view.getUserIndex() < 0) || view.getCopyId() == 0) view.showMessage("Select a user and a book");
            else {
                library.rentBook(view.getUserInfo(view.getUserIndex()), view.getBookName("BOOK_" + view.getBookIndex()), view.getCopyId());
                view.clearOperationPanel();
                view.showMessage("Book rented");
            }
        } else if (e.getActionCommand().equals("RETURN_BOOK")) {
            System.out.println("Action: " + view.getOperationInDialog());
            if ((view.getUserIndex() < 0) || view.getCopyId() == 0) view.showMessage("Select a user and a book");
            else {
                library.returnBook(view.getUserInfo(view.getUserIndex()), view.getBookName("BOOK_" + view.getBookIndex()), view.getCopyId());

                view.clearOperationPanel();
                view.showMessage("Book returned");
            }
        }
    }

    private void operationMenu(ActionEvent e) {
        selectData(e);

        if (e.getActionCommand().equals("ADD_BOOK")) view.showAddBookDialog();
        if (e.getActionCommand().equals("ADD_USER")) {
            view.showAddUserDialog();
            System.out.println("ADD_USER");
        }
        if (view.usersDialogIsVisible()) selectUserToRent(e);
        else if (view.booksDialogIsVisible() && !e.getActionCommand().equals("ADD_BOOK")) selectBookToRent(e);
    }

    private void selectBookToRent(ActionEvent e) {
        selectBook(e);
        List<Integer> copiesList = new ArrayList<>();
        if (view.getOperationInDialog().equals("RENT_DIALOG")) {
            copiesList = library.getAvailableListCopies(view.getBookName(e.getActionCommand()));
        } else if (view.getOperationInDialog().equals("RETURN_DIALOG")) {
            copiesList = library.getUserRentedListCopies(view.getUserInfo(view.getUserIndex()), view.getBookName(e.getActionCommand()));
            System.out.println("Parametros lanzados al buscar User: " + view.getUserInfo(view.getUserIndex()) + " Copy: " + view.getCopyId() + " Book: " + view.getBookIndex());
        }
        int i = view.getIdToRent(copiesList);
        if (i != -1) {
            if (i == -2) {
                view.showMessage("No hay copias disponibles");
            } else {
                view.setCopyId(i);
                view.closeBooksDialog();
            }
        }
    }

    private void selectBook(ActionEvent e) {
        for (int i = 0; i < view.getBooksListSize(); i++) {
            if (e.getActionCommand().equals("BOOK_" + i)) {
                view.setBookIndex(i);
                view.setBookSelectedPath(library.getBookImageSource(view.getBookName(e.getActionCommand())));
                break;
            }
        }
    }

    private void selectUserToRent(ActionEvent e) {
        for (int i = 0; i < view.getUsersListSize(); i++) {
            if (e.getActionCommand().equals("USER_" + i)) {
                view.setUserIndex(i);
                System.out.println("UserIndex: " + view.getUserIndex());
                view.setUserSelectedPath(library.getUserImageSource((view.getUserInfo(i))));
                view.closeUsersDialog();
                System.out.println("USER_" + i);
                break;
            }
        }
    }

    private void selectData(ActionEvent e) {
        System.out.println(e.getActionCommand() + " Esta en el operation Menu: " + view.getOperationInDialog());
        if (e.getActionCommand().equals("SELECT_USER_TO_RENT")) view.showUsersDialog();
        else if (e.getActionCommand().equals("SELECT_BOOK_TO_RENT")) {
            if (view.getOperationInDialog().equals("RETURN_DIALOG")) {
                int index = view.getUserIndex();
                if (index != -1) {
                    List<String> books = library.getUserRentedBooksToView(view.getUserInfo(index));

                    System.out.println("Libros del usuario: " + books);
                    System.out.println("Usuario seleccionado: " + view.getUserInfo(index));

                    if (books.size() > 0) {
                        view.loadBooks(books);
                        view.showBooksDialog();
                    } else {
                        view.showMessage("El usuario no tiene libros alquilados");
                    }
                } else {
                    view.showMessage("Select a user first");
                }
            } else {
                view.loadBooks(library.getBooksToView());
                view.showBooksDialog();
            }
        }
    }

    private void showSelectionMenu(ActionEvent e) {
        if (e.getActionCommand().equals("RENT_DIALOG") || e.getActionCommand().equals("RETURN_DIALOG")) {
            view.clearOperationPanel();
            view.setOperationCommand(e.getActionCommand());

            if (e.getActionCommand().equals("RENT_DIALOG")) {
                view.showRentDialog();
                view.loadBooks(library.getBooksToView());
            } else if (e.getActionCommand().equals("RETURN_DIALOG")) view.showReturnDialog();
        }
    }

    private void booksMenu(ActionEvent e) {
        selectBookMenu(e);
        if (view.booksInfoDialogIsVisible()) bookInfoMenu(e);
        if (view.addBookDialogIsVisible()) addBookMenu(e);
    }

    private void addBookMenu(ActionEvent e) {
        if (view.addBookDialogIsVisible()) {
            if (e.getActionCommand().equals("ADD_COVER")) {
                view.showFileChooser(library.getNewPath());
                System.out.println(view.getNewBookInfo());
                view.setPahCoverToNewBook(view.getNewBookPathCover());
            }
            if (e.getActionCommand().equals("SAVE_BOOK")) {
                if (newBookIsValid(view.getNewBookInfo())) {
                    String[] bookInfo = view.getNewBookInfo().split(";");
                    library.addBook(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5]);
                    library.addAllCopies(bookInfo[1], Integer.parseInt(bookInfo[6]));
                    view.loadNewBook(view.getNewBookInfo());
                    System.out.println(view.getNewBookInfo());
                    view.showMessage("El libro se ha agregado correctamente");
                }
                view.showMessage("Introduce todos los datos");
                System.out.println("SAVE_BOOK");
            }
        }
    }

    private void bookInfoMenu(ActionEvent e) {
        if (e.getActionCommand().equals("DELETE_BOOK")) deleteBookMenu();
        if (e.getActionCommand().equals("HISTORY_BOOK")) {
            view.showHistoryDialog(library.getRentHistory(view.getSelectedBook()));
        }

        if (e.getActionCommand().equals("ADD_COPY")) {
            int i = view.getNewId();
            if (i != 0) {
                if (i == -1) {
                    view.showMessage("El id no es valido");
                } else if (library.copyExist(view.getSelectedBook(), i)) view.showMessage("The copy already exist");
                else {
                    library.addCopy(view.getSelectedBook(), i);
                    view.showBookInfo(library.getBookToView(view.getSelectedBook()));
                }
            }
        }
        if (e.getActionCommand().equals("REMOVE_COPY")) {
            int i = view.getIdToRemove(library.getAvailableListCopies(view.getSelectedBook()));
            if (i != -1) {
                library.removeCopy(view.getSelectedBook(), i);
                view.showBookInfo(library.getBookToView(view.getSelectedBook()));
            }
        }
    }

    private void deleteBookMenu() {
        if (!library.bookHasRentals(view.getSelectedBook())) {
            library.deleteBook(view.getSelectedBook());
            view.loadBooks(library.getBooksToView());
            view.showMessage("Book deleted successfully");
        } else view.showMessage("The book can't be deleted because it has rentals");
    }

    private void selectBookMenu(ActionEvent e) {
        if (e.getActionCommand().equals("ADD_BOOK")) view.showAddBookDialog();
        else {
            for (int i = 0; i < view.getBooksListSize(); i++) {
                if (e.getActionCommand().equals("BOOK_" + i)) {
                    view.setBookIndex(i);
                    System.out.println("Action comand: BOOK_" + i);
                    view.showBookInfo(library.getBookToView(view.getBookName("BOOK_" + i)));
                }
            }
        }
    }

    private void selectUserMenu(ActionEvent e) {
        for (int i = 0; i < view.getUsersListSize(); i++) {
            if (e.getActionCommand().equals("USER_" + i)) {
                view.setUserIndex(i);
                view.showUserInfo(library.getUserToView(view.getUserInfo(i)));
                System.out.println("USER_" + i);
            }
        }
    }

    private void usersMenu(ActionEvent e) {
        if (view.usersDialogIsVisible()) selectUserMenu(e);
        if (view.userInfoDialogIsVisible()) deleteUserMenu(e);

        if (e.getActionCommand().equals("ADD_USER")) {
            view.showAddUserDialog();
            System.out.println("ADD_USER");
        }

        if (view.addUserDialogIsVisible() && !e.getActionCommand().equals("SAVE_USER")) {
            view.setPahToUserIcon(e.getActionCommand());
            System.out.println(view.getNewUserInfo());
        }

        if (e.getActionCommand().equals("SAVE_USER")) {
            if (newUserIsValid(view.getNewUserInfo())) {
                String[] userInfo = view.getNewUserInfo().split(";");
                library.addUser(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
                view.loadNewUser(view.getNewUserInfo() + ";0");
                view.showMessage("El usuario ha sido agregado");
            }
            System.out.println("SAVE_USER");
        }
    }

    private boolean newBookIsValid(String newBookInfo) {
        boolean isValid = false;
        try {
            System.out.println(newBookInfo);
            String[] bookInfo = newBookInfo.split(";");
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
            view.showMessage("The book info is not valid");
        }
        return isValid;
    }

    private void deleteUserMenu(ActionEvent e) {
        if (e.getActionCommand().equals("DELETE_USER")) {
            if (library.userHasBooks(view.getUserInfo(view.getUserIndex()))) {
                view.showMessage("El usuario no puede ser eliminado porque tiene libros prestados");
            } else {
                library.deleteUser(view.getUserInfo(view.getUserIndex()));
                view.loadUsers(library.getUsersToView());
                view.showMessage("El usuario ha sido eliminado");
            }
        }
    }


    private boolean newUserIsValid(String newUserInfo) {
        boolean isValid = false;
        try {
            System.out.println(newUserInfo);
            String[] userInfo = newUserInfo.split(";");
            if (isElectronicMailValid(userInfo[3])) throw new Exception();
            if ((userInfo[0].equals("") || userInfo[1].equals("") || userInfo[2].equals("") || userInfo[3].equals("") || userInfo[4].equals(""))) {
                throw new Exception();
            } else {
                int i = Integer.parseInt(userInfo[4]);
                isValid = i > 0 && isElectronicMailValid(userInfo[2]);
            }
        } catch (Exception e) {
            view.showMessage("La informacion del usuario no es valida");
        }
        return isValid;
    }

    private boolean isElectronicMailValid(String mail) {
        boolean isValid = false;
        if (mail.contains("@")) {
            String[] mailSplit = mail.split("@");
            if (mailSplit.length == 2) {
                if (mailSplit[0].length() > 0 && mailSplit[1].length() > 0) {
                    if (mailSplit[1].contains(".")) {
                        String[] domain = mailSplit[1].split("\\.");
                        if (domain.length == 2) {
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
            System.out.println("Usuarios Entrada: " + view.getSearchFieldTextUsers());
        }
        if (view.booksDialogIsVisible()) {
            view.setTextInSearchFieldBooks();
            System.out.println("Libros Entrada: " + view.getSearchFieldTextBooks());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (view.usersDialogIsVisible()) {
            view.setTextInSearchFieldUsers();
            view.loadUsers(library.searchUsersToView(view.getSearchFieldTextUsers()));
            System.out.println("Usuarios Salida: " + view.getSearchFieldTextUsers());
        }
        if (view.booksDialogIsVisible()) {
            view.setTextInSearchFieldBooks();
            view.loadBooks(library.searchBooksToView(view.getSearchFieldTextBooks()));
            System.out.println("Libros Salida: " + view.getSearchFieldTextBooks());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource() instanceof JFrame) {
            try {
                library.saveData();
            } catch (IOException ex) {
                view.showMessage("Error al guardar los datos");
            }
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
