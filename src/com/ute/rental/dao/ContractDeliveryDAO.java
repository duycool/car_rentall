package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.ContractDelivery;
import com.ute.rental.bo.Contractday;
import com.ute.rental.dbconnection.ConnectionFactory;

public class ContractDeliveryDAO {
	public ArrayList<ContractDelivery> getAllContractdelivery(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<ContractDelivery> listdContractDelivery= new ArrayList<ContractDelivery>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from contractDelivery");
			while(resultset.next()) {
				listdContractDelivery.add(convertoContractDelivery(resultset));
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
		return listdContractDelivery;	
	}

	private ContractDelivery convertoContractDelivery(ResultSet rs) throws SQLException {
		ContractDelivery contractDelivery = new ContractDelivery();
		contractDelivery.setDeliveryid(rs.getInt(1));
		contractDelivery.setSpeContractid(rs.getInt(2));
		contractDelivery.setStaffid(rs.getInt(3));
		contractDelivery.setDeliveryTime(rs.getString(4));
		contractDelivery.setReceivingTime(rs.getString(5));
		contractDelivery.setStatus(rs.getString(6));
		return contractDelivery;
	}
}
