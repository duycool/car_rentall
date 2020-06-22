package com.ute.rental.bo;

import java.io.Serializable;

public class PromotionDetails extends Car implements Serializable{
	private int idpromotion;
	private int id_car;

	private Car car;
	private int quantity;
	private SpeciesCar speciesCar;
	private ManufacturerCar manufacturerCar;
	//private int price;
	//private int pricehour;
	

	public int getId_car() {
		return id_car;
	}
	public void setId_car(int id_car) {
		this.id_car = id_car;
	}
	public SpeciesCar getSpeciesCar() {
		return speciesCar;
	}
	public int getIdpromotion() {
		return idpromotion;
	}
	public void setIdpromotion(int idpromotion) {
		this.idpromotion = idpromotion;
	}
	public void setSpeciesCar(SpeciesCar speciesCar) {
		this.speciesCar = speciesCar;
	}
	public ManufacturerCar getManufacturerCar() {
		return manufacturerCar;
	}
	public void setManufacturerCar(ManufacturerCar manufacturerCar) {
		this.manufacturerCar = manufacturerCar;
	}
	public PromotionDetails() {
		super();
		// TODO Auto-generated constructor stub
	}	
	


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}


	
}
