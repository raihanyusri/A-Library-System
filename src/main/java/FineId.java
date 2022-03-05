import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

@Embeddable
public class FineId implements Serializable {
    
    @Column(name = "memberId")
    private String memberId;
    
    @Column(name = "fineStartDate")
    private Timestamp fineStartDate;

    public FineId() {
    }

    public FineId(String memberId, Timestamp fineStartDate) {
        this.memberId = memberId;
        this.fineStartDate = fineStartDate;
    }

    public String getMember() {
        return memberId;
    }

    public void setMember(String memberId) {
        this.memberId = memberId;
    }

    public Timestamp getFineStartDate() {
        return fineStartDate;
    }

    public void setFineStartDate(Timestamp fineStartDate) {
        this.fineStartDate = fineStartDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

}
