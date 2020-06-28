package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Bill;
import com.ute.rental.bo.Car;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.SpeciesContract;
import com.ute.rental.dbconnection.ConnectionFactory;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleConnection;

public class ContractDayDAO {
	
	static String contractday= "ContractDay";
//	public void AddContractDay(Contract contract, Contractday contractday,SpeciesContract speciesContract,Bill bill) {
//		Connection connection = null;
//		PreparedStatement statement = null;	
//		String [] returnId = { "CONTRACTID" };
//		String insert = "Insert into contract(custumerid,id_car,email,adressDelivery,quantity,deposit,status)values(N'"+contract.getCustumerid()+"',N'"+contract.getId_car()+"','"+contract.getEmail()+"','"+contract.getAdressDelivery()+"','"+contract.getQuantity()+"','"+contract.getDeposit()+"','"+contract.getStatus()+"')";
//		try {
//			connection = ConnectionFactory.getConnection();
//			statement = connection.prepareStatement(insert, returnId);			
//			int affectedRows = statement.executeUpdate();
//			if (affectedRows == 0) {
//			    throw new SQLException("Creating user failed, no rows affected.");
//			}
//			try (ResultSet rs = statement.getGeneratedKeys()) {
//			    if (rs.next()) {
//			    	
//			    	//query Id new insert in database
//			    	contract.setContractid(rs.getInt(1));
//			    	String insertContratday = "Insert into contractday(contractid,dayhire,payday,totalday)values('"+contract.getContractid()+"','"+contractday.getDayhire()+"','"+contractday.getPayday()+"','"+contractday.getTotalday()+"')";				    	
//			    	String insertspeciesContract = "Insert into speciesContract(contractid,nameSpecies)values('"+contract.getContractid()+"','"+speciesContract.getNameSpecies()+"')";	
//			    	String insertbill = "Insert into bill(contractid,totalMoney,status)values('"+contract.getContractid()+"','"+bill.getTotalMoney()+"','"+bill.getStatus()+"')";
//			    				    			  			    	
//			    	statement = connection.prepareStatement(insertContratday);
//			    	statement.executeUpdate();
//			    	statement = connection.prepareStatement(insertspeciesContract);
//			    	statement.executeUpdate();
//			    	statement = connection.prepareStatement(insertbill);					    				    	
//			    	statement.executeUpdate();
//			    	
//			    }
//			    rs.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if(statement != null) {
//				try {
//					statement.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}				
//	}
	public void AddContractDayOtherAddress (Contractday contractday){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addContractdayOther '"+contractday.getCustumerid()+"','"+contractday.getId_car()+"','"+contractday.getEmail()+"',N'"+contractday.getAdressDelivery()+"',N'"+contractday.getName()+"','"+contractday.getPhoneNumber()+"','"+contractday.getQuantity()+"','"+contractday.getDeposit()+"','"+contractday.getStatus()+"','"+contractday.getDayhire()+"','"+contractday.getPayday()+"','"+contractday.getTotalday()+"','"+contractday.getTotalMoney()+"','"+contractday.getNameSpecies()+"'";
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
	public void AddContractDay (Contractday contractday){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addContractday '"+contractday.getCustumerid()+"','"+contractday.getId_car()+"','"+contractday.getEmail()+"',N'"+contractday.getAdressDelivery()+"','"+contractday.getQuantity()+"','"+contractday.getDeposit()+"','"+contractday.getStatus()+"','"+contractday.getDayhire()+"','"+contractday.getPayday()+"','"+contractday.getTotalday()+"','"+contractday.getTotalMoney()+"','"+contractday.getNameSpecies()+"'";
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
	public void UpdateStatusContract (Contractday contractday){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec updateStatusContractdayadmin '"+contractday.getContractid()+"','"+contractday.getStatus()+"','"+contractday.getStaffid()+"'";
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
	public void deleteContractDay(int contractid) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM contractday WHERE contractid = '"+contractid+"' ";
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
	public ArrayList<Contractday> getAllcontractDay(){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Contractday> listcontractday = new ArrayList<Contractday>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from contractday");
			while(resultset.next()) {
				listcontractday.add(convertoContractday(resultset));
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
		return listcontractday;
	}
	public ArrayList<Contractday> getAllcontractDayJoin(int custumerid){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Contractday> listcontractday = new ArrayList<Contractday>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec queryHistoryContractday '"+custumerid+"'");
			while(resultset.next()) {
				listcontractday.add(convertoContractdayJoin(resultset));
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
		return listcontractday;
	}
	
	public ArrayList<Contractday> getAllcontractDayJoin(String status){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Contractday> listcontractday = new ArrayList<Contractday>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec showAllContractday '"+status+"'");
			while(resultset.next()) {
				listcontractday.add(convertoContractdayAll(resultset));
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
		return listcontractday;
	}
private Contractday convertoContractdayAll(ResultSet rs) throws SQLException {
		Contractday contractday = new Contractday();
		contractday.setContractid(rs.getInt(1));
		contractday.setCustumerid(rs.getInt(2));
		contractday.setId_car(rs.getInt(3));
		contractday.setEmail(rs.getString(4));
		contractday.setAdressDelivery(rs.getString(5));
		contractday.setQuantity(rs.getInt(6));
		contractday.setDeposit(rs.getInt(7));
		contractday.setStatus(rs.getString(8));
		contractday.setDayhire(rs.getString(9));
		contractday.setPayday(rs.getString(10));
		contractday.setTotalday(rs.getInt(11));
		contractday.setNameSpecies(rs.getString(12));	
		contractday.setAvatar(rs.getString(13));
		contractday.setNameCar(rs.getString(14));
		contractday.setTotalMoney(rs.getInt(15));
		return contractday;
	}
//	public ArrayList<Contractday> getAllcontractDayOtherAddressJoin(int custumerid){
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultset = null;
//		ArrayList<Contractday> listcontractday = new ArrayList<Contractday>();
//		try {
//			connection = ConnectionFactory.getConnection();
//			statement = connection.createStatement();
//			resultset = statement.executeQuery("exec queryHistoryContractdayOtherAddress '"+custumerid+"'");
//			while(resultset.next()) {
//				listcontractday.add(convertoContractdayAddressJoin(resultset));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(connection != null) {
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if(statement != null) {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if(resultset != null) {
//			try {
//				resultset.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//		return listcontractday;
//	}
	private Contractday convertoContractdayAddressJoin(ResultSet rs) throws SQLException {
		Contractday contractday = new  Contractday();
		contractday.setContractid(rs.getInt(1));
		contractday.setId_car(rs.getInt(2));
		contractday.setAvatar(rs.getString(3));
		contractday.setNameCar(rs.getString(4));
		contractday.setDayhire(rs.getString(5));
		contractday.setPayday(rs.getString(6));
		contractday.setTotalday(rs.getInt(7));
		contractday.setTotalMoney(rs.getInt(8));
		contractday.setStatus(rs.getString(9));
		contractday.setName(rs.getString(10));
		contractday.setPhoneNumber(rs.getString(11));
		contractday.setAdressDelivery(rs.getString(12));
		return contractday;
	}
	public Contractday getContractDay(int contractid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM contractday WHERE contractid = '"+contractid+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Contractday contractday = convertoContractday(resultSet);
				return contractday;
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

	private Contractday convertoContractday(ResultSet rs) throws SQLException {
		Contractday contractday = new Contractday();
		contractday.setContractid(rs.getInt(1));
		contractday.setDayhire(rs.getString(2));
		contractday.setPayday(rs.getString(3));
		contractday.setTotalday(rs.getInt(4));
		return contractday;
	}
	private Contractday convertoContractdayJoin(ResultSet rs) throws SQLException {
			Contractday contractday = new  Contractday();
			contractday.setContractid(rs.getInt(1));
			contractday.setId_car(rs.getInt(2));
			contractday.setAvatar(rs.getString(3));
			contractday.setNameCar(rs.getString(4));
			contractday.setDayhire(rs.getString(5));
			contractday.setPayday(rs.getString(6));
			contractday.setTotalday(rs.getInt(7));
			contractday.setTotalMoney(rs.getInt(8));
			contractday.setStatus(rs.getString(9));
			contractday.setName(rs.getString(10));
			contractday.setPhoneNumber(rs.getString(11));
			contractday.setAdressDelivery(rs.getString(12));
			return contractday;
	}
	public static void main(String[] args) {
		ContractDayDAO contractDayDAO = new ContractDayDAO();
		ArrayList<Contractday> lisContractdays = contractDayDAO.getAllcontractDayJoin(1);
		for(Contractday contractday : lisContractdays) {
			System.out.println(contractday.getAdressDelivery());
		}
		
	}
	
}
