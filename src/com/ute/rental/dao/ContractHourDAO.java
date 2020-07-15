package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Contractday;
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
	public ArrayList<ContractHour> getAllcontractHourByDelivery(int  staffid , String status){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec listContractHourDelivery '"+staffid+"','"+status+"'");
			while(resultset.next()) {
				listcontracthour.add(convertoContractHourAllDelivery(resultset));
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
	
	private ContractHour convertoContractHourAllDelivery(ResultSet rs) throws SQLException {
		ContractHour contractHour = new ContractHour();
		contractHour.setContractid(rs.getInt(1));
		contractHour.setCustumerid(rs.getInt(2));
		contractHour.setId_car(rs.getInt(3));
		contractHour.setEmail(rs.getString(4));
		contractHour.setAdressDelivery(rs.getString(5));
		contractHour.setQuantity(rs.getInt(6));
		contractHour.setDeposit(rs.getInt(7));
		contractHour.setStatus(rs.getString(8));
		contractHour.setDayhire(rs.getString(9));
		contractHour.setTimehire(rs.getString(10));
		contractHour.setPaytime(rs.getString(11));
		contractHour.setTotaltime(rs.getString(12));
		contractHour.setNameSpecies(rs.getString(13));	
		contractHour.setAvatar(rs.getString(14));
		contractHour.setNameCar(rs.getString(15));
		contractHour.setTotalMoney(rs.getInt(16));
		contractHour.setSpeContractid(rs.getInt(17));
		return contractHour;
	}
	public ContractHour getContractHour(int contractid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM contracthour WHERE contractid = '"+contractid+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				ContractHour contractHour = convertoContractHour(resultSet);
				return contractHour;
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

	private ContractHour convertoContractHour(ResultSet rs) throws SQLException {
		ContractHour contractHour = new ContractHour();
		contractHour.setContractid(rs.getInt(1));
		contractHour.setDayhire(rs.getString(2));
		contractHour.setTimehire(rs.getString(3));
		contractHour.setPaytime(rs.getString(4));
		contractHour.setTotaltime(rs.getString(5));
		return contractHour;
	}
	public void AddContractHourOtherAddress (ContractHour contractHour){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addContracthourOther '"+contractHour.getCustumerid()+"','"+contractHour.getId_car()+"','"+contractHour.getEmail()+"',N'"+contractHour.getAdressDelivery()+"',N'"+contractHour.getName()+"','"+contractHour.getPhoneNumber()+"','"+contractHour.getQuantity()+"','"+contractHour.getDeposit()+"','"+contractHour.getStatus()+"','"+contractHour.getDayhire()+"','"+contractHour.getTimehire()+"','"+contractHour.getPaytime()+"','"+contractHour.getTotaltime()+"','"+contractHour.getTotalMoney()+"','"+contractHour.getNameSpecies()+"'";
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
public ArrayList<ContractHour> getAllcontractHourTorankStaff(int idstaff){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec contracthourToRankDelivery '"+idstaff+"','delivered'");
		while(resultset.next()) {
			listcontracthour.add(convertoContracthourAllDelivery(resultset));
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
public ArrayList<ContractHour> getAllcontractHourTorankAdmin(){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec contracthourtorankadmin 'delivered'");
		while(resultset.next()) {
			listcontracthour.add(convertoContracthourAllDelivery(resultset));
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

public ArrayList<ContractHour> getAllcontractHourOutAdmin(){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec contracthourOutadmin 'delivered'");
		while(resultset.next()) {
			listcontracthour.add(convertoContracthourAllDelivery(resultset));
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
public ArrayList<ContractHour> getAllcontractHourOutOfDate(int idstaff){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec contracthourOut '"+idstaff+"','delivered'");
		while(resultset.next()) {
			listcontracthour.add(convertoContracthourAllDelivery(resultset));
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
public ArrayList<ContractHour> getAllcontractHourJoin(String status){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	ArrayList<ContractHour> listcontracthour = new ArrayList<ContractHour>();
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec showAllContracthour '"+status+"'");
		while(resultset.next()) {
			listcontracthour.add(convertoContracthourAll(resultset));
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

public void UpdateStatusContracthour (ContractHour contractHour){
	Connection connection = null;
	Statement statement = null;
	String insert = "exec updateStatusContracthouradmin '"+contractHour.getContractid()+"','"+contractHour.getStatus()+"','"+contractHour.getStaffid()+"'";
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

public ContractHour getcontractHourBill(int contractid){
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	try {
		connection = ConnectionFactory.getConnection();
		statement = connection.createStatement();
		resultset = statement.executeQuery("exec ContracthourByid '"+contractid+"'");
		while(resultset.next()) {
			ContractHour contractHour = convertoContracthourBill(resultset);
			return contractHour;
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
	return null;
}
private ContractHour convertoContracthourBill(ResultSet rs) throws SQLException {
	ContractHour contractHour = new  ContractHour();
	contractHour.setContractid(rs.getInt(1));
	contractHour.setCustumerid(rs.getInt(2));
	contractHour.setId_car(rs.getInt(3));
	contractHour.setEmail(rs.getString(4));
	contractHour.setAdressDelivery(rs.getString(5));
	contractHour.setQuantity(rs.getInt(6));
	contractHour.setDeposit(rs.getInt(7));
	contractHour.setStatus(rs.getString(8));
	contractHour.setDayhire(rs.getString(9));
	contractHour.setTimehire(rs.getString(10));
	contractHour.setPaytime(rs.getString(11));
	contractHour.setTotaltime(rs.getString(12));
	contractHour.setNameSpecies(rs.getString(13));
	contractHour.setAvatar(rs.getString(14));
	contractHour.setNameCar(rs.getString(15));
	contractHour.setTotalMoney(rs.getInt(16));
	contractHour.setFullnName(rs.getString(17));
	contractHour.setNameSpecies(rs.getString(18));
	return contractHour;
}
private ContractHour convertoContracthourAll(ResultSet rs) throws SQLException {
	ContractHour contractHour = new  ContractHour();
	contractHour.setContractid(rs.getInt(1));
	contractHour.setCustumerid(rs.getInt(2));
	contractHour.setId_car(rs.getInt(3));
	contractHour.setEmail(rs.getString(4));
	contractHour.setAdressDelivery(rs.getString(5));
	contractHour.setQuantity(rs.getInt(6));
	contractHour.setDeposit(rs.getInt(7));
	contractHour.setStatus(rs.getString(8));
	contractHour.setDayhire(rs.getString(9));
	contractHour.setTimehire(rs.getString(10));
	contractHour.setPaytime(rs.getString(11));
	contractHour.setTotaltime(rs.getString(12));
	contractHour.setNameSpecies(rs.getString(13));
	contractHour.setAvatar(rs.getString(14));
	contractHour.setNameCar(rs.getString(15));
	contractHour.setTotalMoney(rs.getInt(16));
	return contractHour;
}
private ContractHour convertoContracthourAllDelivery(ResultSet rs) throws SQLException {
	ContractHour contractHour = new  ContractHour();
	contractHour.setContractid(rs.getInt(1));
	contractHour.setCustumerid(rs.getInt(2));
	contractHour.setId_car(rs.getInt(3));
	contractHour.setEmail(rs.getString(4));
	contractHour.setAdressDelivery(rs.getString(5));
	contractHour.setQuantity(rs.getInt(6));
	contractHour.setDeposit(rs.getInt(7));
	contractHour.setStatus(rs.getString(8));
	contractHour.setDayhire(rs.getString(9));
	contractHour.setTimehire(rs.getString(10));
	contractHour.setPaytime(rs.getString(11));
	contractHour.setTotaltime(rs.getString(12));
	contractHour.setNameSpecies(rs.getString(13));
	contractHour.setAvatar(rs.getString(14));
	contractHour.setNameCar(rs.getString(15));
	contractHour.setTotalMoney(rs.getInt(16));
	contractHour.setSpeContractid(rs.getInt(17));
	return contractHour;
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
