import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class AuthorId implements Serializable {
    
    @Column(name = "accessionNumber")
    private String accessionNumber;
    @Column(name = "name")
    private String name;

    public AuthorId() {
    }

    public AuthorId(String accessionNumber, String name) {
        this.accessionNumber = accessionNumber;
        this.name = name;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }
    
    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}