package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Violate;
import com.ute.rental.dbconnection.ConnectionFactory;

public class ViolateDAO {
	public void AddViolate (Violate violate){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into violate values(N'"+violate.getNameViolate()+"','"+violate.getPriceViolate()+"',N'"+violate.getReason()+"','"+violate.getId_car()+"','"+violate.getCustumerid()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(insert);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
		}				
	}
	public ArrayList<Violate> getAllViolate(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Violate> listviolate = new ArrayList<Violate>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from violate");
			while(resultset.next()) {
				listviolate.add(convertoViolate(resultset));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listviolate;	
	}
	private Violate convertoViolate(ResultSet rs) throws SQLException {
		Violate violate = new Violate();
		violate.setIdviolate(rs.getInt(1));
		violate.setNameViolate(rs.getString(2));
		violate.setPriceViolate(rs.getInt(3));
		violate.setReason(rs.getString(4));
		violate.setId_car(rs.getInt(5));
		violate.setCustumerid(rs.getInt(6));
		return violate;
	}
	
}
