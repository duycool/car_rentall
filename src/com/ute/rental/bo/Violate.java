package com.ute.rental.bo;

public class Violate extends Contract{
		private int idviolate;
		private String nameViolate;
		private int priceViolate;
		private String reason;
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		private int id_car;
		private int custumerid;
		public int getIdviolate() {
			return idviolate;
		}
		public void setIdviolate(int idviolate) {
			this.idviolate = idviolate;
		}
		public String getNameViolate() {
			return nameViolate;
		}
		public void setNameViolate(String nameViolate) {
			this.nameViolate = nameViolate;
		}
		public int getPriceViolate() {
			return priceViolate;
		}
		public void setPriceViolate(int priceViolate) {
			this.priceViolate = priceViolate;
		}
		public int getId_car() {
			return id_car;
		}
		public void setId_car(int id_car) {
			this.id_car = id_car;
		}
		public int getCustumerid() {
			return custumerid;
		}
		public void setCustumerid(int custumerid) {
			this.custumerid = custumerid;
		}
		
}
