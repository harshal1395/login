package com.bv.products;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bv.login.DBConnection;

public class ProductHandler {

	public static int addProducts(Products products) {
		int rowupdated = 0;
		String sql = "insert into products (productname,manufacturername,price)" + "values(?,?,?)";
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, products.getProductname());
			preparedStatement.setString(2, products.getManufacturername());
			preparedStatement.setDouble(3, products.getPrice());

			rowupdated = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowupdated;
	}

	public static int updateProducts(Products products) {
		int rowupdated = 0;
		String sql = "update products set productname=?,manufacturername=?,price=? where id=?";
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, products.getProductname());
			preparedStatement.setString(2, products.getManufacturername());
			preparedStatement.setDouble(3, products.getPrice());
			preparedStatement.setInt(4, products.getId());

			rowupdated = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowupdated;
	}

	public static int deleteProducts(int id) {
		int rowupdated = 0;
		String sql = "delete from products where id=?";
		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			rowupdated = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowupdated;
	}

	public static List<Products> getAllProducts() {
		List<Products> list = new ArrayList<>();
		String sql = "select * from products";
		Connection connection = DBConnection.getConnection();

		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Products products = new Products();
				products.setId(rs.getInt("id"));
				products.setProductname(rs.getString("PRODUCTNAME"));
				products.setManufacturername(rs.getString("MANUFACTURERNAME"));
				products.setPrice(rs.getDouble("PRICE"));
				list.add(products);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return list;
	}

	public static Products getProductById(int id1) {
		String sql = "select * from products";
		Connection connection = DBConnection.getConnection();
		Products products = new Products();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt("id");
				if(id1==id)
				{
				products.setId(rs.getInt("id"));
				products.setProductname(rs.getString("PRODUCTNAME"));
				products.setManufacturername(rs.getString("MANUFACTURERNAME"));
				products.setPrice(rs.getDouble("PRICE"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		return products;
	}
		

}
