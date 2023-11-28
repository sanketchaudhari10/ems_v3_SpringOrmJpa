package in.co.vwits.ems.service;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;
import in.co.vwits.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

	void create(Employee e);

	List<Employee> read();

	Optional<Employee> findById(int id) throws EmployeeNotFoundException;

	void deleteById(int id);

	void updateName(int id, String name);
	
	void updateName(Employee e);
	
	void updateSalary(Employee e);

	List<Employee> ascendingSortedByName();

	List<Employee> descendingSortedBySalary();
	

}