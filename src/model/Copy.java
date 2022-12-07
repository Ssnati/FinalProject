package model;

public class Copy {

    private Book associatedBook;
    private int id;
    private boolean available;

    public Copy(Book associatedBook, int id) {
        this.associatedBook = associatedBook;
        this.id = id;
        this.available = true;
    }

    public Copy(Book associatedBook, int id, boolean available) {
        this.associatedBook = associatedBook;
        this.id = id;
        this.available = available;
    }

    public Book getAssociatedBook() {
        return associatedBook;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Copy{" +
                "associatedBook=" + associatedBook +
                ", available=" + available +
                '}';
    }

    public int getId() {
        return id;
    }
}
