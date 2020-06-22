package com.ute.rental.bo;

import java.io.Serializable;

public class Car extends ManufacturerCar  implements Serializable {
	private int id_car;
	private int speciesID;
	private int manufacID;
	private String nameCar;
	private int quantity;
	private int still_exist;
	private String avatar;
	private String avatar_sv;
	private int price;
	private int pricehour;
	private String status;
	private String color;
	private String ounce;
	private String chassisnumber;
	private String seatnumber;
	
	
	
	
	public String getSeatnumber() {
		return seatnumber;
	}
	public void setSeatnumber(String seatnumber) {
		this.seatnumber = seatnumber;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOunce() {
		return ounce;
	}
	public void setOunce(String ounce) {
		this.ounce = ounce;
	}
	public String getChassisnumber() {
		return chassisnumber;
	}
	public void setChassisnumber(String chassisnumber) {
		this.chassisnumber = chassisnumber;
	}
	public int getId_car() {
		return id_car;
	}
	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
	public int getSpeciesID() {
		return speciesID;
	}
	public void setSpeciesID(int speciesID) {
		this.speciesID = speciesID;
	}
	public int getManufacID() {
		return manufacID;
	}
	public void setManufacID(int manufacID) {
		this.manufacID = manufacID;
	}
	public String getNameCar() {
		return nameCar;
	}
	public void setNameCar(String nameCar) {
		this.nameCar = nameCar;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getStill_exist() {
		return still_exist;
	}
	public void setStill_exist(int still_exist) {
		this.still_exist = still_exist;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAvatar_sv() {
		return avatar_sv;
	}
	public void setAvatar_sv(String avatar_sv) {
		this.avatar_sv = avatar_sv;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPricehour() {
		return pricehour;
	}
	public void setPricehour(int pricehour) {
		this.pricehour = pricehour;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	
}
