package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
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

    public void addUser(String name, String email, String address, String phone) {
        users.add(new User(name, email, address, phone));
    }

    public boolean removeUser(String name){
        boolean removed = false;
        for (User user : users) {
            if (user.getName().equals(name)&&!user.haveRentedBooks()) {
                users.remove(user);
                removed = true;
                break;
            }
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
                book.removeCopy(book.getCopy(id));
                break;
            }
        }
    }
    public void addCopy(String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                book.addCopy(new Copy(id, true));
                break;
            }
        }
    }

    public void rentBook(String userName,String tittle, int id) {
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                searchUser(userName).addRentedBook(book, book.getCopy(id));
                book.getCopy(id).setAvailable(false);
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
                searchUser(userName).removeRentedBook(book, book.getCopy(id));
                book.getCopy(id).setAvailable(true);
                break;
            }
        }
    }



}
