package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.*;
import com.ute.rental.dbconnection.ConnectionFactory;
public class CarDAO {
	//query all car
	public ArrayList<Car> getAllCar(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Car> listcar = new ArrayList<Car>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from car");
			while(resultset.next()) {
				listcar.add(convertoCar(resultset));
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
		return listcar;	
	}
	
	public ArrayList<Car> getAllCarId(int idcar){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Car> listcar = new ArrayList<Car>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from car where id_car = '"+idcar+"'");
			while(resultset.next()) {
				listcar.add(convertoCar(resultset));
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
		return listcar;	
	}
	//query  all car by speciesID
		public ArrayList<Car> getSpeciesCar(int SpeciesID){
			Connection  connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<Car> listcar = new ArrayList<Car>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from car where speciesID='"+SpeciesID+"'");			
				while(resultset.next()) {
					listcar.add(convertoCar(resultset));
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
			return listcar;	
		}
		//query all car by Manufact
		public ArrayList<Car> getManuCar(int manuID){
			Connection  connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<Car> listcar = new ArrayList<Car>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from car where manufacID='"+manuID+"'");
				while(resultset.next()) {
					listcar.add(convertoCar(resultset));
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
			return listcar;	
		}

	private Car convertoCar(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId_car(rs.getInt(1));
		car.setSpeciesID(rs.getInt(2));
		car.setManufacID(rs.getInt(3));
		car.setNameCar(rs.getString(4));
		car.setQuantity(rs.getInt(5));
		car.setStill_exist(rs.getInt(6));
		car.setAvatar(rs.getString(7));
		car.setAvatar_sv(rs.getString(8));
		car.setPrice(rs.getInt(9));
		car.setPricehour(rs.getInt(10));
		car.setStatus(rs.getString(11));
		car.setColor(rs.getString(12));
		car.setOunce(rs.getString(13));
		car.setChassisnumber(rs.getString(14));
		car.setSeatnumber(rs.getString(15));
		return car;
	}
	//add car
	public void AddCar (Car car){
		Connection connection = null;
		Statement statement = null;
		String insert = "Insert into car(speciesID,manufacID,name_car,quantity,still_exist,avatar,avatar_sv,price,pricehour,status,color,ounce,chassisnumber,seatnumber) "
				+ "values ('"+car.getSpeciesID()+"','"+car.getManufacID()+"','"+car.getNameCar()+"','"
				+car.getQuantity()+"','"+car.getStill_exist()+"','"+car.getAvatar()+"','"+car.getAvatar_sv()
				+"','"+car.getPrice()+"','"+car.getPricehour()+"',N'"+car.getStatus()+"',N'"+car.getColor()+"',N'"+car.getOunce()+"','"+car.getChassisnumber()+"',N'"+car.getSeatnumber()+"')";
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
	//delete 
	public void deleteCar(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM car WHERE id_car = '"+id+"' ";
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
	public void updateCar(Car car) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set  name_car = ?,"
				+ " quantity =? ,still_exist =?, price=?,pricehour=?,status=?,color = ? , ounce =? ,chassisnumber = ? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getNameCar());
			preparedStatement.setInt(2, car.getQuantity());
			preparedStatement.setInt(3, car.getStill_exist());
			preparedStatement.setInt(4, car.getPrice());
			preparedStatement.setInt(5, car.getPricehour());
			preparedStatement.setString(6, car.getStatus());
			preparedStatement.setString(7, car.getColor());
			preparedStatement.setString(8, car.getOunce());
			preparedStatement.setString(9, car.getChassisnumber());		
			preparedStatement.setInt(10, car.getId_car());
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
//	public void updateQuantityCar(Car car) {
//		Connection connection = null;
//		Statement statement = null;
//		String sql = "Update car set still_exist = still_exist - '"+car.getStill_exist()+"' WHERE id_car='"+car.getId_car()+"'";
//		try {
//			connection = ConnectionFactory.getConnection();
//			statement = connection.createStatement();
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//			if(statement != null) {
//				try {
//					statement.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}
//	public void updateQuantityCarDelete(Car car) {
//		Connection connection = null;
//		Statement statement = null;
//		String sql = "Update car set still_exist = still_exist + '"+car.getStill_exist()+"' WHERE id_car='"+car.getId_car()+"'";
//		try {
//			connection = ConnectionFactory.getConnection();
//			statement = connection.createStatement();
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(connection != null) {
//				try {
//					connection.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//			if(statement != null) {
//				try {
//					statement.close();
//				} catch (Exception e2) {
//					e2.printStackTrace();
//				}
//			}
//		}
//	}
	public void updateCarPicture(Car car) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set avatar =?,avatar_sv=? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getAvatar());
			preparedStatement.setString(2, car.getAvatar_sv());
			preparedStatement.setInt(3, car.getId_car());
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
	public void updateCarManu(Car car) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set manufacID =? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, car.getManufacID());
			preparedStatement.setInt(2, car.getId_car());
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
	public void updateCarSpecies(Car car) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set speciesID =? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, car.getSpeciesID());
			preparedStatement.setInt(2, car.getId_car());
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
	public void updateCarSeatNumber(Car car) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set seatnumber =? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, car.getSeatnumber());
			preparedStatement.setInt(2, car.getId_car());
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
	public Car getCar(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM car WHERE id_car = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Car car = convertoCar(resultSet);
				return car;
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
	public Car getCarJoinSpeciesAndManu(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "exec Car_getById '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Car car = convertoCarJoin(resultSet);
				return car;
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
	private Car convertoCarJoin(ResultSet rs) throws SQLException {
		Car car = new Car();
		car.setId_car(rs.getInt(1));
		car.setNameCar(rs.getString(2));
		car.setQuantity(rs.getInt(3));
		car.setStill_exist(rs.getInt(4));
		car.setAvatar(rs.getString(5));
		car.setPrice(rs.getInt(6));
		car.setPricehour(rs.getInt(7));
		car.setStatus(rs.getString(8));
		car.setColor(rs.getString(9));
		car.setOunce(rs.getString(10));
		car.setChassisnumber(rs.getString(11));
		car.setSeatnumber(rs.getString(12));
		car.setNameManufac(rs.getString(13));
		car.setNameSpecies(rs.getString(14));
		return car;
	}

	public ArrayList<Car> getCarByName(String name){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Car> listcar = new ArrayList<Car>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from car where name_car = '"+name+"'");
			while(resultset.next()) {
				listcar.add(convertoCar(resultset));
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
					e.printStackTrace();
				}
			}
			if(resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listcar;
		
	}
	
	public ArrayList<Car> getCarstillexit(int idcar){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Car> listcar = new ArrayList<Car>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select sum(still_exist) From car where id_car='"+idcar+"'");
			while(resultset.next()) {
				listcar.add(convertostillexit(resultset));
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
		return listcar;		
	}
	//update Still exit
	public static void updateStillexit (int stillexit , int idcar) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE car set still_exist = still_exist-? WHERE id_car= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, stillexit);
			preparedStatement.setInt(2,idcar);		
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

	private Car convertostillexit(ResultSet resultset) throws SQLException {
		Car car = new Car();
		car.setId_car(resultset.getInt(1));
		return car;
	}
	public static void main(String[] args) {
		CarDAO dao = new CarDAO();
		ArrayList<Car> listcar  = dao.getAllCar();
		for(Car car : listcar) {
			System.out.println(car.getId_car());
		}
	}
}
