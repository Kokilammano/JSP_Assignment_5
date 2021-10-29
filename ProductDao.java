package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.db.DBUtil;
import com.app.product.Products;

public class ProductDao {
	private Connection con;
	
	public ProductDao() {
		con=DBUtil.getConnection();
	}
	
	public void addProducts(Products products) {
		try {
			PreparedStatement ps = con.prepareStatement("insert into products(id,name,price,brand) values(?,?,?,?)");
			ps.setInt(1, products.getId());
			ps.setString(2, products.getName());
			ps.setInt(3, products.getPrice());
			ps.setString(4,products.getBrand());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);;
		}
		
	}
	
	public void deleteProducts(int id) {
		try {
			PreparedStatement ps = con.prepareStatement("delete from products where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateProducts(Products products) {
		try {
			PreparedStatement ps = con.prepareStatement("update products set name=?,price=?,brand=? where id=?");
			ps.setString(1, products.getName());
			ps.setInt(2, products.getPrice());
			ps.setString(3, products.getBrand());
			ps.setInt(4, products.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public List<Products> getAllProducts(){
		List<Products> prodt=new ArrayList<Products>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from products");
			while(rs.next()) {
				Products p=new Products();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setBrand(rs.getString("brand"));
				prodt.add(p);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prodt;
	
	}
	
	public Products getProductsById(int id) {
		Products p=new Products();
		try {
			PreparedStatement ps = con.prepareStatement("select * from products where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setBrand(rs.getString("brand"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return p;
		
	}
		
	
}
