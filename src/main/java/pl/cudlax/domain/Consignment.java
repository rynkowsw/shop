package pl.cudlax.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONSIGNMENTS")
public class Consignment {
	@Id
	@GeneratedValue
	@Column(name = "CONSIGNMENT_ID")
	private Long consignmentId;

	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@Column(name = "REALIZATION_DATE")
	private Date realizationDate;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ACTIVE")
	private Boolean active;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUPPLIER_ID")
	private Supplier supplier;
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Long getConsignmentId() {
		return consignmentId;
	}

	public void setConsignmentId(Long consignmentId) {
		this.consignmentId = consignmentId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRealizationDate() {
		return realizationDate;
	}

	public void setRealizationDate(Date realizationDate) {
		this.realizationDate = realizationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
