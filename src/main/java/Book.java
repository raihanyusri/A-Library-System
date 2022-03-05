import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "Book")
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
    
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
    @Column(name = "reserveDate")
    private Timestamp reserveDate;
    @Column(name = "borrowDate", nullable=true)
    private Timestamp borrowDate;
    @Column(name = "dueDate")
    private Timestamp dueDate;
    @Column(name = "returnDate")
    private Timestamp returnDate;

    public Book() {
    }

    public Book(String accessionNumber, String title, String authors, String isbn, String publisher, String publicationYear) {
        this.accessionNumber = accessionNumber;
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }
    
    
//   

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


    public Timestamp getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Timestamp reserveDate) {
        this.reserveDate = reserveDate;
    }
    
        public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Member getMember() {
        return member;
    }

    public void setReserveMember(Member member) {
        this.member = member;
    }

    
    @Override
    public String toString() {
        return "Book title: " + this.title + "\nAuthors: " + this.authors;
    }
}
