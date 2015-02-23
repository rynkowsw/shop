package pl.cudlax.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "EMPLOYEES")
public class Employee {
	public interface EmployeeType {
		String CLIENT = "CLIENT";
		String WORKER = "WORKER";
	}
	@Id
	@GeneratedValue
	@Column(name = "EMPLOYEE_ID")
	private Long employeeId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "FUNCTION")
	private String function;
	
	@Index(name = "IDX_EMPLOYEE_TYPE")
	@Column(name = "TYPE", nullable = false)
	private String Type;


	
	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
