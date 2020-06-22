package com.ute.rental.bo;

public class SpeciesContract extends Bill {
		private int speContractid;
		private int contractid;
		private String nameSpecies;
		public int getSpeContractid() {
			return speContractid;
		}
		public void setSpeContractid(int speContractid) {
			this.speContractid = speContractid;
		}
		public int getContractid() {
			return contractid;
		}
		public void setContractid(int contractid) {
			this.contractid = contractid;
		}
		public String getNameSpecies() {
			return nameSpecies;
		}
		public void setNameSpecies(String nameSpecies) {
			this.nameSpecies = nameSpecies;
		}		
}
