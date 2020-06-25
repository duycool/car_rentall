package com.ute.rental.bo;

public class ContractDelivery extends OtherAddress {
		private int deliveryid;
		private int speContractid;
		private int staffid;
		private String deliveryTime;
		private String receivingTime;
		private String status;
		public int getDeliveryid() {
			return deliveryid;
		}
		public void setDeliveryid(int deliveryid) {
			this.deliveryid = deliveryid;
		}
		public int getSpeContractid() {
			return speContractid;
		}
		public void setSpeContractid(int speContractid) {
			this.speContractid = speContractid;
		}
		public int getStaffid() {
			return staffid;
		}
		public void setStaffid(int staffid) {
			this.staffid = staffid;
		}
		public String getDeliveryTime() {
			return deliveryTime;
		}
		public void setDeliveryTime(String deliveryTime) {
			this.deliveryTime = deliveryTime;
		}
		public String getReceivingTime() {
			return receivingTime;
		}
		public void setReceivingTime(String receivingTime) {
			this.receivingTime = receivingTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
		
}
