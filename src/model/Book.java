package model;

public class Book {
    private String title;
    private String author;
    private String year;
    private String description;
    private String coverSource;


    public Book(String title, String author, String year, String description, String coverSource) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
        this.coverSource = coverSource;
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
                '}';
    }
}
