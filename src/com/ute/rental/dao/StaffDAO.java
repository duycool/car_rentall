package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Staff;
import com.ute.rental.dbconnection.ConnectionFactory;

public class StaffDAO {
	public ArrayList<Staff> getAllStaffByWork(String work){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Staff> liststaff = new ArrayList<Staff>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from staff where works='"+work+"'");
			while(resultset.next()) {
				liststaff.add(convertoStaff(resultset));
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
		return liststaff;	
	}

	public ArrayList<Staff> getAllStaff(){
		Connection  connection = null;
		Statement statement = null;
		ResultSet resultset = null;
		ArrayList<Staff> liststaff = new ArrayList<Staff>();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultset = statement.executeQuery("Select * from staff");
			while(resultset.next()) {
				liststaff.add(convertoStaff(resultset));
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
		return liststaff;	
	}
	private Staff convertoStaff(ResultSet rs) throws SQLException {
		Staff staff = new Staff();
		staff.setStaffid(rs.getInt(1));
		staff.setUserid(rs.getInt(2));
		staff.setFullname(rs.getString(3));
		staff.setAddress(rs.getString(4));
		staff.setPhone(rs.getString(5));
		staff.setWorks(rs.getString(6));
		return staff;
	}
	
	public void updateStaff(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE staff set  staff_name = ?,"
				+ " address =? ,phone_number =? WHERE staffid= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, staff.getFullname());
			preparedStatement.setString(2, staff.getAddress());
			preparedStatement.setString(3, staff.getPhone());		
			preparedStatement.setInt(4, staff.getStaffid());			
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
	
	public void updateStaffByWork(Staff staff) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE staff set works =? WHERE staffid= ?";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, staff.getWorks());			
			preparedStatement.setInt(2, staff.getStaffid());			
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
	
	public Staff getStaff(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		String sql = "SELECT * FROM staff WHERE userid = '"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				Staff staff = convertoStaff(resultSet);
				return staff;
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
	public void AddStaff (Staff staff){
		Connection connection = null;
		Statement statement = null;
		String insert = "exec addStaff N'"+staff.getFullname()+"',N'"+staff.getAddress()+"','"+staff.getPhone()+"','"+staff.getWorks()+"','"+staff.getEmail()+"','"+staff.getPasswords()+"','"+staff.getRoles()+"'";
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
	public void deleteStaff(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "Delete From Staff where staffid ='"+id+"'";
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
	public static void main(String[] args) {
	
	}
}
