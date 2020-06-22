package com.ute.rental.bo;

public class Contract  extends Car{
		private int contractid;
		private int custumerid;
		private int id_car;
		private String email;
		private String adressDelivery;
		private  int quantity;
		private  int  deposit;
		private String status;
		public int getContractid() {
			return contractid;
		}
		public void setContractid(int contractid) {
			this.contractid = contractid;
		}
		public int getCustumerid() {
			return custumerid;
		}
		public void setCustumerid(int custumerid) {
			this.custumerid = custumerid;
		}
		public int getId_car() {
			return id_car;
		}
		public void setId_car(int id_car) {
			this.id_car = id_car;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAdressDelivery() {
			return adressDelivery;
		}
		public void setAdressDelivery(String adressDelivery) {
			this.adressDelivery = adressDelivery;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getDeposit() {
			return deposit;
		}
		public void setDeposit(int deposit) {
			this.deposit = deposit;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
}
