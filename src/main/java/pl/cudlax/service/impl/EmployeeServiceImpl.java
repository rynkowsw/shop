package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.EmployeeDAO;
import pl.cudlax.domain.Employee;
import pl.cudlax.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO dao;
	
	@Override
	public List<Employee> getEmployees() {
		return dao.getEmployees();
	}

	@Override
	public void updateEmployee(Employee c) {
		dao.updateEmployee(c);
	}

	@Override
	public void addEmployee(Employee c) {
		dao.addEmployee(c);
	}

	@Override
	public void removeEmployee(Employee c) {
		dao.removeEmployee(c);
	}

	@Override
	public List<Employee> getClients() {
		return dao.getClients();
	}

	@Override
	public void updateClient(Employee c) {
		dao.updateEmployee(c);
	}

	@Override
	public void addClient(Employee c) {
		dao.addClient(c);
	}

	@Override
	public void removeClient(Employee c) {
		dao.removeEmployee(c);
	}

}
