package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ute.rental.bo.OtherAddress;
import com.ute.rental.dbconnection.ConnectionFactory;

public class OtherAddressDAO {
	public OtherAddress getOtherAddress(int contractid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM otherAddress WHERE contractid = '"+contractid+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				OtherAddress otherAddress = convertoOtherAddress(resultSet);
				return otherAddress;
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

	private OtherAddress convertoOtherAddress(ResultSet rs) throws SQLException {
		OtherAddress otherAddress = new OtherAddress();
		otherAddress.setContractid(rs.getInt(1));
		otherAddress.setName(rs.getString(2));
		otherAddress.setAddress(rs.getString(3));
		otherAddress.setPhoneNumber(rs.getString(4));
		return otherAddress;
	}
}
