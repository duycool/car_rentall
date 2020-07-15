package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.*;
import com.ute.rental.dbconnection.ConnectionFactory;
public class PromotionDetailsDAO {
		
	
	public ArrayList<PromotionDetails> getAllPromotionDetails(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<PromotionDetails> listprodetails = new ArrayList<PromotionDetails>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from promotion_details");
			while(resultset.next()) {
				listprodetails.add(convertoPromotionDetails(resultset));
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
		return listprodetails;		
	}

	public void DeleteAllPromotion(String [] idcarArr,int idpromotion) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		idcarArr.toString().split(" ");
		
		try{
			CarDAO carDAO = new CarDAO();
		
		ArrayList<Car> listCar = carDAO.getAllCar();
		
		for(int i = 0 ; i < idcarArr.length ; i++) {
			int carid = Integer.parseInt(idcarArr[i]);
			for(Car car : listCar) {
				if(car.getId_car() == carid) {
					String sql = "DELETE FROM promotion_details WHERE id_car = '"+carid+"' and promotionid ='"+idpromotion+"'";
					connection = ConnectionFactory.getConnection();
					statement = connection.createStatement();
					statement.execute(sql);
				}
			}
		}
		}catch (Exception e) {
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
	public PromotionDetails getPromotionDetailsByidPromotion(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM promotion_details WHERE promotionid = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				PromotionDetails promotionDetails = convertoPromotionDetails(resultSet);
				return promotionDetails;
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
	public PromotionDetails getPromotionDetailsByidCar(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM promotion_details WHERE id_car = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				PromotionDetails promotionDetails = convertoPromotionDetails(resultSet);
				return promotionDetails;
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
	public ArrayList<Car> getListIdCarPromotion (int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM promotion_details WHERE promotionid = '"+id+"'";	
		ArrayList<Car> lisIdcar = new ArrayList<Car>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				lisIdcar.add(Covertocar(resultSet));				
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
		return lisIdcar;		
	}
	
	
	public ArrayList<Promotion> ListCarPromotion (int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "exec SearchCarByIdPromotion'"+id+"'";	
		ArrayList<Promotion> promotion = new ArrayList<Promotion>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				promotion.add(CovertopromotionJoin(resultSet));				
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
		return promotion;		
	}
	private Promotion CovertopromotionJoin(ResultSet rs) throws SQLException {
		Promotion car = new Promotion();
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

	private Car Covertocar(ResultSet rs) throws SQLException {		
		PromotionDetails prodetails = new PromotionDetails();
		prodetails.setIdpromotion(rs.getInt(1));
		prodetails.setId_car(rs.getInt(2));
		CarDAO dao = new CarDAO();
		Car car = dao.getCar(prodetails.getId_car());		
		return car;
	}

	public void deletePromotionDetailsByidCar(Car car) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM promotion_details WHERE id_car = '"+car.getId_car()+"' ";
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
	private PromotionDetails convertoPromotionDetails(ResultSet rs) throws SQLException {
		PromotionDetails prodetails = new PromotionDetails();
		prodetails.setIdpromotion(rs.getInt(1));
		prodetails.setId_car(rs.getInt(2));
		return prodetails;
	}
	
	public static void main(String[] args) {
		PromotionDetailsDAO dao = new PromotionDetailsDAO();
		ArrayList<Promotion> listdetails = dao.ListCarPromotion(2);
		for(Promotion proDetails : listdetails) {
			System.out.println("   " +  proDetails.getIdpromotion()+ " " + proDetails.getId_car() );
		}
	}
}
