package pl.cudlax.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RETURNS")
public class Return {

	@Id
	@GeneratedValue
	@Column(name = "RETURN_ID")
	private Long returnId;

	@Column(name = "INVOICE_NUMBER")
	private String invoiceNumber;

	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@Column(name = "AMOUNT")
	private Double amount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee client;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ACCOUNT_NUMBER")
	private String accountNumber;

	@Column(name = "ORDER_NUMBER")
	private String orderNumber;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "ACTIVE")
	private boolean active;

	public Long getReturnId() {
		return returnId;
	}

	public void setReturnId(Long returnId) {
		this.returnId = returnId;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double ammount) {
		this.amount = ammount;
	}

	public Employee getClient() {
		return client;
	}

	public void setClient(Employee client) {
		this.client = client;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
