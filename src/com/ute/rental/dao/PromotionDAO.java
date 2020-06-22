package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Promotion;
import com.ute.rental.dbconnection.ConnectionFactory;

public class PromotionDAO {
	public void AddPromotionDB(Promotion promotion, String  []idcarArr) {
		//int carid = PromotionDAO.idcar(idcarArr);
    	Car car = new Car();
    	CarDAO carDAO  = new CarDAO();
		Connection connection = null;
		PreparedStatement statement = null;	
		String [] returnId = { "PROMOTIONID" };
		String insert = "Insert into promotion(startday,endday,title)values('"+promotion.getStarday()+"','"+promotion.getEndDay()+"',N'"+promotion.getTitile()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(insert, returnId);	
			//add promotion
			int affectedRows = statement.executeUpdate();
			if (affectedRows == 0) {
			    throw new SQLException("Creating user failed, no rows affected.");
			}
			try (ResultSet rs = statement.getGeneratedKeys()) {
			    if (rs.next()) {	
			    	//query Id new insert in database
			    	promotion.setIdpromotion(rs.getInt(1));	
			    	idcarArr.toString().split(" ");
			    	//get all car in database
			    	ArrayList<Car> getallCar = carDAO.getAllCar(); 
			    	//vong lap nay dung de lay het cac id trong mang
			    	for(int i = 0 ; i < idcarArr.length;i++) {
			    		//convert id tu kieu string sang kieu integer
			    		int carid = Integer.parseInt(idcarArr[i]);
			    		//get toan bo car trong database
			    		for(Car carcheck : getallCar) {
			    			//so sanh gia tri id neu giong nhau thuc hien cau lenh insert vao database
			    				if(carcheck.getId_car() == carid) {
			    					car.setId_car(carid);
			    					String insertt = "Insert into promotion_details(promotionid,id_car)values('"+promotion.getIdpromotion()+"','"+car.getId_car()+"')";				    	
			    			    	statement = connection.prepareStatement(insertt);			    			    	
			    			    	statement.executeUpdate();
			    			}
			    		}
			    		//tiep tuc lap den khi nao het mang thi thoi
			    	}			    	
			    }
			    rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
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
	
	public ArrayList<Promotion> getAllPromotion(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Promotion> listPromotion = new ArrayList<Promotion>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from promotion");
			while(resultset.next()) {
				listPromotion.add(convertoPromotion(resultset));
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
		return listPromotion;		
	}
	//Join table car , table promotion_details and table Promotion
	public ArrayList<Promotion> getAllPromotionJoin(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Promotion> listPromotion = new ArrayList<Promotion>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec listpromotion");
			while(resultset.next()) {
				listPromotion.add(convertoPromotionJoin(resultset));
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
		return listPromotion;		
	}
	private Promotion convertoPromotionJoin(ResultSet rs) throws SQLException {
		Promotion promotion = new Promotion();
		promotion.setAvatar(rs.getString(1));
		promotion.setNameCar(rs.getString(2));
		promotion.setNameManufac(rs.getString(3));
		promotion.setStarday(rs.getString(4));
		promotion.setEndDay(rs.getString(5));
		promotion.setTitile(rs.getString(6));
		return promotion;
	}

	public ArrayList<Promotion> getAllPromotionId(int idpromotion){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Promotion> listPromotion = new ArrayList<Promotion>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from promotion where promotionid = '"+idpromotion+"'");
			while(resultset.next()) {
				listPromotion.add(convertoPromotion(resultset));
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
		return listPromotion;		
	}
	
	public Promotion getPromotion(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM promotion WHERE promotionid = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Promotion promotion = convertoPromotion(resultSet);
				return promotion;
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
	public int  getPromotionByTitle(String title) {	
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM promotion WHERE title = '"+title+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Promotion promotion = convertoPromotion(resultSet);
				int idpromotion = promotion.getIdpromotion();
				return idpromotion;
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
		return 0;		
	}
	
	public void deletePromotion(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM promotion WHERE promotionid = '"+id+"' ";
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
	
	public void updatePromotionByDay(Promotion promotion) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE promotion set startday = ?, endday = ?   WHERE promotionid= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, promotion.getStarday());
			preparedStatement.setString(2, promotion.getEndDay());		
			preparedStatement.setInt(3, promotion.getIdpromotion());
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
	
	public void updatePromotionByTitle(Promotion promotion) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE promotion set title = ?   WHERE promotionid= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, promotion.getTitile());			
			preparedStatement.setInt(2, promotion.getIdpromotion());
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
	/*public static  int idcar(String [] idcarArr) {
		int carid = 0;
		idcarArr.toString().split(" ");
		for(int i = 0 ; i < idcarArr.length ; i++) {
			carid = Integer.parseInt(idcarArr[i]);									
		}
		return carid;	
	}*/

	private Promotion convertoPromotion(ResultSet rs) throws SQLException {
		Promotion promotion = new Promotion();
		promotion.setIdpromotion(rs.getInt(1));
		promotion.setStarday(rs.getString(2));
		promotion.setEndDay(rs.getString(3));
		promotion.setTitile(rs.getString(4));
		return promotion;
	}
}
