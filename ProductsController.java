package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ProductDao;
import com.app.product.Products;


@WebServlet("/ProductsController")
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT="/product.jsp";
	private static String LIST_PRODUCTS="/listProducts.jsp";
	private ProductDao dao;
	
	public ProductsController() {
		dao=new ProductDao();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		String action=request.getParameter("action");
		
		if(action.equalsIgnoreCase("listProducts")) {
			forward=LIST_PRODUCTS;
			request.setAttribute("prodt", dao.getAllProducts());
		}
		else if(action.equalsIgnoreCase("edit")) {
			forward=INSERT_OR_EDIT;
			int id=Integer.parseInt(request.getParameter("id"));
			Products products=dao.getProductsById(id);
			request.setAttribute("products", products);
		}
		else if(action.equalsIgnoreCase("delete")) {
			int id=Integer.parseInt(request.getParameter("id"));
			dao.deleteProducts(id);
			forward=LIST_PRODUCTS;
			request.setAttribute("prodt", dao.getAllProducts());
		}
		else {
			forward=INSERT_OR_EDIT;
		}
		
		RequestDispatcher view=request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Products p=new Products();
		p.setName(request.getParameter("name"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setBrand(request.getParameter("brand"));
		String id=request.getParameter("id");
		if(id==null || id.isEmpty()) {
			dao.addProducts(p);
		}
		else {
			p.setId(Integer.parseInt(id));
			dao.updateProducts(p);
		}
		RequestDispatcher view=request.getRequestDispatcher(LIST_PRODUCTS);
		request.setAttribute("prodt", dao.getAllProducts());
		view.forward(request, response);
	}

}
