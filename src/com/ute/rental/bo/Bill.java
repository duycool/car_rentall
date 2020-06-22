package com.ute.rental.bo;

public class Bill extends Contract{
		private int billid;
		private int contractid;
		private int staffid;
		private int totalMoney;
		private String status;
		public int getBillid() {
			return billid;
		}
		public void setBillid(int billid) {
			this.billid = billid;
		}
		public int getContractid() {
			return contractid;
		}
		public void setContractid(int contractid) {
			this.contractid = contractid;
		}
		public int getStaffid() {
			return staffid;
		}
		public void setStaffid(int staffid) {
			this.staffid = staffid;
		}
		public int getTotalMoney() {
			return totalMoney;
		}
		public void setTotalMoney(int totalMoney) {
			this.totalMoney = totalMoney;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}		
}	
