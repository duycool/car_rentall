package com.ute.rental.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ute.rental.bo.Comment;
import com.ute.rental.dbconnection.ConnectionFactory;

public class CommentDAO {
	public ArrayList<Comment>getAllComment() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		String sql = "Select * from comment";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				commentList.add(convertComment(resultSet));
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
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return commentList;
		
	}
	public void insertComment(Comment comment) {
		Connection connection = null;
		Statement statement = null;
		String sql = "Insert into comment(id_car,userid,comments,full_name) values"
				+ "('"+comment.getId_car()+"','"+comment.getIdUser()+"',N'"+comment.getComment()+"',N'"+comment.getNameuser()+"')";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(sql);
			
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
	public ArrayList<Comment> getCommentById(int id) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		String sql = "Select * from comment where id_car ='"+id+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				listComment.add(convertComment(resultSet));
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
					e.printStackTrace();
				}
			}
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listComment ;
	}
	public void deleteCommentproid(int id) {
		Connection connection = null;
		Statement statement = null;
		String sql = "DELETE FROM comment WHERE id_car = '"+id+"' ";
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
	private Comment convertComment(ResultSet rs) throws SQLException {
		Comment comment = new Comment();
		comment.setIdComment(rs.getInt(1));
		comment.setId_car(rs.getInt(2));
		comment.setIdUser(rs.getInt(3));
		comment.setComment(rs.getString(4));
		comment.setNameuser(rs.getString(5));
		return comment;
	}

}
