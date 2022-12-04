package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    private List<Copy> copies;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(String iconSrc,String name, String email, String address, String phone) {
        users.add(new User(iconSrc,name, email, address, phone));
    }

    public boolean removeUser(String name){
        boolean removed = false;
        for (User user : users) {
                users.remove(user);
                removed = true;
                break;
            }
        return removed;
    }

    public void addBook(String tittle, String author, String year, String description, String coverSource) {
        books.add(new Book(tittle, author, year, description, coverSource));
    }

    public void removeBook(String tittle) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                books.remove(book);
                break;
            }
        }
    }
    public void removeCopy(String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                break;
            }
        }
    }
    public void addCopy(String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {

                break;
            }
        }
    }

    public void rentBook(String userName,String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {

                break;
            }
        }
    }

    private User searchUser(String userName) {
        User auxUser = null;
        for (User user : users) {
            if (user.getName().equals(userName)) {
                auxUser = user;
                break;
            }
        }
        return auxUser;
    }

    public void returnBook(String userName,String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                break;
            }
        }
    }

    public int getNumberOfBooksAvailable() {
        int numberOfBooksAvailable = 0;
        for (Book book : books) {
                numberOfBooksAvailable++;
            }
        return numberOfBooksAvailable;
    }

    public int getNumberOfBooksRented() {
        int numberOfBooksRented = 0;
        for (Book book : books) {
                numberOfBooksRented++;
            }
        return numberOfBooksRented;
    }

    public int getNumberOfBooks() {
        return books.size();
    }

    public int getTotalNumberOfCopies() {
        return getNumberOfBooksAvailable()+getNumberOfBooksRented();
    }

    public int getNumberOfUsers() {
        return users.size();
    }

    public int getNumberOfUsersWithRentedBooks() {
        int numberOfUsersWithRentedBooks = 0;
        for (User user : users) {
        }
        return numberOfUsersWithRentedBooks;
    }

    public String getUserToView(String userName) {
        return searchUser(userName).toView();
    }

    public List<String> searchBooks(String searchFieldText) {
        return null;
    }

    public boolean userHasBooks(String userName) {
        return searchUser(userName).hasBooks();
    }

    public void deleteUser(String userName) {
        users.remove(searchUser(userName));
    }

    public void loadUsers(ArrayList<String> users) {
        for (String user : users) {
            String[] userData = user.split(";");
            addUser(userData[0],userData[1],userData[2],userData[3],userData[4]);
        }
    }
    public List<String> searchUsersToView(String chain) {
        List<String> usersToView = new ArrayList<>();
        for (User user : users) {
            if (user.getName().toLowerCase().contains(chain.toLowerCase())) {
                usersToView.add(user.toView());
            }
        }
        return usersToView;
    }

    public List<String> getUsersToView() {
        List<String> usersToView = new ArrayList<>();
        for (User user : users) {
            usersToView.add(user.toView());
        }
        return usersToView;
    }
}
