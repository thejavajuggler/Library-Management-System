package entities;

public class Book {

    private int id;

    private String title;

    private String author;

    private String status;

    private int copies;

    private double averageRatings;

    private int totalRatings;

    public Book(int id, String title, String author, String status, int copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.copies = copies;
    }

    public Book(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getAverageRatings() {
        return averageRatings;
    }

    public void setAverageRatings(double averageRatings) {
        this.averageRatings = averageRatings;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void updateRating(int rating) {
        totalRatings = totalRatings + rating;
        averageRatings = (double) totalRatings / copies;
    }
}
