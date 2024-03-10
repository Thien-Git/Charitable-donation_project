package com.thiennh.springcrud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiennh.springcrud.dto.DonationCategoryDTO;
import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.DonationDetailDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;
import com.thiennh.springcrud.service.DonationService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private DonationService donationService;
	

	@Autowired
	public UserController(DonationService donationService) {
		this.donationService = donationService;
	}
	
	
	
//	5.3.1. Hiển thị danh sách của các đợt quyên góp (trang chủ của người dùng) sau khi người dùng thực hiện quyên góp nhanh
//	+ Phân trang chủ home (người dùng)
	
	@GetMapping("/homeAfterDonationSuccess")
	public String homeAfterDonationSuccess (@RequestParam(defaultValue = "0") Integer page, 
											@RequestParam("msg") String msg, Model model) {
		
		Integer currentPage = page; // Lấy ra page ở @RequestParam = 0???
//		System.out.println("currentPage: "+ currentPage);
		Integer pageSize = 5;// Số lượng mục trên mỗi trang
		
		if(msg != null ) { //nếu có msg
			
			List<DonationDTO> donationDTOs = donationService.getListDonationHavePagination(page, pageSize);

			model.addAttribute("donationCategoryDTOs", donationDTOs);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("msg", msg);
			
			System.out.println("msg: " + msg);
			return "templates/public/home"; 
		} else {
			return "redirect:/user/home"; 
		}
	}
	
//	@GetMapping("/homeAfterDonationSuccess")
//	public String homeAfterDonationSuccess (HttpServletRequest request, 
//											@RequestParam(defaultValue = "0") Integer page, 
//											@RequestParam("msg") String msg, Model model) {
//		
//		String currentUrl = request.getSession().getAttribute("currentUrl").toString();
//		System.out.println("currentUrl: " + currentUrl); // url đang lưu trong session (http://localhost:8080/Asm1-122023-1/user/home?page=1)
//		
//		Integer currentPage = page; // Lấy ra page ở @RequestParam = 0???
//		System.out.println("currentPage: "+ currentPage);
//		Integer pageSize = 5;// Số lượng mục trên mỗi trang
//		
//		if(msg != null ) { //nếu có msg
//			
//			List<DonationDTO> donationDTOs = donationService.getListDonationHavePagination(page, pageSize);
//
//			model.addAttribute("donationCategoryDTOs", donationDTOs);
//			model.addAttribute("currentPage", currentPage);
//			model.addAttribute("msg", msg);
//			
//			System.out.println("msg: " + msg);
//			
//			return "redirect:" + currentUrl; //sao truyền được model msg vào view???
//			// redirect: http://localhost:8080/Asm1-122023-1/user/home?page=1
//		} else {
//			return "redirect:/user/home";  //ko truyền theo model dc
//		}
//	}
	
	
//	5.3.1. Hiển thị danh sách của các đợt quyên góp (trang chủ của người dùng)
//	+ Phân trang chủ home (người dùng)
	
	@GetMapping("/home")
	public String home1(Model model, @RequestParam(defaultValue = "0") Integer page) {
		Integer currentPage = page; // vì th:href="@{/user/home(page=${currentPage+1})}"
		Integer pageSize = 5;// Số lượng mục trên mỗi trang
		
		if(page < 0) {
			page = 0;
			return "redirect:/user/home"; 
		} else {
			
			List<DonationDTO> donationDTOs = donationService.getListDonationHavePagination(page, pageSize);

			model.addAttribute("donationCategoryDTOs", donationDTOs);
			
			model.addAttribute("currentPage", currentPage);
			
			return "templates/public/home"; 
	
		}
	}
	
	
//	5.3.2. Xem chi tiết thông tin của một đợt quyên góp (ở trang của người dùng)
	
	@GetMapping("/detail{idDonation}")
	public String detailDonation(@RequestParam("idDonation") Integer idDonation, Model model) {

//		Lấy Donation (đợt quyên góp) bằng id
		DonationDetailDTO donationDetailDTO = donationService.getDonationDetail(idDonation);
		
//		Lấy danh sách người quyên góp tương ứng với donation bằng idDonation
		List<UserDonationDTO> userDonationDTOs = donationService.getListUserDonation(idDonation);

		// Tinh tong tien
//		Kiểm tra status của người quyên góp trong bảng trung gian nếu = 0 thì không tính vào, = 1 thì tính vào
		Integer totalMoney = 0;
		for (int i = 0; i < userDonationDTOs.size(); i++) {
			if(userDonationDTOs.get(i).getStatus() ==  1) {
				totalMoney += userDonationDTOs.get(i).getMoney();
			}
		}

//		Lưu vào model
		model.addAttribute("donationDetailDTO", donationDetailDTO);
		model.addAttribute("userDonationDTOs", userDonationDTOs);
		model.addAttribute("totalMoney", totalMoney);

//		đưa ra view
		return "templates/public/detail";
	}
	
	
	
	
//	5.3.1. Hiển thị danh sách của các đợt quyên góp (trang chủ của người dùng)-mentor ko dùng dc (lỗi session)
//	+ Phân trang chủ home (người dùng)
//	@GetMapping("/home")
//	public String home1(HttpServletRequest request, Model model, @RequestParam(defaultValue = "0") Integer page) {
//		Integer currentPage = page; // vì th:href="@{/user/home(page=${currentPage+1})}"
//		Integer pageSize = 5;// Số lượng mục trên mỗi trang
//		
//		HttpSession session = request.getSession(false);
//		currentUrl = request.getRequestURL().toString();  
//		System.out.println(currentUrl); //http://localhost:8080/Asm1-122023-1/user/home
//        
//		String msg = request.getParameter("msg"); //lấy ra ??? null
//		System.out.println(msg); //null
//		
//		currentUrl = currentUrl + "?page=" + page; //?page=0
//		System.out.println(currentUrl); // http://localhost:8080/Asm1-122023-1/user/home?page=0
//		model.addAttribute("msg", msg); // đưa vào model msg giá trị null
//
//		session.setAttribute("currentUrl", currentUrl); // lưu url vào session
//		
//		if(page < 0) {
//			page = 0;
//			return "redirect:/user/home"; 
//		} else {
//			
//			List<DonationDTO> donationDTOs = donationService.getListDonationHavePagination(page, pageSize);
//
//			model.addAttribute("donationCategoryDTOs", donationDTOs);
//			
//			model.addAttribute("currentPage", currentPage);
//			
//			return "templates/public/home"; 
//	
//		}
//	}
	
	



	
	


	
}
