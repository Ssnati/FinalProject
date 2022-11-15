package model;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String address;
    private String phone;
    private List<Book> rentedBooks;

    public User(String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(List<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public void addRentedBook(Book book, Copy copy) {
        rentedBooks.add(book);
        rentedBooks.get(rentedBooks.indexOf(book)).addCopy(copy);
    }

    public void removeRentedBook(Book book, Copy copy) {
        rentedBooks.get(rentedBooks.indexOf(book)).removeCopy(copy);
        if (rentedBooks.get(rentedBooks.indexOf(book)).getCopies().isEmpty()) rentedBooks.remove(book);
    }

    public boolean haveRentedBooks(){
        return !rentedBooks.isEmpty();
    }

}
