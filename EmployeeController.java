package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmployeeDao;
import com.app.employee.Employee;


@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/employees.jsp";
	private static String LIST_EMPLOYEES="/listEmployees.jsp";
	private EmployeeDao dao;
	
	public EmployeeController() {
		dao=new EmployeeDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("listEmployees")) {
			forward=LIST_EMPLOYEES;
			request.setAttribute("emp", dao.getAllemploye());
		}
		else if(action.equalsIgnoreCase("edit")) {
			forward=INSERT_OR_EDIT;
			int id=Integer.parseInt(request.getParameter("id"));
			Employee employe=dao.getEmployeeById(id);
			request.setAttribute("employe", employe);
		}
		else if(action.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			dao.deleteEmployee(id);
			forward=LIST_EMPLOYEES;
			request.setAttribute("emp", dao.getAllemploye());
		}
		else {
			forward=INSERT_OR_EDIT;
		}
		
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee e=new Employee();
		e.setFname(request.getParameter("fname"));
		e.setLname(request.getParameter("lname"));
		e.setEmail(request.getParameter("email"));
		e.setMobile(Integer.parseInt(request.getParameter("mobile")));
		String id=request.getParameter("id");
		if(id==null || id.isEmpty()) {
			dao.addEmployee(e);
		}
		else {
			e.setId(Integer.parseInt(id));
			dao.updateEmployeee(e);
		}
		RequestDispatcher view=request.getRequestDispatcher(LIST_EMPLOYEES);
		request.setAttribute("emp", dao.getAllemploye());
		view.forward(request, response);
	}

	}


