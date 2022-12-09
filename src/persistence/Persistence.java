package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Persistence {
    private final PrivateProperties properties;
    private List<Book> books;
    private List<User> users;
    private List<Copy> copies;
    private List<Rent> rents;

    public Persistence(PrivateProperties properties) throws IOException {
        this.properties = properties;
        books = new ArrayList<>();
        copies = new ArrayList<>();
        users = new ArrayList<>();
        rents = new ArrayList<>();
        fillBooks();
        fillCopies();
        fillUsers();
        fillRents();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public List<Rent> getRents() {
        return rents;
    }

    private void fillBooks() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(properties.getBooksPath());
        Book[] books = gson.fromJson(reader, Book[].class);
        this.books.addAll(Arrays.asList(books));
        reader.close();
    }

    private void fillUsers() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(properties.getUsersPath());
        User[] users = gson.fromJson(reader, User[].class);
        this.users.addAll(Arrays.asList(users));
        reader.close();
    }

    private void fillCopies() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(properties.getCopiesPath());
        Copy[] copies = gson.fromJson(reader, Copy[].class);
        this.copies.addAll(Arrays.asList(copies));
        reader.close();
    }

    private void fillRents() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader(properties.getRentsPath());
        Rent[] rents = gson.fromJson(reader, Rent[].class);
        this.rents.addAll(Arrays.asList(rents));
        reader.close();
    }

    public void saveData(List<User> users, List<Book> books, List<Copy> copies, List<Rent> rents) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter userWriter = new FileWriter(properties.getUsersPath());
        userWriter.write(gson.toJson(users));
        userWriter.close();
        FileWriter bookWriter = new FileWriter(properties.getBooksPath());
        bookWriter.write(gson.toJson(books));
        bookWriter.close();
        FileWriter copyWriter = new FileWriter(properties.getCopiesPath());
        copyWriter.write(gson.toJson(copies));
        copyWriter.close();
        FileWriter rentWriter = new FileWriter(properties.getRentsPath());
        rentWriter.write(gson.toJson(rents));
        rentWriter.close();
    }
}
