import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
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

@Entity
public class Fine implements Serializable {

	
	@EmbeddedId
	private FineId id;
	
	@Column(name = "paymentAmount")
	private Double paymentAmount;

	public Fine() {
	}
	
	public Fine(FineId id) {
		this();
		this.setId(id);
	}
	
	public String getMemberId() {
		return id.getMemberId();
	}
	
	public Date getFineStartDate() {
		return id.getFineStartDate();
	}
	
	public FineId getFineId() {
		return id;
	}
	
	public void setId(FineId id) {
		this.id = id;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Fine memberId = (Fine) obj;
		return this.id.equals(memberId.id);
	}

	

}