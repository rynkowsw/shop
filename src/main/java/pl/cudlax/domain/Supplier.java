package pl.cudlax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPLIERS")
public class Supplier {
	@Id
	@GeneratedValue
	@Column(name = "SUPPLIER_ID")
	private Long supplierId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "AMONUT")
	private Double amount;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Column(name = "TYPE")
	private String type;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double ammount) {
		this.amount = ammount;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
