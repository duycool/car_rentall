package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.*;
import com.ute.rental.dbconnection.ConnectionFactory;
public class ManufacturerDAO {
	//Query all Manufacturer
	public ArrayList<ManufacturerCar> getAllManufac(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<ManufacturerCar> listManufac = new ArrayList<ManufacturerCar>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from manufacturer_car");
			while(resultset.next()) {
				listManufac.add(convertoManufac(resultset));
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
		return listManufac;		
	}
	//query three manuMoto
	public ArrayList<ManufacturerCar> getThreeManufac(String namemanu){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<ManufacturerCar> listManufac = new ArrayList<ManufacturerCar>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from manufacturer_car where name_manufac ='"+namemanu+"'");
			while(resultset.next()) {
				listManufac.add(convertoManufac(resultset));
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
		return listManufac;		
	}
	public void AddManufac (ManufacturerCar manu){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into manufacturer_car(name_manufac) "
				+ "values ('"+manu.getNameManufac()+"')";
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
	//get ManufacturerId
	public ManufacturerCar getManufac(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM manufacturer_car WHERE manufacID = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				ManufacturerCar maCar = convertoManufac(resultSet);
				return maCar;
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
	//
	public ManufacturerCar getNameManufac(String manufact) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM manufacturer_car WHERE name_manufac = '"+manufact+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				ManufacturerCar maCar = convertoManufac(resultSet);
				return maCar;
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
	//delete Manufacturer
	public void deleteManu(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM manufacturer_car WHERE manufacID = '"+id+"' ";
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
	//update manufacturer
	public void updateManu (ManufacturerCar mCar) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE manufacturer_car set name_manufac = ? WHERE manufacID= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, mCar.getNameManufac());
			preparedStatement.setInt(2, mCar.getManuFacID());
			preparedStatement.executeUpdate();
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
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	
	//Covert 
	private ManufacturerCar convertoManufac(ResultSet rs) throws SQLException {
		ManufacturerCar manucar  =  new ManufacturerCar();
		manucar.setManuFacID(rs.getInt(1));
		manucar.setNameManufac(rs.getString(2));
		return manucar;
	}
}
