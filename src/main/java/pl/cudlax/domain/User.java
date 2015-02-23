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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * ORM reprezentujcy u�ytkownika
 * 
 * @author Kamil Z w
 */
@Entity
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID", unique = true)
	private Long userId;

	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = "Imie musi sk�ada� zaczyna� si� z du�ej litery i zawiera� tylko litery.")
	@Size(min = 1, max = 30, message = "Imie nie mo�e by� puste i nie mo�e by� d�u�sze ni� 30 liter")
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = "Nazwisko musi zaczyna� si� z du�ej litery i zawiera� wy��cznie litery.")
	@Size(min = 1, max = 30, message = "Nazwisko nie mo�e by� puste i nie mo�e by� d�u�sze ni� 30 liter")
	@Column(name = "SECOND_NAME")
	private String secondName;

	@Email(message = "Email nie jest poprawny")
	@Column(name = "EMAIL", unique = true)
	private String email;

	@Pattern(regexp = "[0-9]*", message = "Numer musi sk�ada� si� tylko z cyfr")
	@Size(min = 9, max = 11, message = "Numer nie mo�e by� kr�tszy ni� 9 cyfr i nie mo�e by� d�u�szy ni� 11 cyfr")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "ROLE")
	private String role;

	@Size(min = 6, max = 30, message = "Has�o nie mo�e by� kr�tsze ni� 6 znak�w")
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ENABLED", columnDefinition = "TINYINT default 1", nullable = false)
	private boolean Enabled;

	@Column(name = "COMPANY")
	private String Company;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_PRODUCT", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID") })
	private List<Product> cart;

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", role=" + role + "]";
	}

}
