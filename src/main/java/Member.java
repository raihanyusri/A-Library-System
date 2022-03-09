import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Member")
public class Member {

    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "faculty")
    private String faculty;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "emailAddress")
    private String emailAddress;

    public Member() {
    }

    public Member(String id, String name, String faculty, String phoneNumber, String emailAddress) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


}
