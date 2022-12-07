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

    public String getName() {
        return name;
    }

    public String getIconSrc() {
        return iconSrc;
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

    public void removeRentedBook(Book book, Copy copy) {
    }

    public String toView() {
        return iconSrc + ";" + name + ";" + email + ";" + address + ";" + phone+";"+rentedCopies.size();
    }

    public boolean hasBooks() {
        return rentedCopies.size() > 0;
    }
}
