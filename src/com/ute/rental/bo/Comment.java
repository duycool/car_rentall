package com.ute.rental.bo;

public class Comment {
	private int idComment;
	private int id_car;
	private int idUser;
	private String nameuser;
	private String comment;
	public int getIdComment() {
		return idComment;
	}
	public int getId_car() {
		return id_car;
	}
	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getNameuser() {
		return nameuser;
	}
	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
