package com.ute.rental.servlet.user;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ute.rental.bo.Bill;
import com.ute.rental.bo.Car;
import com.ute.rental.bo.Comment;
import com.ute.rental.bo.Contract;
import com.ute.rental.bo.Contractday;
import com.ute.rental.bo.ManufacturerCar;
import com.ute.rental.bo.Promotion;
import com.ute.rental.bo.PromotionDetails;
import com.ute.rental.bo.SpeciesCar;
import com.ute.rental.bo.SpeciesContract;
import com.ute.rental.dao.CarDAO;
import com.ute.rental.dao.CommentDAO;
import com.ute.rental.dao.ContractDAO;
import com.ute.rental.dao.ContractDayDAO;
import com.ute.rental.dao.ManufacturerDAO;
import com.ute.rental.dao.MethodDAO;
import com.ute.rental.dao.PromotionDAO;
import com.ute.rental.dao.PromotionDetailsDAO;
import com.ute.rental.dao.SpeciesCarDAO;

/**
 * Servlet implementation class ContractDayServlet
 */
@WebServlet(name = "contractDay", urlPatterns = { "/contractDay" })
public class ContractDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContractDayServlet() {
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
		
		ContractDAO dao = new ContractDAO();
		ArrayList<Contract> listContractCustumer = dao.getContractCustumer(custumerid);
		
		ContractDayDAO contractDayDAO = new ContractDayDAO();
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
					
					SpeciesCarDAO spcDao = new SpeciesCarDAO();
					SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
					request.setAttribute("speciesCar", speciesCar);
					
					ManufacturerDAO maDao = new ManufacturerDAO();
					ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
					request.setAttribute("maCar", maCar);
					
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
			
			SpeciesCarDAO spcDao = new SpeciesCarDAO();
			SpeciesCar speciesCar = spcDao.getSpecies(car.getSpeciesID());
			request.setAttribute("speciesCar", speciesCar);
			
			ManufacturerDAO maDao = new ManufacturerDAO();
			ManufacturerCar maCar = maDao.getManufac(car.getManufacID());
			request.setAttribute("maCar", maCar);
			
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
					int price = car.getPrice();				
					String title = promotion.getTitile();
					int priceSaleOff = methodDAO.moneySaleOff(title, price);			
					request.setAttribute("priceSaleOff", priceSaleOff);			
					
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contractday.jsp");
					dispatcher.forward(request, response);
					return;
				}
			}
			Car car = cardao.getCar(id_car);
			request.setAttribute("car",car);
			int pricept = car.getPrice();
			request.setAttribute("pricept", pricept);		
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contractday.jsp");
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
		//String address = (String) session.getAttribute("address");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		int totalday =Integer.parseInt(request.getParameter("days"));
		int toltalmoney =Integer.parseInt(request.getParameter("total"));
		int prepay = Integer.parseInt(request.getParameter("prepay"));
		if(toltalmoney <=  0) {			
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("UTF-8");			
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
		try {
				Date date = MethodDAO.StringToDate(from);		
				Date date1 = MethodDAO.StringToDate(to);				
				String hireday = new SimpleDateFormat("yyyy/MM/dd").format(date);
				String payday = new SimpleDateFormat("yyyy/MM/dd").format(date1);
				if(MethodDAO.checkday(hireday)) {
					response.setContentType("text/html;charset=UTF-8");
					request.setCharacterEncoding("UTF-8");	
					//int id_car = Integer.parseInt(request.getParameter("id_car"));
					String mess = "Ngày thuê không đúng vui lòng nhập lại";
					request.setAttribute("mess", mess);
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
							int price = car.getPrice();				
							String title = promotion.getTitile();
							int priceSaleOff = methodDAO.moneySaleOff(title, price);			
							request.setAttribute("priceSaleOff", priceSaleOff);			
							
							RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contractday.jsp");
							dispatcher.forward(request, response);
							break;
						}
					}
					Car car = cardao.getCar(id_car);
					request.setAttribute("car",car);
					int pricept = car.getPrice();
					request.setAttribute("pricept", pricept);		
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/contractday.jsp");
					dispatcher.forward(request, response);
				}else {
					if(address.equals("ofyou")) {
						String addressOfyou = (String) session.getAttribute("address");
						String nameSpeciesContract = "ContractDAY";
						Contractday contractday = new Contractday();
						contractday.setCustumerid(custumerid);
						contractday.setId_car(id_car);
						contractday.setEmail(email);
						contractday.setAdressDelivery(addressOfyou);
						contractday.setQuantity(1);
						contractday.setDeposit(prepay);
						contractday.setStatus(status);			
						contractday.setDayhire(hireday + " " + MethodDAO.TimeHientai());
						contractday.setPayday(payday + " " + MethodDAO.TimeHientai());
						contractday.setTotalday(totalday);
						contractday.setTotalMoney(toltalmoney);
						contractday.setNameSpecies(nameSpeciesContract);
						
						String result = "Đăng Ký Thành Công";
						request.setAttribute("result", result);
						ContractDayDAO contractDayDAO = new ContractDayDAO();
								
						
						contractDayDAO.AddContractDay(contractday);
							
						RequestDispatcher dispatcher =
										this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/ResultSuccess.jsp");
						dispatcher.forward(request, response);	
					}else {
						String nameSpeciesContract = "ContractDAY";
						Contractday contractday = new Contractday();
						contractday.setCustumerid(custumerid);
						contractday.setId_car(id_car);
						contractday.setEmail(email);
						//contractday.setAdressDelivery(address);
						contractday.setQuantity(1);
						contractday.setDeposit(prepay);
						contractday.setStatus(status);			
						contractday.setDayhire(hireday + " " + MethodDAO.TimeHientai());
						contractday.setPayday(payday + " " + MethodDAO.TimeHientai());
						contractday.setTotalday(totalday);
						contractday.setTotalMoney(toltalmoney);
						contractday.setNameSpecies(nameSpeciesContract);
						
						session.setAttribute("contractday", contractday);
						RequestDispatcher dispatcher =
								this.getServletContext().getRequestDispatcher("/WEB-INF/view/user/OtherContractDay.jsp");
						dispatcher.forward(request, response);	
					}
					
				}				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		}		
	}
