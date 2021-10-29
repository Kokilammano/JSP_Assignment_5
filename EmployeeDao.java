package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.employee.Employee;
import com.app.util.DBUtil;


public class EmployeeDao {
	private Connection con;
	public EmployeeDao() {
		con=DBUtil.getConnection();
	}
	
	public void addEmployee(Employee employe) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into employe(fname,lname,email,mobile) values(?,?,?,?)");
			ps.setString(1, employe.getFname());
			ps.setString(2, employe.getLname());
			ps.setString(3,employe.getEmail());
			ps.setInt(4, employe.getMobile());
			ps.executeUpdate();
		} catch (SQLException e1) {
			System.out.println(e1);;
		}
		
	}
	
	public void deleteEmployee(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from employe where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public void updateEmployeee(Employee employe) {
		try {
			PreparedStatement ps = con.prepareStatement("update employe set fname=?,lname=?,email=?,mobile=? where id=?");
			ps.setString(1, employe.getFname());
			ps.setString(2, employe.getLname());
			ps.setString(3, employe.getEmail());
			ps.setInt(4, employe.getMobile());
			ps.setInt(5, employe.getId());
			ps.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
	}
	
	public List<Employee> getAllemploye(){
		List<Employee> emp=new ArrayList<Employee>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employe");
			while(rs.next()) {
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getInt("mobile"));
				emp.add(e);
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		return emp;
	
	}
	
	public Employee getEmployeeById(int id) {
		Employee e=new Employee();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employe where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt("id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getInt("mobile"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
		return e;
		
	}
		
	
}
