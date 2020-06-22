package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.*;
import com.ute.rental.dbconnection.ConnectionFactory;

public class SpeciesCarDAO {
	//Query all Species Car
	public ArrayList<SpeciesCar> getAllSpecies(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<SpeciesCar> listSpecies = new ArrayList<SpeciesCar>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from species_car");
			while(resultset.next()) {
				listSpecies.add(convertoSpecies(resultset));
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
		return listSpecies;
		
	}
	public SpeciesCar getSpeciesByName(String name){
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "Select * from species_car where name_species ='"+name+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				SpeciesCar speCar = convertoSpecies(resultSet);
				return speCar;
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
	//Insert Species Car
	public void AddSpecies (SpeciesCar speciesCar){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into species_car(name_species)"
				+ "values(N'"+speciesCar.getNameSpecies()+"')";
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
	//delete SpeciesCar
	public void deleteSpecies(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM species_car WHERE speciesID = '"+id+"' ";
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
	//update Species
	public void updateSpecies (SpeciesCar sCar) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE species_car set name_species = ? WHERE speciesID= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, sCar.getNameSpecies());
			preparedStatement.setInt(2, sCar.getSpeciesId());
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
	//get SpeciesID
	public SpeciesCar getSpecies(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM species_car WHERE speciesID = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				SpeciesCar speCar = convertoSpecies(resultSet);
				return speCar;
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
	//Covert to Species 
	private SpeciesCar convertoSpecies(ResultSet rs) throws SQLException {
		SpeciesCar speCar = new SpeciesCar();
		speCar.setSpeciesId(rs.getInt(1));
		speCar.setNameSpecies(rs.getString(2));
		return speCar;
	}
	public static void main(String[] args) {
		String name = "Xe ô tô";
		SpeciesCar car = new SpeciesCar();
		car.setNameSpecies(name);
		SpeciesCarDAO dao  = new SpeciesCarDAO();
		//dao.AddSpecies(name);
	}
}
