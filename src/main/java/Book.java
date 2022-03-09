import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    public String getMemberReturnId() {
        return memberReturnId;
    }

    public void setMemberReturnId(String memberReturnId) {
        this.memberReturnId = memberReturnId;
    }
    
    @Id
    @Column(name = "accessionNumber")
    private String accessionNumber;
    @Column(name = "title")
    private String title;
    @Column(name = "author1")
    private String author1;
    @Column(name = "author2")
    private String author2;
    @Column(name = "author3")
    private String author3;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publicationYear")
    private String publicationYear;
    @Column(name = "memberId")
    private String memberId;
    @Column(name = "memberReserveId")
    private String memberReserveId;
    @Column(name = "memberReturnId")
    private String memberReturnId;
    @Column(name = "reserveDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reserveDate;
    @Column(name = "borrowDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date borrowDate;
    @Column(name = "dueDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dueDate;
    @Column(name = "returnDate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnDate;

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
    
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getMemberReserveId() {
        return memberReserveId;
    }

    public void setMemberReserveId(String memberReserveId) {
        this.memberReserveId = memberReserveId;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getAuthor3() {
        return author3;
    }

    public void setAuthor3(String author3) {
        this.author3 = author3;
    }
}
