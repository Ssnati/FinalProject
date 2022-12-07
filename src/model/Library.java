package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    private List<Copy> copies;
    private List<User> users;

    private List<Rent> rents;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        copies = new ArrayList<>();
        rents = new ArrayList<>();
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

    public void addUser(String iconSrc, String name, String email, String address, String phone) {
        users.add(new User(iconSrc, name, email, address, phone));
    }

    public boolean removeUser(String name) {
        boolean removed = false;
        for (User user : users) {
            users.remove(user);
            removed = true;
            break;
        }
        return removed;
    }

    public void addBook(String coverSource, String tittle, String author, String year, String description, String ISBN) {
        books.add(new Book(coverSource, tittle, author, year, description, ISBN));
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
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().getTitle().equals(tittle) && copy.getId() == id) {
                copies.remove(copy);
            }
        }
    }

    public void addCopy(String tittle, int id) {
        copies.add(new Copy(searchBook(tittle), id));
    }

    public void rentBook(String userName, String tittle, int id) {
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

    public void returnBook(String userName, String tittle, int id) {
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
        return getNumberOfBooksAvailable() + getNumberOfBooksRented();
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
            addUser(userData[0], userData[1], userData[2], userData[3], userData[4]);
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


    public String getBookToView(String tittle) {
        String bookToView = "";
        for (Book book : books) {
            if (book.getTitle().equals(tittle)) {
                bookToView = book.toView() + ";" + getAvailableCopies(book) + ";" + getTotalCopies(book);
                break;
            }
        }
        return bookToView;
    }

    private int getAvailableCopies(Book book) {
        int availableCopies = 0;
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().equals(book)&&copy.isAvailable()) {
                availableCopies++;
            }
        }
        return (availableCopies);
    }

    public List<Integer> getAvailableListCopies(String bookName) {
        List<Integer> availableCopies = new ArrayList<>();
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().equals(searchBook(bookName))&&copy.isAvailable()) {
                availableCopies.add(copy.getId());
            }
        }
        return (availableCopies);
    }

    private int getTotalCopies(Book book) {
        int totalCopies = 0;
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().equals(book)) {
                totalCopies++;
            }
        }
        return totalCopies;
    }

    private int getRentedCopies(Book book) {
        int rentedCopies = 0;
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().equals(book)) {
                if (!copy.isAvailable()) {
                    rentedCopies++;
                }
            }
        }
        return rentedCopies;
    }

    public void loadBooks(ArrayList<String> books) {
        for (String book : books) {
            String[] bookData = book.split(";");
            addBook(bookData[0], bookData[1], bookData[2], bookData[3], bookData[4], bookData[5]);
        }
    }

    public boolean bookHasRentals(String bookName) {
        return getRentedCopies(searchBook(bookName)) != 0;
    }

    private Book searchBook(String bookName) {
        Book auxBook = null;
        for (Book book : books) {
            if (book.getTitle().equals(bookName)) {
                auxBook = book;
                break;
            }
        }
        return auxBook;
    }

    public void deleteBook(String bookName) {
        books.remove(searchBook(bookName));
    }

    public List<String> getBooksToView() {
        List<String> booksToView = new ArrayList<>();
        for (Book book : books) {
            booksToView.add(book.toView() + ";" + getAvailableCopies(book) + ";" + getTotalCopies(book));
        }
        return booksToView;
    }

    public List<String> getRentHistory(String bookName) {
        List<String> rentHistory = new ArrayList<>();
        for(Rent rent : rents){
            if(rent.getAssociatedCopy().getAssociatedBook().getTitle().equals(bookName)){
                rentHistory.add(rent.toView());
            }
        }
        return rentHistory;
    }

    public boolean copyExist(int id) {
        boolean exist = false;
        for(Copy copy : copies){
            if(copy.getId() == id){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public List<String> searchBooksToView(String chain) {
        List<String> booksToView = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(chain.toLowerCase())) {
                booksToView.add(book.toView() + ";" + getAvailableCopies(book) + ";" + getTotalCopies(book));
            }
        }
        return booksToView;
    }

    public void addAllCopies(String bookName, int copiesNumber) {
        Book book = searchBook(bookName);
        for (int i = 0; i < copiesNumber; i++) copies.add(new Copy(book, i + 1));
    }

    public String getUserImageSource(String userName) {
        return searchUser(userName).getIconSrc();
    }

    public String getBookImageSource(String bookName) {
        return searchBook(bookName).getCoverSource();
    }
}
