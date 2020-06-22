package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.dbconnection.ConnectionFactory;

public class ContractHourDAO   {
	public void AddContractHour (ContractHour contractHour){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addContractHour '"+contractHour.getCustumerid()+"','"+contractHour.getId_car()+"','"+contractHour.getEmail()+"',N'"+contractHour.getAdressDelivery()+"','"+contractHour.getQuantity()+"','"+contractHour.getDeposit()+"','"+contractHour.getStatus()+"','"+contractHour.getDayhire()+"','"+contractHour.getTimehire()+"','"+contractHour.getPaytime()+"','"+contractHour.getTotaltime()+"','"+contractHour.getNameSpecies()+"','"+contractHour.getTotalMoney()+"'";
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

public ArrayList<ContractHour> getAllcontractHourJoin(int custumerid){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec queryHistoryContracthour '"+custumerid+"'");
			while(resultset.next()) {
				listcontracthour.add(convertoContractHourJoin(resultset));
			}
		} catch (Exception e) {
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
		return listcontracthour;
	}

private ContractHour convertoContractHourJoin(ResultSet rs) throws SQLException {
	ContractHour contractHour = new  ContractHour();
	contractHour.setContractid(rs.getInt(1));
	contractHour.setId_car(rs.getInt(2));
	contractHour.setAvatar(rs.getString(3));
	contractHour.setNameCar(rs.getString(4));
	contractHour.setDayhire(rs.getString(5));
	contractHour.setTimehire(rs.getString(6));
	contractHour.setPaytime(rs.getString(7));
	contractHour.setTotaltime(rs.getString(8));
	contractHour.setTotalMoney(rs.getInt(9));
	contractHour.setStatus(rs.getString(10));
	return contractHour;
}
}
