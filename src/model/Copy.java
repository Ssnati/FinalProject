package model;

public class Copy {
    private int id;
    private boolean available;

    public Copy(int id, boolean available) {
        this.id = id;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Copies{" +
                "id=" + id +
                ", available=" + available +
                '}';
    }
}
