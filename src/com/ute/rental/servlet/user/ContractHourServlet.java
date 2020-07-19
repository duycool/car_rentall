package com.ute.rental.servlet.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Car;
import com.ute.rental.bo.Comment;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.ContractHour;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.CommentDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.PromotionDetailsDAO;

/**
 * Servlet implementation class ContractHourServlet
 */
@WebServlet(name = "contractHour", urlPatterns = { "/contractHour" })
public class ContractHourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractHourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		int id_car = Integer.parseInt(request.getParameter("id_car"));
		HttpSession session = request.getSession();
		int custumerid = (int) session.getAttribute("custumerid");
		
		
		CarDAO carDAO = new CarDAO();
		Car checkCar = carDAO.getCar(id_car);
		
		if(checkCar.getStill_exist() > 0) {
			ContractDAO dao = new ContractDAO();
			ArrayList<Contract> listContractCustumer = dao.getContractCustumer(custumerid);
			
//			ContractDayDAO contractDayDAO = new ContractDayDAO();
			ArrayList<Contract> lisContract = dao.getAllContract();	
			
			if(MethodDAO.checkStatusContract(listContractCustumer,lisContract)) {
				String message = "Hiện bạn đang thuê hoặc chưa trả xe nên không thể tạo hợp đồng !";
				request.setAttribute("message", message);
				response.setContentType("text/html;charset=UTF-8");
				request.setCharacterEncoding("UTF-8");
				//String idStr = request.getParameter("id_car");				
				session.setAttribute("id_car", id_car);				
				PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
				PromotionDAO proDao = new PromotionDAO();				
				ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
				String name = "Giảm Giá : ";
				String vnd = "VNÐ";
				String giatheongay = "Giá Theo Ngày ||  ";
				String giatheogio = "Giá Theo Giờ || ";
				MethodDAO methodDAO = new MethodDAO();
				for(PromotionDetails details : lisPromotionDetails) {
					if(details.getId_car() == id_car) {
						Promotion promotion = proDao.getPromotion(details.getIdpromotion());
						request.setAttribute("promotion", promotion);
						String giabandau = "Giá Ban Ðầu : ";
						String giagiam = "Giá Sau Khi Giảm : ";
						String vndsale = "VNÐ";
						String giatheongaysale = "Giá Theo Ngày : ";
						String giatheogiosale = "Giá Theo Giờ : ";
																		
						request.setAttribute("name", name);
						session.setAttribute("id_car", id_car);
						CarDAO cardao = new CarDAO();
						Car car = cardao.getCar(id_car);
						request.setAttribute("car", car);
						
						int price = car.getPrice();
						int pricehour = car.getPricehour();
						
						request.setAttribute("giabandau", giabandau);
						request.setAttribute("price", price);
						request.setAttribute("pricehour", pricehour);
						request.setAttribute("vndsale", vndsale);
						request.setAttribute("giatheongaysale", giatheongaysale);
						request.setAttribute("giatheogiosale", giatheogiosale);
						String title = promotion.getTitile();
						
						int priceSaleOff = methodDAO.moneySaleOff(title, price);
						int pricehourSaleOff = methodDAO.moneySaleOff(title, pricehour);
						
						request.setAttribute("giagiam", giagiam);
						request.setAttribute("priceSaleOff", priceSaleOff);
						request.setAttribute("pricehourSaleOff", pricehourSaleOff);
						
						session.setAttribute("priceSaleOff", priceSaleOff);
						session.setAttribute("pricehourSaleOff", pricehourSaleOff);
						
						
						
						CommentDAO cDao = new CommentDAO();
						ArrayList<Comment> listComment = cDao.getCommentById(id_car);
						request.setAttribute("listComment", listComment);
						
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
						dispatcher.forward(request, response);
						return;
					}
				}		
				CarDAO cardao = new CarDAO();
				Car car = cardao.getCar(id_car);
				session.setAttribute("quantity", car.getQuantity());
				request.setAttribute("car", car);
				int  pricebt = car.getPrice();
				int  pricehourbt = car.getPricehour();
				
				request.setAttribute("vnd", vnd);
				request.setAttribute("pricebt", pricebt);
				request.setAttribute("pricehourbt", pricehourbt);
				request.setAttribute("giatheongay", giatheongay);
				request.setAttribute("giatheogio", giatheogio);			
				
				CommentDAO cDao = new CommentDAO();
				ArrayList<Comment> listComment = cDao.getCommentById(id_car);
				request.setAttribute("listComment", listComment);
				
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
				dispatcher.forward(request, response);	
			}else {
				CarDAO cardao = new CarDAO();
				PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
				PromotionDAO proDao = new PromotionDAO();				
				ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
				MethodDAO methodDAO = new MethodDAO();
				for(PromotionDetails details : lisPromotionDetails) {
					if(details.getId_car() == id_car) {
						Promotion promotion = proDao.getPromotion(details.getIdpromotion());
						Car car = cardao.getCar(id_car);
						request.setAttribute("car",car);
						int pricehour = car.getPricehour();				
						String title = promotion.getTitile();
						int priceSaleOff = methodDAO.moneySaleOff(title, pricehour);			
						request.setAttribute("priceSaleOff", priceSaleOff);			
						
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
						dispatcher.forward(request, response);
						return;
					}
				}
				Car car = cardao.getCar(id_car);
				request.setAttribute("car",car);
				int pricehour = car.getPricehour();
				request.setAttribute("pricehour", pricehour);		
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
				dispatcher.forward(request, response);	
			}		
		}else {
			String message = "Hiện tại xe đã được thuê hết quý khách vui lòng chon xe khác để thuê !";
			request.setAttribute("message", message);
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");
			//String idStr = request.getParameter("id_car");				
			session.setAttribute("id_car", id_car);				
			PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
			PromotionDAO proDao = new PromotionDAO();				
			ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
			String name = "Giảm Giá : ";
			String vnd = "VNÐ";
			String giatheongay = "Giá Theo Ngày ||  ";
			String giatheogio = "Giá Theo Giờ || ";
			MethodDAO methodDAO = new MethodDAO();
			for(PromotionDetails details : lisPromotionDetails) {
				if(details.getId_car() == id_car) {
					Promotion promotion = proDao.getPromotion(details.getIdpromotion());
					request.setAttribute("promotion", promotion);
					String giabandau = "Giá Ban Ðầu : ";
					String giagiam = "Giá Sau Khi Giảm : ";
					String vndsale = "VNÐ";
					String giatheongaysale = "Giá Theo Ngày : ";
					String giatheogiosale = "Giá Theo Giờ : ";
																	
					request.setAttribute("name", name);
					session.setAttribute("id_car", id_car);
					CarDAO cardao = new CarDAO();
					Car car = cardao.getCar(id_car);
					request.setAttribute("car", car);
					
					int price = car.getPrice();
					int pricehour = car.getPricehour();
					
					request.setAttribute("giabandau", giabandau);
					request.setAttribute("price", price);
					request.setAttribute("pricehour", pricehour);
					request.setAttribute("vndsale", vndsale);
					request.setAttribute("giatheongaysale", giatheongaysale);
					request.setAttribute("giatheogiosale", giatheogiosale);
					String title = promotion.getTitile();
					
					int priceSaleOff = methodDAO.moneySaleOff(title, price);
					int pricehourSaleOff = methodDAO.moneySaleOff(title, pricehour);
					
					request.setAttribute("giagiam", giagiam);
					request.setAttribute("priceSaleOff", priceSaleOff);
					request.setAttribute("pricehourSaleOff", pricehourSaleOff);
					
					session.setAttribute("priceSaleOff", priceSaleOff);
					session.setAttribute("pricehourSaleOff", pricehourSaleOff);
					
					
					
					CommentDAO cDao = new CommentDAO();
					ArrayList<Comment> listComment = cDao.getCommentById(id_car);
					request.setAttribute("listComment", listComment);
					
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}		
			CarDAO cardao = new CarDAO();
			Car car = cardao.getCar(id_car);
			session.setAttribute("quantity", car.getQuantity());
			request.setAttribute("car", car);
			int  pricebt = car.getPrice();
			int  pricehourbt = car.getPricehour();
			
			request.setAttribute("vnd", vnd);
			request.setAttribute("pricebt", pricebt);
			request.setAttribute("pricehourbt", pricehourbt);
			request.setAttribute("giatheongay", giatheongay);
			request.setAttribute("giatheogio", giatheogio);			
			
			CommentDAO cDao = new CommentDAO();
			ArrayList<Comment> listComment = cDao.getCommentById(id_car);
			request.setAttribute("listComment", listComment);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/listCarId.jsp");
			dispatcher.forward(request, response);	
		}
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		String status = "newRent";
		HttpSession session = request.getSession();
		int custumerid = (int) session.getAttribute("custumerid");
		int id_car = (int) session.getAttribute("id_car");
		String email = (String) session.getAttribute("email");
		String address = request.getParameter("address");
		String datehire = request.getParameter("date");
		String priceStr = request.getParameter("pricehour");
		int price = Integer.parseInt(priceStr);
		int hourhire = Integer.parseInt(request.getParameter("hourhire"));
		int minutehire = Integer.parseInt(request.getParameter("minutehire"));
		int payhour = Integer.parseInt(request.getParameter("hourpay"));
		int minutepay = Integer.parseInt(request.getParameter("minutepay"));
		String totalhourStr = request.getParameter("totalhour");
		String totalMinuteStr = request.getParameter("totalMinute");
		int totalhour = Integer.parseInt(totalhourStr);
		int totalminute = Integer.parseInt(totalMinuteStr);		
		try {
			Date date = MethodDAO.StringToDateHour(datehire);		
			String hireday = new SimpleDateFormat("yyyy/MM/dd").format(date);
			
			if(MethodDAO.checkday(hireday)) {
				String message = "Ngày Thuê Không đúng vui lòng nhập lại";
				request.setAttribute("mess", message);
				CarDAO cardao = new CarDAO();
				PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
				PromotionDAO proDao = new PromotionDAO();				
				ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
				MethodDAO methodDAO = new MethodDAO();
				for(PromotionDetails details : lisPromotionDetails) {
					if(details.getId_car() == id_car) {
						Promotion promotion = proDao.getPromotion(details.getIdpromotion());
						Car car = cardao.getCar(id_car);
						request.setAttribute("car",car);
						int pricehour = car.getPricehour();				
						String title = promotion.getTitile();
						int priceSaleOff = methodDAO.moneySaleOff(title, pricehour);			
						request.setAttribute("priceSaleOff", priceSaleOff);			
						
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
						dispatcher.forward(request, response);
						return;
					}
				}
				Car car = cardao.getCar(id_car);
				request.setAttribute("car",car);
				int pricehour = car.getPricehour();
				request.setAttribute("pricehour", pricehour);		
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
				dispatcher.forward(request, response);	
			}else {
				int totalmoney  = MethodDAO.totalMoneyHour(totalhour, totalminute, price);
				if(totalmoney > 0) {
					if(address.equals("ofyou")) {
						String addressOfyou = (String) session.getAttribute("address");
						String nameSpeciesContract = "ContractHOUR";
						ContractHour contractHour = new ContractHour();
						contractHour.setCustumerid(custumerid);
						contractHour.setId_car(id_car);
						contractHour.setEmail(email);
						contractHour.setAdressDelivery(addressOfyou);
						contractHour.setQuantity(1);
						contractHour.setStatus(status);
						contractHour.setDayhire(hireday);
						contractHour.setTimehire(hireday + " "+hourhire +":" +minutehire);
						contractHour.setPaytime(hireday + " "+payhour+ ":" +minutepay);
						contractHour.setTotaltime(hireday +" "+totalhourStr + ":" + totalMinuteStr);
						contractHour.setNameSpecies(nameSpeciesContract);
						contractHour.setTotalMoney(totalmoney);
						request.setAttribute("contractHour", contractHour);
						session = request.getSession();
						session.setAttribute("contractHour",contractHour);
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthourResult.jsp");
						dispatcher.forward(request, response);	
					}else {																	
						String nameSpeciesContract = "ContractHOUR";
						ContractHour contractHour = new ContractHour();
						contractHour.setCustumerid(custumerid);
						contractHour.setId_car(id_car);
						contractHour.setEmail(email);
						//contractHour.setAdressDelivery(addressOfyou);
						contractHour.setQuantity(1);
						contractHour.setStatus(status);
						contractHour.setDayhire(hireday);
						contractHour.setTimehire(hireday + " "+hourhire +":" +minutehire);
						contractHour.setPaytime(hireday + " "+payhour+ ":" +minutepay);
						contractHour.setTotaltime(hireday +" "+totalhourStr + ":" + totalMinuteStr);
						contractHour.setNameSpecies(nameSpeciesContract);
						contractHour.setTotalMoney(totalmoney);
						request.setAttribute("contractHour", contractHour);
						session = request.getSession();
						session.setAttribute("contractHour",contractHour);
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/OtherContractHour.jsp");
						dispatcher.forward(request, response);	
					}
				}else {
					String message = "Giờ Thuê Giờ Trả Không Đúng";
					request.setAttribute("mess", message);
					CarDAO cardao = new CarDAO();
					PromotionDetailsDAO proDetailsDAO = new PromotionDetailsDAO();
					PromotionDAO proDao = new PromotionDAO();				
					ArrayList<PromotionDetails> lisPromotionDetails = proDetailsDAO.getAllPromotionDetails();
					MethodDAO methodDAO = new MethodDAO();
					for(PromotionDetails details : lisPromotionDetails) {
						if(details.getId_car() == id_car) {
							Promotion promotion = proDao.getPromotion(details.getIdpromotion());
							Car car = cardao.getCar(id_car);
							request.setAttribute("car",car);
							int pricehour = car.getPricehour();				
							String title = promotion.getTitile();
							int priceSaleOff = methodDAO.moneySaleOff(title, pricehour);			
							request.setAttribute("priceSaleOff", priceSaleOff);			
							
							RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
							dispatcher.forward(request, response);
							return;
						}
					}
					Car car = cardao.getCar(id_car);
					request.setAttribute("car",car);
					int pricehour = car.getPricehour();
					request.setAttribute("pricehour", pricehour);		
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contracthour.jsp");
					dispatcher.forward(request, response);	
				}			
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	}
