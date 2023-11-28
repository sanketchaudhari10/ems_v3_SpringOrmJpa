package in.co.vwits.ems.dao;

import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.model.Employee;

public interface EmployeeDao {

	int save(Employee e);

	List<Employee> findAll();

	void updateSalary();

	void delete(int id);

	Optional<Employee> findById(int id);

	void updateName(int id, String updateName);

	void updateSalary(Employee e);

	void updateName(Employee e);

}