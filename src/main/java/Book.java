import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    
    @Id
    @Column(name = "accessionNumber")
    private String accessionNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "authors")
    private String authors;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publicationYear")
    private String publicationYear;

    public String getAccessionNumber() {
        return accessionNumber;
    }
    
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }
}
