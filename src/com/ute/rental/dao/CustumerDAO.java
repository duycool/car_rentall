package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.*;
import com.ute.rental.dbconnection.ConnectionFactory;

public class CustumerDAO {
	public ArrayList<Custumer> getAllCustumer(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Custumer> listcustumer = new ArrayList<Custumer>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from custumer");
			while(resultset.next()) {
				listcustumer.add(convertoCustumer(resultset));
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
		return listcustumer;	
	}
	public ArrayList<Custumer> getAllCustumerJoin(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Custumer> listcustumer = new ArrayList<Custumer>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("exec listCustumerJoin");
			while(resultset.next()) {
				listcustumer.add(convertoCustumerJoin(resultset));
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
		return listcustumer;	
	}

	private Custumer convertoCustumerJoin(ResultSet rs) throws SQLException {
		Custumer custumer = new Custumer();
		custumer.setCustumerid(rs.getInt(1));
		custumer.setUserid(rs.getInt(2));
		custumer.setFullnName(rs.getString(3));
		custumer.setIdcard(rs.getString(4));
		custumer.setDateBrith(rs.getString(5));
		custumer.setEmail(rs.getString(6));
		custumer.setAddress(rs.getString(7));
		custumer.setPhoneNumber(rs.getString(8));
		custumer.setUsername(rs.getString(9));
		custumer.setRoles(rs.getString(10));
		return custumer;
	}
	private Custumer convertoCustumer(ResultSet rs) throws SQLException {
		Custumer custumer = new Custumer();
		custumer.setCustumerid(rs.getInt(1));
		custumer.setUserid(rs.getInt(2));
		custumer.setFullnName(rs.getString(3));
		custumer.setIdcard(rs.getString(4));
		custumer.setDateBrith(rs.getString(5));
		custumer.setEmail(rs.getString(6));
		custumer.setAddress(rs.getString(7));
		custumer.setPhoneNumber(rs.getString(8));
		return custumer;
	}
	
	public void updateCustumer(Custumer custumer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE custumer set  full_name = ?,"
				+ " id_card =? ,date_birth =?, email=?,address=?,phone_number=? WHERE custumerid= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, custumer.getFullnName());
			preparedStatement.setString(2, custumer.getIdcard());
			preparedStatement.setString(3, custumer.getDateBrith());
			preparedStatement.setString(4, custumer.getEmail());
			preparedStatement.setString(5, custumer.getAddress());
			preparedStatement.setString(6, custumer.getPhoneNumber());
			preparedStatement.setInt(7, custumer.getCustumerid());			
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
	
	public void deleteCustumer (int  id) {
		Connection connection = null;
		Statement statement=null;
		String sql = "Delete custumer WHERE custumerid= '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);			
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
		}
	}
	public Custumer getCustumer(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM custumer WHERE userid = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Custumer custumer = convertoCustumer(resultSet);
				return custumer;
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
	public Custumer getCustumerByCustumerid(int custumerid) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM custumer WHERE custumerid = '"+custumerid+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Custumer custumer = convertoCustumer(resultSet);
				return custumer;
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
	public Custumer getCustumerByidCustumer(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM custumer WHERE custumerid = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Custumer custumer = convertoCustumer(resultSet);
				return custumer;
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
	public Custumer findUserMail(String email) {
		Connection connection = null;
		Statement  statement = null;
		ResultSet resultset = null;
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from custumer where email='"+email+"'");
			while(resultset.next()) {
				Custumer custumer = convertoCustumer(resultset);
				return custumer;
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
			if(resultset != null) {
				try {
					resultset.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}		
		return null;		
	}
	public void AddCustumer (Custumer custumer){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addCustumer N'"+custumer.getFullnName()+"','"+custumer.getIdcard()+"','"+custumer.getDateBrith()+"','"+custumer.getEmail()+"',N'"+custumer.getAddress()+"','"+custumer.getPhoneNumber()+"','"+custumer.getPasswords()+"','"+custumer.getRoles()+"'";
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
}
