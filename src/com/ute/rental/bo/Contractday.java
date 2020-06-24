package com.ute.rental.bo;

import com.ute.rental.dao.MethodDAO;

public class Contractday extends OtherAddress {
		private int contractid;
		private String 	dayhire;
		private String payday;
		private int totalday;
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
		public String getPayday() {
			return payday;
		}
		public void setPayday(String payday) {
			this.payday = payday;
		}
		public int getTotalday() {
			return totalday;
		}
		public void setTotalday(int totalday) {
			this.totalday = totalday;
		}
		
}
