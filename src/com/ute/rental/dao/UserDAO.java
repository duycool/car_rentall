package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Custumer;
import com.ute.rental.bo.Staff;
import com.ute.rental.bo.Users;
import com.ute.rental.dbconnection.ConnectionFactory;

public class UserDAO {
		public Users findUsernameAndpasswords(String username , String passwords) {
			Connection connection = null;
			Statement  statement = null;
			ResultSet resultset = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from users where username='"+username+"' and passwords='"+passwords+"'");
				while(resultset.next()) {
					Users users = ConvertoUsers(resultset);
					return users;
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
		public Users findUsername(String username) {
			Connection connection = null;
			Statement  statement = null;
			ResultSet resultset = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from users where username='"+username+"'");
				while(resultset.next()) {
					Users users = ConvertoUsers(resultset);
					return users;
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
		
		
		public static  boolean checkusername(String username) {
			Connection connection = null;
			Statement  statement = null;
			ResultSet resultset = null;
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select * from users where username='"+username+"'");
				while(resultset.next()) {
					 ConvertoUsers(resultset);			
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
			return false;						
		}
		public ArrayList<Users> getAllUsers(){
			Connection connection = null;
			Statement statement = null;
			ResultSet resultset = null;
			ArrayList<Users> listUsers = new ArrayList<Users>();
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultset = statement.executeQuery("Select *from users");
				while(resultset.next()) {
					listUsers.add(ConvertoUsers(resultset));
				}
			}catch(SQLException e) {
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
			return listUsers;
		}
		private static Users ConvertoUsers(ResultSet rs) throws SQLException {
			Users users = new Users();
			users.setUserid(rs.getInt(1));
			users.setUsername(rs.getString(2));
			users.setPasswords(rs.getString(3));
			users.setRoles(rs.getString(4));
			return users;
		}
		public void updateUser(Users users) {
			Connection connection = null;
			Statement statement = null;
			String sql = "Update users set username='"+users.getUsername()+"',"
									+ "passwords='"+users.getPasswords()+"',roles='"+users.getRoles()+"' WHERE userid='"+users.getUserid()+"'";
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
		public void updateUserByUserNameAndPass(Users users) {
			Connection connection = null;
			Statement statement = null;
			String sql = "Update users set username='"+users.getUsername()+"',"
									+ "passwords='"+users.getPasswords()+"' WHERE userid='"+users.getUserid()+"'";
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
		public void updateUserByRoles(Users users) {
			Connection connection = null;
			Statement statement = null;
			String sql = "Update users set roles='"+users.getRoles()+"' WHERE userid='"+users.getUserid()+"'";
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
		public void updatePassUser(Users users) {
			Connection connection = null;
			Statement statement = null;
			String sql = "Update users set passwords='"+users.getPasswords()+"' WHERE userid='"+users.getUserid()+"'";
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
		public Users getUser(int id) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			String sql = "SELECT * FROM users WHERE userid = '" + id + "'";
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					Users user = ConvertoUsers(resultSet);
					return user;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if (resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return null;
		}	
//		public void AddUsersCustumer(Users users, Custumer custumer) {
//			Connection connection = null;
//			PreparedStatement statement = null;	
//			String [] returnId = { "USERID" };
//			String insert = "Insert into users(username,passwords,roles)values(N'"+users.getUsername()+"',N'"+users.getPasswords()+"','"+users.getRoles()+"')";
//			try {
//				connection = ConnectionFactory.getConnection();
//				statement = connection.prepareStatement(insert, returnId);	
//				//add users
//				int affectedRows = statement.executeUpdate();
//				if (affectedRows == 0) {
//				    throw new SQLException("Creating user failed, no rows affected.");
//				}
//				try (ResultSet rs = statement.getGeneratedKeys()) {
//				    if (rs.next()) {	
//				    	//query Id new insert in database
//				    	users.setUserid(rs.getInt(1));
//				    	String insertt = "Insert into custumer(userid,full_name,id_card,date_birth,email,address,phone_number)values('"+users.getUserid()+"',N'"+custumer.getFullnName()+"','"+custumer.getIdcard()+"','"+custumer.getDateBrith()+"','"+custumer.getEmail()+"',N'"+custumer.getAddress()+"','"+custumer.getPhoneNumber()+"')";				    	
//				    	statement = connection.prepareStatement(insertt);
//				    	//add custumer
//				    	statement.executeUpdate();
//				    }
//				    rs.close();
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				if(connection != null) {
//					try {
//						connection.close();
//					}catch(SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				if(statement != null) {
//					try {
//						statement.close();
//					}catch(SQLException e) {
//						e.printStackTrace();
//					}
//					
//				}
//			}				
//		}
		
		
//		public void AddUsersStaff(Users users, Staff staff) {
//			Connection connection = null;
//			PreparedStatement statement = null;	
//			String [] returnId = { "USERID" };
//			String insert = "Insert into users(username,passwords,roles)values(N'"+users.getUsername()+"',N'"+users.getPasswords()+"','"+users.getRoles()+"')";
//			try {
//				connection = ConnectionFactory.getConnection();
//				statement = connection.prepareStatement(insert, returnId);	
//				//add users
//				int affectedRows = statement.executeUpdate();
//				if (affectedRows == 0) {
//				    throw new SQLException("Creating user failed, no rows affected.");
//				}
//				try (ResultSet rs = statement.getGeneratedKeys()) {
//				    if (rs.next()) {	
//				    	//query Id new insert in database
//				    	users.setUserid(rs.getInt(1));
//				    	String insertt = "Insert into staff(userid,staff_name,address,phone_number,works)values('"+users.getUserid()+"',N'"+staff.getFullname()+"',N'"+staff.getAddress()+"','"+staff.getPhone()+"','"+staff.getWorks()+"')";				    	
//				    	statement = connection.prepareStatement(insertt);
//				    	//add staff
//				    	statement.executeUpdate();
//				    }
//				    rs.close();
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}finally {
//				if(connection != null) {
//					try {
//						connection.close();
//					}catch(SQLException e) {
//						e.printStackTrace();
//					}
//				}
//				if(statement != null) {
//					try {
//						statement.close();
//					}catch(SQLException e) {
//						e.printStackTrace();
//					}
//					
//				}
//			}				
//		}
		public void deleteUsers(int id)	{
			Connection connection = null;
			Statement statement = null;
			try {
				String deleteSql = "Delete from users where userid=" +id;
				connection = ConnectionFactory.getConnection();
				statement = connection.createStatement();
				statement.executeUpdate(deleteSql);			
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
		public static void main(String[] args) {
			UserDAO  userdao = new UserDAO();
			ArrayList<Users> listuser = userdao.getAllUsers();
			for(Users user : listuser) {
				System.out.println(user.getUsername());
			}
		}
}
