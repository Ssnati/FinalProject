package model;

import persistence.Persistence;
import persistence.PrivateProperties;

import java.io.IOException;
import java.util.*;

public class Library {
    private final PrivateProperties properties;
    private List<Book> books;

    private List<Copy> copies;
    private List<User> users;

    private List<Rent> rents;

    public Library(PrivateProperties properties) throws IOException {
        this.properties = properties;
        books = new Persistence(properties).getBooks();
        copies = new Persistence(properties).getCopies();
        setBooksToCopies();
        users = new Persistence(properties).getUsers();
        setCopiesListToUsers();
        rents = new Persistence(properties).getRents();
        setCopiesToRents();
        setUsersToRents();
    }

    private void setUsersToRents() {
        for (Rent rent : rents) {
            for (User user : users) {
                if (rent.getAssociatedUser().getName().equals(user.getName())) {
                    rent.setAssociatedUser(user);
                }
            }
        }
    }

    private void setCopiesToRents() {
        for (Rent rent : rents) {
            for (Copy copy : copies) {
                if (rent.getAssociatedCopy().getAssociatedBook().getTitle().equals(copy.getAssociatedBook().getTitle())&&rent.getAssociatedCopy().getId()==copy.getId()&&rent.getAssociatedCopy().isAvailable()==copy.isAvailable()) {
                    rent.setAssociatedCopy(copy);
                }
            }
        }
    }

    private void setCopiesListToUsers() {
        for (User user : users) {
            List<Copy> copies = new ArrayList<>();
            for (Copy userCopy : user.getRentedCopies()) {
                if (!userCopy.isAvailable())
                    copies.add(searchCopy(userCopy.getAssociatedBook().getTitle(),userCopy.getId()));
            }
            user.setRentedCopies(copies);
        }
    }

    private void setBooksToCopies() {
        for (Copy copy : copies) {
            for (Book book : books) {
                if (copy.getAssociatedBook().getTitle().equals(book.getTitle())) {
                    copy.setAssociatedBook(book);
                }
            }
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addUser(String iconSrc, String name, String email, String address, String phone) {
        users.add(new User(iconSrc, name, email, address, phone));
    }

    public void addBook(String coverSource, String tittle, String author, String year, String description, String ISBN) {
        books.add(new Book(coverSource, tittle, author, year, description, ISBN));
    }

    public void removeCopy(String tittle, int id) {
        System.out.println(copies.size());
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().getTitle().equals(tittle) && copy.getId() == id) {
                copies.remove(copy);
                break;
            }
        }
    }

    public void addCopy(String tittle, int id) {
        copies.add(new Copy(searchBook(tittle), id));
    }

    public void rentBook(String userName, String tittle, int id) {
        Copy copy = searchCopy(tittle, id);
        copy.setAvailable(false);

        User user = searchUser(userName);
        user.addRentedCopy(copy);

        Calendar calendar = Calendar.getInstance();
        rents.add(new Rent(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR), "En prestamo", copy, user));
    }

    private Copy searchCopy(String tittle, int id) {
        Copy copy = null;
        for (Copy copy1 : copies) {
            boolean isTheCopyID = copy1.getId() == id;
            Book book = searchBook(tittle);
            boolean isTheCopyBook = copy1.getAssociatedBook().equals(book);
            if (isTheCopyID && isTheCopyBook) {
                copy = copy1;
                break;
            }
        }
        return copy;
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
        System.out.println("Libro retornado en la libreria: " + tittle + " " + id+ " " + userName);
        User user = searchUser(userName);
        Copy copy = searchCopy(tittle, id);
        for (Rent rent : rents) {
            if (rent.getAssociatedCopy().getId() == copy.getId() && rent.getAssociatedUser().equals(user)) {
                copy.setAvailable(true);
                user.removeRentedCopy(copy);
                rent.getAssociatedCopy().setAvailable(true);
                Calendar calendar = Calendar.getInstance();
                rent.setReturnDate(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
                break;
            }
        }
    }

    public String getUserToView(String userName) {
        return searchUser(userName).toView();
    }

    public boolean userHasBooks(String userName) {
        return searchUser(userName).hasBooks();
    }

    public void deleteUser(String userName) {
        users.remove(searchUser(userName));
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
            if (copy.getAssociatedBook().getTitle().equals(book.getTitle()) && copy.isAvailable()) {
                availableCopies++;
            }
        }
        return (availableCopies);
    }

    public List<Integer> getAvailableListCopies(String bookName) {
        List<Integer> availableCopies = new ArrayList<>();
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().getTitle().equals(searchBook(bookName).getTitle()) && copy.isAvailable()) {
                availableCopies.add(copy.getId());
            }
        }
        Collections.sort(availableCopies);
        return (availableCopies);
    }

    private int getTotalCopies(Book book) {
        int totalCopies = 0;
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().getTitle().equals(book.getTitle())) {
                totalCopies++;
            }
        }
        return totalCopies;
    }

    private int getRentedCopies(Book book) {
        int rentedCopies = 0;
        for (Copy copy : copies) {
            if (copy.getAssociatedBook().getTitle().equals(book.getTitle())) {
                if (!copy.isAvailable()) {
                    rentedCopies++;
                }
            }
        }
        return rentedCopies;
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
        for (Rent rent : rents) {
            if (rent.getAssociatedCopy().getAssociatedBook().equals(searchBook(bookName))) {
                rentHistory.add(rent.toView());
            }
        }
        return rentHistory;
    }

    public boolean copyExist(String selectedBook, int id) {
        boolean exist = false;
        for (Copy copy : copies) {
            if ((copy.getId() == id) && (selectedBook.equals(copy.getAssociatedBook().getTitle()))) {
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

    public int getNewPath() {
        String path;
        int pathIndex = 1;
        for (Book book : books) {
            path = book.getCoverSource().replace("sources/covers/Cover", "");
            path = path.replace(".jpg", "");
            if (Integer.parseInt(path) >= pathIndex) {
                pathIndex = Integer.parseInt(path) + 1;
            }
        }
        return pathIndex;
    }

    public List<Integer> getUserRentedListCopies(String userName, String bookName) {
        List<Integer> rentedCopies = new ArrayList<>();
        User user = searchUser(userName);
        Book book = searchBook(bookName);
        for(Copy copy : user.getRentedCopies()){
            if(copy.getAssociatedBook().equals(book)&&!copy.isAvailable()){
                rentedCopies.add(copy.getId());
            }
        }
        Collections.sort(rentedCopies);
        return rentedCopies;
    }

    public List<String> getUserRentedBooksToView(String userName) {
        List<String> rentedBooksToView = new ArrayList<>();
        for (User user : users) {
            if (user.equals(searchUser(userName))) {
                rentedBooksToView = user.getRentedBooksToView();
            }
        }
        return rentedBooksToView;
    }

    public void saveData() throws IOException {
        new Persistence(properties).saveData(users, books, copies, rents);
    }
}
