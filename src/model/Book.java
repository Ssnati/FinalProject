package model;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String year;
    private String description;
    private String coverSource;

    private List<Copy> copies;

    public Book(String title, String author, String year, String description, String coverSource) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.coverSource = coverSource;
        copies = new ArrayList<>();
        copies.add(new Copy(1, true));
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverSource() {
        return coverSource;
    }

    public void setCoverSource(String coverSource) {
        this.coverSource = coverSource;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }
    //Fin de Getters and Setters

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", cover='" + coverSource + '\'' +
                ", copies=" + copies +
                '}';
    }

    public void addCopy(Copy copy) {
        copies.add(copy);
    }


    public void removeCopy(Copy copy) {
        copies.remove(copy);
    }
    public boolean isAvailable() {
        boolean available = false;
        for (Copy copy : copies) {
            if (copy.isAvailable()) {
                available = true;
                break;
            }
        }
        return available;
    }

    public Copy getCopy(int id) {
        Copy auxCopy = null;
        for (Copy copy : copies) {
            if (copy.getId() == id) {
                auxCopy = copy;
                break;
            }
        }
        return auxCopy;
    }

    public List<Copy> getRentedCopies(){
        List<Copy> rentedCopies = new ArrayList<>();
        for (Copy copy : copies) {
            if (!copy.isAvailable()) {
                rentedCopies.add(copy);
            }
        }
        return rentedCopies;
    }

    public List<Copy> getAvailableCopies(){
        List<Copy> availableCopies = new ArrayList<>();
        for (Copy copy : copies) {
            if (copy.isAvailable()) {
                availableCopies.add(copy);
            }
        }
        return availableCopies;
    }

}
