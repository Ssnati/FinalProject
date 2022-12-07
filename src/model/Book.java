package model;

public class Book {
    private String coverSource,title,author,year,description,ISBN;
    public Book(String coverSource, String title, String author, String year, String description, String ISBN) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.coverSource = coverSource;
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", coverSource='" + coverSource + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public String toView() {
        return coverSource +";"+ title +";"+ author +";"+ year +";"+ description+";"+ ISBN;
    }
}
