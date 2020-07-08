package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
