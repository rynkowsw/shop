package pl.cudlax.dao;

import java.util.List;

import pl.cudlax.domain.Employee;

public interface EmployeeDAO {
	List<Employee> getEmployees();
	void updateEmployee(Employee c);
	void addEmployee(Employee c);
	void removeEmployee(Employee c);
	
	List<Employee> getClients();
	void updateClient(Employee c);
	void addClient(Employee c);
	void removeClient(Employee c);
}
