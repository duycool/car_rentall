package com.ute.rental.bo;

public class ManufacturerCar extends SpeciesCar {
	private int manuFacID;
	private String nameManufac;
	public int getManuFacID() {
		return manuFacID;
	}
	public void setManuFacID(int manuFacID) {
		this.manuFacID = manuFacID;
	}
	public String getNameManufac() {
		return nameManufac;
	}
	public void setNameManufac(String nameManufac) {
		this.nameManufac = nameManufac;
	}	
}
