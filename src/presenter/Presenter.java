package presenter;

import model.Library;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Presenter implements ActionListener, MouseListener, KeyListener {
    private Library library;
    private View view;

    public Presenter() {
        library = new Library();
        view = new View(this, this, this);
        ArrayList<String> users = new ArrayList<>();
        users.add("sources/userIcons/Male Icon 1.png;Santiago1;santiago1@gmail.com;Cra 9 #3-01;3212004072;0");
        users.add("sources/userIcons/Male Icon 2.png;Daniel2;santiago2@gmail.com;Cra 9 #3-01;3212004072;2");
        users.add("sources/userIcons/Male Icon 3.png;Camilo3;santiago3@gmail.com;Cra 9 #3-01;3212004072;3");
        users.add("sources/userIcons/Male Icon 4.png;Julian4;santiago4@gmail.com;Cra 9 #3-01;3212004072;4");
        users.add("sources/userIcons/Male Icon 5.png;Esteban5;santiago5@gmail.com;Cra 9 #3-01;3212004072;5");
        users.add("sources/userIcons/Male Icon 6.png;Sebastian6;santiago6@gmail.com;Cra 9 #3-01;3212004072;6");
        view.loadUsers(users);
        library.loadUsers(users);
        ArrayList<String> books = new ArrayList<>();
        books.add("sources/covers/Cover1.png;The Lord of the Rings;J.R.R. Tolkien;2001;The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold.;978-84-376-0494-7");
        books.add("sources/covers/Cover1.png;Harry Potter and the Philosopher's Stone;J.K. Rowling;2001;Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, he faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old.;978-84-376-0494-7");
        books.add("sources/covers/Cover1.png;Harry Potter and the Chamber of Secrets;J.K. Rowling;2001;Harry Potter and the Chamber of Secrets is a fantasy novel written by British author J. K. Rowling and the second novel in the Harry Potter series. The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's corridors warn that the \"Chamber of Secrets\" has been opened and that the \"heir of Slytherin\" would kill all pupils who do not come from all-magical families. These threats are found after attacks which leave residents of the school petrified. Throughout the year, Harry and his friends Ron and Hermione investigate the attacks.;978-84-376-0494-7");
        books.add("sources/covers/Cover1.png;Harry Potter and the Prisoner of Azkaban;J.K. Rowling;2001;Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry. Along with friends Ronald Weasley and Hermione Granger, Harry investigates Sirius Black, an escaped prisoner from Azkaban who they believe is one of Lord Voldemort's old allies.;978-84-376-0494-7");
        view.loadBooks(books);
        library.loadBooks(books);
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RENT")) {
            view.selectionDialog();
        }
        if (e.getActionCommand().equals("USERS")) {
            view.showUsersDialog();

        }
        if (e.getActionCommand().equals("BOOKS")) {
            view.showBooksDialog();
        }
        if (view.selectionDialogIsVisible()) selectionMenu(e);
        else if (view.usersDialogIsVisible()) usersMenu(e);
        else if (view.booksDialogIsVisible()) booksMenu(e);
    }

    private void selectionMenu(ActionEvent e) {
        showSelectionMenu(e);
        if (view.operationPanelIsVisible()&& view.getOperationDialog().equals("RENT_DIALOG")) rentMenu(e);
        else if (view.operationPanelIsVisible()&& view.getOperationDialog().equals("RETURN_DIALOG")) returnMenu(e);
    }

    private void rentPrincipalMenu(ActionEvent e) {

    }

    private void returnMenu(ActionEvent e) {
        view.showOperationUsersDialog();
        System.out.println(e.getActionCommand() + " Esta en el rentMenu");
        if(e.getActionCommand().equals("SELECT_USER_TO_RETURN")) view.showUsersDialog();
        else if (e.getActionCommand().equals("SELECT_BOOK_TO_RENT")) view.showBooksDialog();
        else if (e.getActionCommand().equals("RENT")) view.showOperationUsersDialog();
        if (view.usersDialogIsVisible()) {
            for (int i = 0; i < view.getUsersListSize(); i++) {
                if (e.getActionCommand().equals("USER_" + i)) {
                    view.setUserSelectedPath(library.getUserImageSource((view.getUserInfo(i))));
                    view.closeUsersDialog();
                    System.out.println("USER_" + i);
                    break;
                }
            }
        }
        else if (view.booksDialogIsVisible()&&!e.getActionCommand().equals("ADD_BOOK")) {
            view.setBookSelectedPath(library.getBookImageSource(view.getBookName(e.getActionCommand())));
//            view.getIdToRent(library.getAvailableListCopies(view.getBookName(e.getActionCommand())));
            int[] availableCopies = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayList<Integer> copiesList = new ArrayList<>();
            Arrays.stream(availableCopies).forEach(copiesList::add);
            view.getIdToRent(copiesList);
            view.closeBooksDialog();
        }
    }

    private void rentMenu(ActionEvent e) {
        System.out.println(e.getActionCommand() + " Esta en el rentMenu");
        if(e.getActionCommand().equals("SELECT_USER_TO_RENT")) view.showUsersDialog();
        else if (e.getActionCommand().equals("SELECT_BOOK_TO_RENT")) view.showBooksDialog();
        else if (e.getActionCommand().equals("RENT")) view.showOperationUsersDialog();
        if (view.usersDialogIsVisible()) {
            for (int i = 0; i < view.getUsersListSize(); i++) {
                if (e.getActionCommand().equals("USER_" + i)) {
                    view.setUserSelectedPath(library.getUserImageSource((view.getUserInfo(i))));
                    view.closeUsersDialog();
                    System.out.println("USER_" + i);
                    break;
                }
            }
        }
        else if (view.booksDialogIsVisible()&&!e.getActionCommand().equals("ADD_BOOK")) {
            view.setBookSelectedPath(library.getBookImageSource(view.getBookName(e.getActionCommand())));
//            view.getIdToRent(library.getAvailableListCopies(view.getBookName(e.getActionCommand())));
            int[] availableCopies = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayList<Integer> copiesList = new ArrayList<>();
            Arrays.stream(availableCopies).forEach(copiesList::add);
            view.getIdToRent(copiesList);
            view.closeBooksDialog();
        }
    }

    private void showSelectionMenu(ActionEvent e) {
        if (e.getActionCommand().equals("RENT_DIALOG")) {
            view.setOperationCommand("RENT_DIALOG");
            view.showRentDialog();
        } else if (e.getActionCommand().equals("RETURN_DIALOG")) {
            view.setOperationCommand("RETURN_DIALOG");
            view.showReturnDialog();
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
                System.out.println(view.getNewUserInfo());
                view.setPahCoverToNewBook(view.getSelectedBook());
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
                System.out.println("SAVE_BOOK");
            }
        }
    }

    private void bookInfoMenu(ActionEvent e) {
        if (e.getActionCommand().equals("DELETE_BOOK")) deleteBookMenu();
        if (e.getActionCommand().equals("HISTORY_BOOK")) {
//            view.showHistoryDialog(library.getRentHistory(view.getSelectedBook()));
            String[] history = {"Santiago;1;12/12/2019;12/12/2019", "Daniel;2;12/12/2019;12/12/2019", "Camilo;3;12/12/2019;12/12/2019", "Julian;4;12/12/2019;12/12/2019", "Esteban;5;12/12/2019;12/12/2019", "Sebastian;6;12/12/2019;12/12/2019"};
            view.showHistoryDialog(Arrays.asList(history));
        }

        if (e.getActionCommand().equals("ADD_COPY")) {
            int i = view.getNewId();
            if (i != 0) {
                if (i == -1) {
                    view.showMessage("El id no es valido");
                } else if (library.copyExist(i)) view.showMessage("The copy already exist");
                else {
                    library.addCopy(view.getSelectedBook(), i);
                    view.showBookInfo(library.getBookToView(view.getSelectedBook()));
                }
            }
        }
        if (e.getActionCommand().equals("REMOVE_COPY")) {
            int[] copies = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            ArrayList<Integer> copiesList = new ArrayList<>();
            Arrays.stream(copies).forEach(copiesList::add);
            int i = view.getIdToRemove(copiesList);
            if (i != -1) {
                library.removeCopy(view.getSelectedBook(), i);
                view.showBookInfo(library.getBookToView(view.getSelectedBook()));
//            view.showBookInfo("sources/covers/Cover1.png;The Lord of the Rings;J.R.R. Tolkien;2001;The Lord of the Rings is an epic high fantasy novel written by English author and scholar J. R. R. Tolkien. The story began as a sequel to Tolkien's 1937 fantasy novel The Hobbit, but eventually developed into a much larger work. Written in stages between 1937 and 1949, The Lord of the Rings is one of the best-selling novels ever written, with over 150 million copies sold.;978-84-376-0494-7;1;9");
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
        //Para saber que usuario se selecciono
        if (view.usersDialogIsVisible()) selectUserMenu(e);

        //Informacion del usuario seleccionado
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
            String[] bookInfo = newBookInfo.split(";");
            isValid = !bookInfo[0].equals("") || bookInfo[1].equals("") || bookInfo[2].equals("") || bookInfo[3].equals("") || bookInfo[4].equals("") || bookInfo[5].equals("") || bookInfo[6].equals("");
        } catch (ArrayIndexOutOfBoundsException e) {
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
            String[] userInfo = newUserInfo.split(";");
            isValid = !(userInfo[0].equals("") || userInfo[1].equals("") || userInfo[2].equals("") || userInfo[3].equals("") || userInfo[4].equals(""));
        } catch (Exception e) {
            view.showMessage("La informacion del usuario no es valida");
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
        System.out.println("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        if ((key == 18) || (key == 115)) {
        } else {
            if (view.usersDialogIsVisible()) {
                view.setTextInSearchFieldUsers();
                System.out.println("Usuarios Entrada: " + view.getSearchFieldTextUsers());
            }
            if (view.booksDialogIsVisible()) {
                view.setTextInSearchFieldBooks();
                System.out.println("Libros Entrada: " + view.getSearchFieldTextBooks());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if ((key == 18) || (key == 115)) {
        } else {
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
    }
}
