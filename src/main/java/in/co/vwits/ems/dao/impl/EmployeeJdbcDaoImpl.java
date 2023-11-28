package in.co.vwits.ems.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import in.co.vwits.ems.dao.EmployeeDao;
import in.co.vwits.ems.model.Employee;

public class EmployeeJdbcDaoImpl implements EmployeeDao{

	@Override
	public int save(Employee e) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_table","root","sanket123");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO emp_tb VALUES(?,?,?)"); 
				){
			// Before actually firing the query we must set the values for all the ? marks
			pstmt.setInt(1, e.getId()); 
			pstmt.setString(2, e.getName()); // col,names
			pstmt.setDouble(3, e.getSalary()); 
			int noOfRowsUpdated = pstmt.executeUpdate();
			return noOfRowsUpdated;
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> allEmployees = new ArrayList<Employee>();

		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_table","root","sanket123");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM emp_tb"); 
				){

			ResultSet rs = pstmt.executeQuery(); // firing query
			while(rs.next()) {
				Employee s = new Employee();
				s.setName(rs.getString(2));
				s.setId(rs.getInt(1));
				s.setSalary(rs.getInt(3));


				allEmployees.add(s);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allEmployees;
	}

	@Override
	public void updateSalary() {

	}
	@Override
	public void delete(int id) {

		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_table","root","sanket123");
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM emp_tb WHERE id=? "); // ? map to columns in the table we want to insert
				)
		{

			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setInt(1, id);

			int noOfRowUpdated = pstmt.executeUpdate(); // firing QUERY

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Optional<Employee> findById(int id){
		Employee foundEmployee = new Employee();
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_table","root","sanket123");
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM emp_tb WHERE id = ?"); 
				){
			// Before actually firing the query we must set the values for all the ? marks
			pstmt.setInt(1, id); // col, rollno

			ResultSet rs = pstmt.executeQuery(); // firing query
			if(rs.next()) {		

				foundEmployee.setName(rs.getString(2));
				foundEmployee.setId(rs.getInt(1));

				foundEmployee.setSalary(rs.getInt(3));

				return Optional.of(foundEmployee);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}
	@Override
	public void updateName(int id, String updateName) {

		try	(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_table","root","sanket123");
				PreparedStatement pstmt = con.prepareStatement("UPDATE emp_tb SET name=? WHERE id=? "); // ? map to columns in the table we want to insert
				)
		{

			// Before actually firing the QUERY you must set the values for all ?
			pstmt.setString(1, updateName); // 1st ? is for attempts
			pstmt.setInt(2, id); // 2nd ? is for rollno


			int noOfRowUpdated = pstmt.executeUpdate(); // firing QUERY
			System.out.println("No of Records Updated are "+ noOfRowUpdated);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateSalary(Employee e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateName(Employee e) {
		// TODO Auto-generated method stub
		
	}
	
}
