package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String iconSrc, name, email, address, phone;

    private List<Copy> rentedCopies;

    public User(String iconSrc, String name, String email, String address, String phone) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.iconSrc = iconSrc;
        rentedCopies = new ArrayList<>();
    }

    public User(String iconSrc, String name, String email, String address, String phone, List<Copy> rentedCopies) {
        this.iconSrc = iconSrc;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.rentedCopies = rentedCopies;
    }

    public List<Copy> getRentedCopies() {
        return rentedCopies;
    }

    public void setRentedCopies(List<Copy> rentedCopies) {
        this.rentedCopies = rentedCopies;
    }

    public String getName() {
        return name;
    }

    public String getIconSrc() {
        return iconSrc;
    }

    public String toView() {
        return iconSrc + ";" + name + ";" + email + ";" + address + ";" + phone+";"+rentedCopies.size();
    }

    public boolean hasBooks() {
        return rentedCopies.size() > 0;
    }

    public List<String> getRentedBooksToView() {
        List<String> rentedBooks = new ArrayList<>();
        for (Copy copy : rentedCopies) {
            rentedBooks.add(copy.getAssociatedBook().toView());
        }
        return rentedBooks;
    }

    public void addRentedCopy(Copy copy) {
        rentedCopies.add(copy);
    }

    public void removeRentedCopy(Copy copy) {
        rentedCopies.remove(copy);
    }
}
