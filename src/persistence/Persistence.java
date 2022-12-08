package persistence;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import model.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Persistence {
    private String path;
    private List<Book> books;
    private List<User> users;
    private List<Copy> copies;
    private List<Rent> rents;

    public Persistence() throws IOException {
        books = new ArrayList<>();
        copies = new ArrayList<>();
        users = new ArrayList<>();
        rents = new ArrayList<>();
        fillBooks();
        fillCopies();
        fillUsers();
        fillRents();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    private void fillBooks() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("data/Books.json");
        Book[] books = gson.fromJson(reader, Book[].class);
        this.books.addAll(Arrays.asList(books));
        reader.close();
    }

    private void fillUsers() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("data/Users.json");
        User[] users = gson.fromJson(reader, User[].class);
        this.users.addAll(Arrays.asList(users));
        reader.close();
    }

    private void fillCopies() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("data/Copies.json");
        Copy[] copies = gson.fromJson(reader, Copy[].class);
        this.copies.addAll(Arrays.asList(copies));
        reader.close();
    }

    private void fillRents() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("data/Rents.json");
        Rent[] rents = gson.fromJson(reader, Rent[].class);
        this.rents.addAll(Arrays.asList(rents));
        reader.close();
    }

/*    {

        FileReader reader = new FileReader("data/Books.json");

        List<Copy> rentedCopies = new ArrayList<>();
        rentedCopies.add(new Copy(new Book("sources/covers/Cover1.png", "Tittle 1", "Author 1", "2019", "Description 1", "ISBN 1"), 1, true));
        User user = new User("sources/icons/Icon1.png", "Name 1", "Email 1", "Address 1", "Phone 1", rentedCopies);
        Gson gson = new Gson();
//        System.out.println(gson.toJson(user));
        User[] books = gson.fromJson(reader, User[].class);
        Stream.of(books).forEach(System.out::println);
        //print all books names
        Stream.of(books).forEach(book -> System.out.println(gson.toJson(book)));

        reader.close();
    }*/

    public static void main(String[] args) {
        try {
            System.out.println("+++++++++++++++++++++++++++++" +
                    "LIBROS" +
                    "+++++++++++++++++++++++++++++");
            new Persistence().getBooks().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++++" +
                    "COPIAS" +
                    "+++++++++++++++++++++++++++++");
            new Persistence().getCopies().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++++" +
                    "PRESTAMOS" +
                    "+++++++++++++++++++++++++++++");
            new Persistence().getRents().forEach(System.out::println);
            System.out.println("+++++++++++++++++++++++++++++" +
                    "USUARIOS" +
                    "+++++++++++++++++++++++++++++");
            new Persistence().getUsers().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
