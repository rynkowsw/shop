package pl.cudlax.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERR")
public class Order {
	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID", unique = true)
	private Long orderId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "SECOND_NAME")
	private String secondName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "NIP_CODE")
	private String nipCode;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ODRERR_PRODUCT", joinColumns = { @JoinColumn(name = "ORDER_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private List<Product> cart;

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getNipCode() {
		return nipCode;
	}

	public void setNipCode(String nipCode) {
		this.nipCode = nipCode;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
