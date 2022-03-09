import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kaiyu
 */
@Embeddable
public class FineId implements Serializable {

        @Column(name = "memberId")
	private String memberId;
        @Column(name = "fineStartDate")
        @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date fineStartDate;

	public FineId() {

	}

	public FineId(String memberId, Date fineStartDate) {
		this.memberId = memberId;
		this.fineStartDate = fineStartDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getFineStartDate() {
		return fineStartDate;
	}

	public void setFineStartDate(Date fineStartDate) {
		this.fineStartDate = fineStartDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		FineId fineId = (FineId) obj;
		return this.memberId.equals(fineId.memberId);
	}

}
