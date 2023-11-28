package in.co.vwits.ems.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;


@Repository
public class EmployeeJpaDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int save(Employee e) {
		// TODO Auto-generated method stub
		
		em.persist(e);; //This inserts record in the database.
	
		return 1;
		
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		 // CALL A METHOD WHICH RETURNS ALL THE RECORD FROM DATABASE
		String jpql = "FROM Employee";
		TypedQuery<Employee> query = em.createQuery(jpql,Employee.class);
		List<Employee> employeeList = query.getResultList();
		
		return employeeList;
		
	}

	
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		em.remove(em.find(Employee.class, id)); //This fires delete query
		

	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		
		Employee e = em.find(Employee.class, id); //This fires Select query
		
		return Optional.of(e);
		
	}

	@Override
	public void updateName(Employee e) {
		// TODO Auto-generated method stub
		
		em.merge(e); //fires update query
		
	}
	
	@Override
	public void updateSalary(Employee e) {
		// TODO Auto-generated method stub
		
		em.merge(e); //fires update query
		

	}

	@Override
	public void updateSalary() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void updateName(int id, String updateName) {
		// TODO Auto-generated method stub
		
	}

}
