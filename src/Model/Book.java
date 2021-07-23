package Model;

public class Book {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private String status;

    public Book(String id, String title, String author, String publisher,String status ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.status =status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
