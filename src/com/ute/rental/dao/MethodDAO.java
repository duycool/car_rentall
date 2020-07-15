package com.ute.rental.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.mindrot.jbcrypt.BCrypt;

import com.ute.rental.bo.Contract;
import com.ute.rental.bo.ContractDelivery;
import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.bo.Staff;


public class MethodDAO {
	public static int moneySaleOff(String title , int price) {
		int priceSaleoff = 1;
		if(title.equals("50%")) {					
			return priceSaleoff = (int) (price * 0.5);
		}else if(title.equals("40%")) {			
			return priceSaleoff = (int) (price * 0.6);
		}else if(title.equals("30%")) {				
			return priceSaleoff = (int) (price * 0.7);
		}else if(title.equals("20%")) {
			return priceSaleoff = (int) (price * 0.8);
		}else if (title.equals("10%")) {
			return priceSaleoff = (int) (price * 0.9);
		}
		return priceSaleoff = (int) (price * 0.95);		
	}
	public static Date StringToDate(String payday) throws ParseException {
	      //Instantiating the SimpleDateFormat class
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	      //Parsing the given String to Date object
	      Date date = formatter.parse(payday);
	      return date;
	   }
	
	public static Date StringToDateHour(String payday) throws ParseException {
	      //Instantiating the SimpleDateFormat class
	      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	      //Parsing the given String to Date object
	      Date date = formatter.parse(payday);
	      return date;
	   }
	public static String ParseSpecies(String input) {
		if(input.equals("1")) {
			return "CarNumberFloor";
		}else if(input.equals("2")) {
			return "AutomaticGear";
		}else {
			return "Motorcycle";
		}
	}
	
	public static String ParsePhantram(String input) {
		if(input.equals("50")) {
			return "50%";
		}else if(input.equals("40")) {
			return "40%";
		}else if(input.equals("30")) {
			return "30%";
		}else if(input.equals("20")) {
			return "20%";
		}else if(input.equals("10")) {
			return "10%";
		}
		return "5%";
	}
//	public static String encrypt(String passwordinput) throws NoSuchAlgorithmException , UnsupportedEncodingException{
//		String textpass;	
//		MessageDigest msd = MessageDigest.getInstance("MD5");
//		byte[] passwordInputBytes = passwordinput.getBytes("UTF-8");
//		byte[] textpassBytes = msd.digest(passwordInputBytes);
//		
//		BigInteger bigInt = new BigInteger(1, textpassBytes);
//		textpass = bigInt.toString(16);				
//		return textpass;
//	}
	
	
	public static String TimeHientai() {
		java.sql.Time timeht=new java.sql.Time(new java.util.Date().getTime());
		String time = String.valueOf(timeht);
		return time;
	}
	public static String Ngayhientai() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		String dateStr = String.valueOf(date);
		return dateStr;
	}
	public static Date NgayhientaiDate() {
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);
		return date;
	}
	public static boolean checkday(String hireDayStr) {
		String ngaythangnamhtStr = Ngayhientai();		
		String [] ngaythangnamht  = ngaythangnamhtStr.split("-");
		String [] ngaythangnamthue = hireDayStr.split("/");						
		int namht = Integer.parseInt(ngaythangnamht[0]);	
		int thanght = Integer.parseInt(ngaythangnamht[1]);
		int ngayht = Integer.parseInt(ngaythangnamht[2]);		
		int namthue = Integer.parseInt(ngaythangnamthue[0]);
		int thangthue = Integer.parseInt(ngaythangnamthue[1]);
		int ngaythue = Integer.parseInt(ngaythangnamthue[2]);			
		int tinhnam = (namht - namthue);
		int tinhthang = (thanght - thangthue);
		int tinhngay = (ngayht - ngaythue);	
		if(tinhnam > 0) {
			return true;
		}else {
			if(tinhthang > 0) {
				return true;
			}else if(tinhthang < 0) {
				return false;
			}else {
				if(tinhngay > 0) {
					return true;
				}else {
					return false;
				}			
			}
		}
	}
	public static String hashPass(String pass) {
		String hash = BCrypt.hashpw(pass, BCrypt.gensalt(12));
		return hash;
	}
	
	public static boolean checkHashPass(String passlogin , String passdatabase) {
		boolean valuate = BCrypt.checkpw(passlogin,passdatabase);
		return valuate;
	}
	public static String ParseDateInDatabase(String date) {	
		String ngaythangnam [] = date.split("\\s");
		String ngaythangnamStr = ngaythangnam[0];
		String [] parseNgaythangnam  = ngaythangnamStr.split("-");
		String nam = parseNgaythangnam[0];
		String thang = parseNgaythangnam[1];
		String ngay = parseNgaythangnam[2];		
		return ngay + "/" + thang + "/" + nam;
	}
	public static String ParseDateTorankInDatabase(String date) {	
		String ngaythangnam [] = date.split("\\s");
		String ngaythangnamStr = ngaythangnam[0];
		String [] parseNgaythangnam  = ngaythangnamStr.split("-");
		String nam = parseNgaythangnam[0];
		String thang = parseNgaythangnam[1];
		String ngay = parseNgaythangnam[2];	
		String giophutgiay  = ngaythangnam[1];
		String parsegiophutgiay[] = giophutgiay.split(":");
		String gio = parsegiophutgiay[0];
		String phut = parsegiophutgiay[1];
		String giay = parsegiophutgiay[2];
		return "Thời Gian Kết Thúc" + "\t" + ngay + "/" + thang + "/" + nam + "\t"+ "Vào Lúc : " + "\t"+  gio +"giờ" + phut + "phút" + giay + "giây";
	}
	public static String ParseTimeInDatabase(String date) {	
		String ngaythangnam [] = date.split("\\s");
		String hourminute = ngaythangnam[1];
		String [] parsehourminute  = hourminute.split(":");
		String hour = parsehourminute[0];
		String minute = parsehourminute[1];	
		return hour + "giờ" + minute +"phút";
	}
	public static boolean checkStatusContract(ArrayList<Contract>listcontractCustumer , ArrayList<Contract> lisContract ) {						
		String  resultNewRent = null;	
		String resultOther = null;
		String AlreadyPaid = null;
		for(Contract contractCustumer : listcontractCustumer) {			
				for(Contract contract: lisContract) {
					if(contractCustumer.getContractid() == contract.getContractid()) {
						String arr[]  = contract.getStatus().split(" ");						
						for(String chuoi : arr) {
							if(chuoi.equals(null)) {
								resultNewRent += chuoi;
							}else if(chuoi.equals("AlreadyPaid")) {
								AlreadyPaid += chuoi;
							}else{
								resultOther += chuoi;
							}
					}					
				}
			}
		}
		if(resultNewRent != null && resultOther == null && AlreadyPaid != null) {
			return false;
		}else if(resultNewRent != null && resultOther != null  && AlreadyPaid != null ) {
			return true;
		}else if(resultNewRent == null &&  resultOther != null && AlreadyPaid != null) {
			return true;
		}else if(resultNewRent == null &&  resultOther != null && AlreadyPaid == null){
			return true;
		}else if(resultNewRent != null &&  resultOther != null && AlreadyPaid == null){
			return true;
		}else{
			return false;
		}							
	}
	
	public static String ConvertNameSpecies(String nameSpecies) {
		if(nameSpecies.equals("CarNumberFloor")) {
			return "Xe Số Sàn";
		}else if(nameSpecies.equals("AutomaticGear")) {
			return "Xe Số Tự Động";
		}else {
			return "Xe Mô Tô";
		}
	}
	//check promotion id xe
	public static boolean checkPromotion(int  id_car) {
		PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();					
		ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
		for(PromotionDetails details : lisPromotionDetails) {
			if(details.getId_car() == id_car) {
					return true;
				}
			}
		return false;
	}
	public static  ArrayList<SpeciesCar> listSpecies(ArrayList<SpeciesCar> lisSpeciesCar){
		ArrayList<SpeciesCar> listspecies = new  ArrayList<SpeciesCar>();
		for(SpeciesCar speciesCar : lisSpeciesCar) {
			speciesCar.setNameSpecies(MethodDAO.ConvertNameSpecies(speciesCar.getNameSpecies()));
			listspecies.add(speciesCar);
		}
		return listspecies;
	}
	public static int totalMoneyHour(int totalhour , int totalminute , int price) {
		int tg = 0;
		if(totalhour <= 0 ) {
			 tg = 0;		
		}else if(totalhour > 0) {
			if(totalminute < 0) {
				tg = 0;
			}else if(totalminute == 0) {
				tg = totalhour * price;				
			}else {
				tg = (totalhour * price) + ((totalminute * price)/60);
			}
		}else {
			tg = 0;
		}
		return tg;		
	}
	public static ArrayList<ContractHour> listContracthouParse(ArrayList<ContractHour> lisContractHours){
		ArrayList<ContractHour> listCheck = new ArrayList<ContractHour>();
		for (ContractHour contractHour : lisContractHours) {
			contractHour.setDayhire(MethodDAO.ParseDateInDatabase(contractHour.getDayhire()));
			contractHour.setTimehire(MethodDAO.ParseTimeInDatabase(contractHour.getTimehire()));
			contractHour.setPaytime(MethodDAO.ParseTimeInDatabase(contractHour.getPaytime()));
			contractHour.setTotaltime(MethodDAO.ParseTimeInDatabase(contractHour.getTotaltime()));
			contractHour.setStatus(MethodDAO.ParseStatusContract(contractHour.getStatus()));
			listCheck.add(contractHour);
		}
		return listCheck;	
	}
	
	public static ContractHour ContracthouParse(ContractHour contractHour){		
	contractHour.setDayhire(MethodDAO.ParseDateInDatabase(contractHour.getDayhire()));
	contractHour.setTimehire(MethodDAO.ParseTimeInDatabase(contractHour.getTimehire()));
	contractHour.setPaytime(MethodDAO.ParseTimeInDatabase(contractHour.getPaytime()));
	contractHour.setTotaltime(MethodDAO.ParseTimeInDatabase(contractHour.getTotaltime()));
	contractHour.setStatus(MethodDAO.ParseStatusContract(contractHour.getStatus()));
	contractHour.setNameSpecies(MethodDAO.ParseNameSpeciesContract(contractHour.getNameSpecies()));
	return contractHour;	
	}
	public static String ParseStatusContract(String status) {
		if(status.equals("newRent")) {
			return "Đang Chờ";
		}else if(status.equals("AlreadyPaid")) {
			return "Đã Trả";
		}else if(status.equals("delivered")) {
			return "Đang Thuê";
		}else if(status.equals("Approved")) {
			return "Đã Duyệt";
		}else {
			return  "Đang Giao";
		}
	}
	public static ArrayList<Contractday> listContractdayParse(ArrayList<Contractday> lisContractday){
		ArrayList<Contractday> listCheck = new ArrayList<Contractday>();
		for (Contractday contractday : lisContractday) {
			contractday.setDayhire(MethodDAO.ParseDateInDatabase(contractday.getDayhire()));
			contractday.setPayday(MethodDAO.ParseDateInDatabase(contractday.getPayday()));
			contractday.setStatus(MethodDAO.ParseStatusContract(contractday.getStatus()));
			listCheck.add(contractday);
		}
		return listCheck;	
	}
	public static Contractday ContractdayParse(Contractday contractday){	
		contractday.setDayhire(MethodDAO.ParseDateInDatabase(contractday.getDayhire()));
		contractday.setPayday(MethodDAO.ParseDateInDatabase(contractday.getPayday()));
		contractday.setStatus(MethodDAO.ParseStatusContract(contractday.getStatus()));
		contractday.setNameSpecies(MethodDAO.ParseNameSpeciesContract(contractday.getNameSpecies()));	
		return contractday;	
	}
	private static String ParseNameSpeciesContract(String species) {
		if(species.equals("ContractDAY")) {
			return "Hợp Đồng Thuê Theo Ngày";
		}else {
			return "Hợp Đồng Thuê Theo Giờ";
		}
	}
	public static ArrayList<Contractday> listContractdayTorankParse(ArrayList<Contractday> lisContractday){
		ArrayList<Contractday> listCheck = new ArrayList<Contractday>();
		for (Contractday contractday : lisContractday) {
			contractday.setDayhire(MethodDAO.ParseDateInDatabase(contractday.getDayhire()));
			contractday.setPayday(MethodDAO.ParseDateTorankInDatabase(contractday.getPayday()));
			contractday.setStatus(MethodDAO.ParseStatusContract(contractday.getStatus()));
			listCheck.add(contractday);
		}
		return listCheck;	
	}
	

//	public static boolean checkStatusContractDay(ArrayList<Contractday> listContractday) {		
//		String status = null;	
//		for(Contractday contractday : listContractday) {
//			if(contractday.getStatus().equals("newRent")) {
//				String arr[] = contractday.getStatus().split(" ");
//				for(String chuoi : arr) {
//					status +=chuoi;
//				}				
//			}
//		}
//		if(status != null) {
//			return true;
//		}
//		return false;
//	}

	public static void main(String[] args) throws ParseException  {		
	
	}
	
}
