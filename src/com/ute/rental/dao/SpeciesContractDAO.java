package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.Statement;

import com.ute.rental.dbconnection.ConnectionFactory;

public class SpeciesContractDAO {
	public void deleteSpeciesContract(int contractid) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM speciesContract WHERE contractid = '"+contractid+"' ";
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
}
