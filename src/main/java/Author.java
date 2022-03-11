import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author implements Serializable {
    
    @EmbeddedId
    private AuthorId id;

    public Author() {
    }

    public Author(AuthorId id) {
        this.id = id;
    }
    
    public String getAccessionNumber() {
        return id.getAccessionNumber();
    }
    
    public void setAccessionNumber(String accessionNumber) {
        this.id.setAccessionNumber(accessionNumber);
    }

    public String getName() {
        return id.getName();
    }

    public void setName(String name) {
        this.id.setName(name);
    }

    public AuthorId getId() {
        return id;
    }

    public void setId(AuthorId id) {
        this.id = id;
    }

    
}