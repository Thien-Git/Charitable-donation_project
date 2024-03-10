package com.thiennh.springcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.dto.UserDonationQuickDTO;
import com.thiennh.springcrud.service.DonationService;
import com.thiennh.springcrud.service.UserDonationService;
import com.thiennh.springcrud.service.UserService;

@Controller
@RequestMapping("/user-donation")
public class UserDonationController {

	@Autowired
	private DonationService donationService;
	private UserService userService;
	private UserDonationService userDonationService;

	@Autowired
	public UserDonationController(DonationService donationService, UserService userService,
			UserDonationService userDonationService) {
		this.donationService = donationService;
		this.userService = userService;
		this.userDonationService = userDonationService;
	}

	
//	5.3.3. Thực hiện quyên góp nhanh mà không cần xem chi tiết thông tin đợt quyên góp
//	6.2.Thực hiện quyên góp khi xem thông chi tiết của một đợt quyên góp (dành cho người dùng hệ thống)
	
//	Dùng modal ko cần truyền model vào, tự nó map cái đối tượng trả ra controller (hay)
	@PostMapping("/quick-donation")
	public String donationFast(@ModelAttribute("UserDonationQuickDTO") UserDonationQuickDTO userDonationQuickDTO, Model model) {

		
		String name = userDonationQuickDTO.getName();
		Integer money = userDonationQuickDTO.getMoney();
		String text = userDonationQuickDTO.getText();
		String created = userDonationQuickDTO.getCreated();
		Integer status = userDonationQuickDTO.getStatus();

//			lấy user hiện tại: bằng idUser từ session hiện tại
		Integer idUser = userDonationQuickDTO.getIdUser();
		UserDTO userDTO = userService.getUserDTOById(idUser);

//			Lấy donation hiện tại: bằng idDonation
		Integer idDonation = userDonationQuickDTO.getIdDonation();
		DonationDTO donationDTO = donationService.getDonationDTOById(idDonation);

//			Đưa thông tin vào bảng UserDonationEntity (đủ trường)
		userDonationService.addUserQuickDonation(name, money, text, created, status, userDTO, donationDTO);

//			load lại trang chủ, thông báo thành công
		
		// Truyền thông điệp thành công tới trang web
        model.addAttribute("msg", "Donate Successfully!"); //lấy ra view ntn đây???
        
//        chuyển sang phương thức xử lý sau khi nhấn quyên góp nhanh
		return "redirect:/user/homeAfterDonationSuccess";
//		return "redirect:/user/home";
		
		
		
//			Sau khi người dùng nhập vào form quyên góp nhanh thì Controller sẽ nhận được
//			idUser => lấy thông tin user và idDonation + những data khác trong ô input +null nếu ko nhập
//			Mục tiêu: lưu các kết quả vào bảng trung gian user_donation

//			UserDonationQuickDTO:
//			private String name; => tên mục quyên góp
//			private Integer money;
//			private String text;
//			private String created; => ngày quyên góp
//			private Integer status;
//			private Integer idUser; => tao user object
//			private Integer idDonation; => tao donation object

//			UserDonationEntity (cần tạo)
//			private Integer id;
//			private String name;
//			private Integer money;
//			private String text;
//			private String created;
//			private Integer status;
//			private UserEntity user;
//			private DonationEntity donation;

	

	}
	
	
//	6.1. Xác nhận/hủy xác nhận với việc nhận được tiền từ nhà quyên góp theo cách làm thủ công (dành cho người quản lý hệ thống)
//	Status của người quên góp = 0 (chưa xác nhận), = 1(được xác nhận)
	
	@GetMapping("/confirmation")
	public String confirmation(@RequestParam("idUserDonation") Integer idUserDonation, 
								@RequestParam("idDonation") Integer idDonation, Model model) {
		System.out.println(idUserDonation);// dùng cập nhật status trong bảng user_donation
		System.out.println(idDonation); //dùng để cập nhật status trong bảng donation
		
//		Cập nhật lại status của bản ghi đó (update..status..where id = .... đưa status về 1 là đã xác nhận (status ở bảng user_donation)
		userDonationService.updateStatusOfUserDonation(idUserDonation);
		
		
//		Cập nhật status của donation (hiển thị sang đang quyên góp)
		donationService.updateStatusDonationToDangQuyenGop(idDonation);
		
		String idDonationString = String.valueOf(idDonation);
		
//		Load lại trang đó http://localhost:8080/Asm1-122023-1/admin/donation/detail?idDonation=3
		// Truyền thông điệp thành công tới trang web
        model.addAttribute("msg", "Hành động đã được thực hiện thành công!");
        
		return "redirect:/admin/donation/detail?idDonation=" + idDonationString;
	}
}




























