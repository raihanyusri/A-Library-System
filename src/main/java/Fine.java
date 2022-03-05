
import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "Fine")
public class Fine implements Serializable {
    
    @EmbeddedId
    private FineId fineId;
    
    @Column(name = "paymentAmount")
    private Double paymentAmount;
    
    @ManyToOne(optional = true)
    @MapsId("memberId")
    @JoinColumn(name = "memberId")
    private Member member;
    
    public Fine() {
    }

    public Fine(FineId fineId, Double paymentAmount, Member member) {
        this.fineId = fineId;
        this.paymentAmount = paymentAmount;
        this.member = member;
    }


    public FineId getFineId() {
        return fineId;
    }

    public void setFineId(FineId fineId) {
        this.fineId = fineId;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    
}
