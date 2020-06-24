package com.ute.rental.bo;

public class ContractHour extends OtherAddress {
		private int contractid;
		private String dayhire;
		private String timehire;
		private String paytime;
		private String totaltime;
		public int getContractid() {
			return contractid;
		}
		public void setContractid(int contractid) {
			this.contractid = contractid;
		}
		public String getDayhire() {
			return dayhire;
		}
		public void setDayhire(String dayhire) {
			this.dayhire = dayhire;
		}
		public String getTimehire() {
			return timehire;
		}
		public void setTimehire(String timehire) {
			this.timehire = timehire;
		}
		public String getPaytime() {
			return paytime;
		}
		public void setPaytime(String paytime) {
			this.paytime = paytime;
		}
		public String getTotaltime() {
			return totaltime;
		}
		public void setTotaltime(String totaltime) {
			this.totaltime = totaltime;
		}
		 
		
}
