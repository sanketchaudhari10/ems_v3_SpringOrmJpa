package in.co.vwits.ems.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.dao.impl.EmployeeJpaDaoImpl;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.EmployeeService;
import in.co.vwits.exceptions.EmployeeNotFoundException;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
//	public EmployeeServiceImpl() {
////		dao=new EmployeeJdbcDaoImpl();
//		dao = new EmployeeJpaDaoImpl();
//	}

	@Override
	public void create(Employee e) {
		dao.save(e);
	}
	@Override
	public List<Employee> read() {
		return dao.findAll();
	}
	@Override
	public Optional<Employee> findById(int id) throws EmployeeNotFoundException{
		Optional<Employee> p = dao.findById(id);
		if(p.isPresent())
		{
			return p;
		}
		else
			//Throw user define exception "StudentNotFound"
			throw new EmployeeNotFoundException();
		//return p;
	}
	@Override
	public void deleteById(int id){
		dao.delete(id);
	}
	@Override
	public void updateName(int id, String name) {
		dao.updateName(id, name);
	}
	@Override
	public List<Employee> ascendingSortedByName() {
		//		List<Employee> emps = dao.findAll();
		//		Collections.sort(emps,(e1,e2)->{
		//			 e1.getName().compareTo(e2.getName());
		//		});
		//		return emps;
		//		return Collections.sort((List<Employee>) dao.findAll(),(e1,e2)->{
		//			((Employee) e1).getName().compareTo(((Employee) e2).getName());
		//		});
		List<Employee> emps = dao.findAll();
		Collections.sort(emps,(e11,e22)->e11.getName().compareTo(e22.getName()));
		return emps;

	}


	@Override
	public List<Employee> descendingSortedBySalary() {
		return dao.findAll().stream()
				.sorted()
				.collect(Collectors.toList());
	}

	@Override
	public void updateName(Employee e) {
		// TODO Auto-generated method stub
		dao.updateName(e);
		
	}

	@Override
	public void updateSalary(Employee e) {
		// TODO Auto-generated method stub
		dao.updateSalary(e);
		
	}
}


