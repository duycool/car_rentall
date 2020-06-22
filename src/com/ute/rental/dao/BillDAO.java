package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ute.rental.bo.Bill;
import com.ute.rental.dbconnection.ConnectionFactory;

public class BillDAO {
	public Bill getBill(int contractid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM bill WHERE contractid = '"+contractid+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Bill bill = convertoBill(resultSet);
				return bill;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		return null;
		
	}
	public void deleteBill(int idcontract) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM bill WHERE contractid = '"+idcontract+"' ";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	private Bill convertoBill(ResultSet rs) throws SQLException {
		Bill bill = new Bill();
		bill.setBillid(rs.getInt(1));
		bill.setContractid(rs.getInt(2));
		bill.setStaffid(rs.getInt(3));
		bill.setTotalMoney(rs.getInt(4));
		bill.setStatus(rs.getString(5));
		return bill;
	}
}
