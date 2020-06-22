package com.ute.rental.bo;

import java.io.Serializable;
import java.util.List;

import com.ute.rental.dao.MethodDAO;

public class Promotion extends PromotionDetails implements Serializable {
	private int idpromotion;
	private String starday;
	private String endDay;
	private String titile;
	private List <PromotionDetails> promotionDetails;
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}	
	public List<PromotionDetails> getPromotionDetails() {
		return promotionDetails;
	}
	public void setPromotionDetails(List<PromotionDetails> promotionDetails) {
		this.promotionDetails = promotionDetails;
	}
	public Promotion() {
		super();	
	}
	public Promotion(int idpromotion, String starday, String endDay) {
		super();
		this.idpromotion = idpromotion;
		this.starday = starday;
		this.endDay = endDay;
	}
	public int getIdpromotion() {
		return idpromotion;
	}
	public void setIdpromotion(int idpromotion) {
		this.idpromotion = idpromotion;
	}
	public String getStarday() {
		return starday;
	}
	public void setStarday(String starday) {
		this.starday = starday;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	
}
