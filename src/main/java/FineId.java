
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

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

	private String memberId;
	private String fineStartDate;

	public FineId() {

	}

	public FineId(String memberId, String fineStartDate) {
		this.memberId = memberId;
		this.fineStartDate = fineStartDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFineStartDate() {
		return fineStartDate;
	}

	public void setFineStartDate(String fineStartDate) {
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
