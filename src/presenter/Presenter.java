package presenter;

import model.Library;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
        view.loadBooks(new ArrayList<>());
    }

    public static void main(String[] args) {
        new Presenter();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RENT")) {
            view.showRentDialog();
        }
        if (e.getActionCommand().equals("USERS")) {
            view.showUsersDialog();

        }
        if (e.getActionCommand().equals("BOOKS")) {
            view.showBooksDialog();
        }
        if (view.usersDialogIsVisible()) usersMenu(e);
        else if (view.booksDialogIsVisible()) booksMenu(e);
        else if (view.selectionDialogIsVisible()) selectionMenu(e);
    }

    private void selectionMenu(ActionEvent e) {

    }

    private void booksMenu(ActionEvent e) {

    }

    private void usersMenu(ActionEvent e) {
        //Para saber que usuario se selecciono
        if (view.usersDialogIsVisible()) selectUserMenu(e);

        //Informacion del usuario seleccionado
        if (view.userInfoDialogIsVisible()) deleteUserMenu(e, view.getUserIndex());

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

    private void selectUserMenu(ActionEvent e) {
        for (int i = 0; i < view.getUsersListSize(); i++) {
            if (e.getActionCommand().equals("USER_" + i)) {
                view.setUserIndex(i);
                view.showUserInfo(library.getUserToView(view.getUserInfo(i)));
//                System.out.println("Nombre del usuario: " + view.getUserInfo(i));
//                view.showUserInfo("sources/userIcons/Male Icon 1.png;Santiago;santiago@gmail.com;Cra 9 #3-01;3212004072;1");
                System.out.println("USER_" + i);
            }
        }
    }

    private void deleteUserMenu(ActionEvent e, int userIndex) {
        if (e.getActionCommand().equals("DELETE_USER")) {
            if (library.userHasBooks(view.getUserInfo(userIndex))) {
                view.showMessage("El usuario no puede ser eliminado porque tiene libros prestados");
            } else {
                library.deleteUser(view.getUserInfo(userIndex));
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
                System.out.println("Libros Salida: " + view.getSearchFieldTextBooks());
            }
        }
    }
}
