import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    
    @Id
    @Column(name = "accessionNumber")
    private String accessionNumber;
    @Column(name = "title")
    private String title;
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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date reserveDate;
    @Column(name = "borrowDate")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date borrowDate;
    @Column(name = "dueDate")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dueDate;
    @Column(name = "returnDate")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
    
    public String getMemberReturnId() {
        return memberReturnId;
    }

    public void setMemberReturnId(String memberReturnId) {
        this.memberReturnId = memberReturnId;
    }
}
