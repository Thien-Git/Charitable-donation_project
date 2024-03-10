package com.thiennh.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiennh.springcrud.dto.DonationDTO;
import com.thiennh.springcrud.dto.DonationDetailDTO;
import com.thiennh.springcrud.dto.DonationUpdateDTO;
import com.thiennh.springcrud.dto.UserDonationDTO;
import com.thiennh.springcrud.service.DonationService;

@Controller
@RequestMapping("/admin")
public class DonationController {
	@Autowired
	private DonationService donationService;

	@Autowired
	public DonationController(DonationService donationService) {
		this.donationService = donationService;
	}


//	5.2.1. Hiển thị ra danh sách của đợt quyên góp
	
	@GetMapping("/donation/list")
	public String listDonation(Model model) {
		List<DonationDTO> list = donationService.getListDonation();
		model.addAttribute("list", list);
		
		return "templates/admin/donation";
	}
	
	
//	Hiện form để thêm mới 1 donation
	
	@GetMapping("/donation/showForm")
	public String showForm(Model model) {
		
//		tạo đôi tượng donationDTO
		DonationDTO donationDTO = new DonationDTO();
		
//		truyen donationDTO vao model
		model.addAttribute("donation", donationDTO);
		
//		tra model vao form
		return "templates/form/form-add-donation";
	}
	
	
//	5.2.2.Thêm mới một đợt quyên góp:
	
	@PostMapping("/donation/addDonation")
	public String addDonation(@ModelAttribute("donation") DonationDTO donationDTO, 
			Model model) {
		
		donationService.saveDonation(donationDTO);
		
//		chuyển hướng về danh sách donation
		return "redirect:/admin/donation/list";
	}
	
	
//	5.2.5. Xóa một đợt quyên góp ở trạng thái ‘mới tạo’
	
	@PostMapping("/donation/delete") //Lấy idDonation truyền từ form ra khớp với name trong form
	public String deleteDonation(@RequestParam("idDonation")Integer id, Model model) {
		donationService.deleteDonation(id);
		
		return "redirect:/admin/donation/list";
	}
	
	
//	Hiện form + thông tin để sửa đổi (update)
	
	@GetMapping("/donation/formUpdate{idDonation}")
	public String formUpdateDonation(@RequestParam(name = "idDonation") Integer id, Model model) {
//		lay thong tin donation tu DB
		DonationUpdateDTO donationUpdateDTO = donationService.getDonationById(id);
		
//		chuyen thong tin vao form
		model.addAttribute("donationUpdateDTO", donationUpdateDTO);
		return "templates/form/form-update-donation";
	}
	
	
//	5.2.6. Cập nhật thông tin của một đợt quyên góp khi chưa ở trạng thái ‘đóng quyên góp’
	
	@PostMapping("/donation/updateDonation")
	public String updateDonation(@ModelAttribute("donationUpdateDTO") DonationUpdateDTO donationUpdateDTO){
		donationService.updateDonation(donationUpdateDTO);
		
		return "redirect:/admin/donation/list";
	}
	
	
//	 5.2.7. Xem chi tiết thông tin của đợt quyên góp (admin sử dụng)
	
	@GetMapping("/donation/detail{idDonation}")
	public String detailDonation(@RequestParam("idDonation") Integer idDonation, Model model) {
		
		DonationDetailDTO donationDetailDTO = donationService.getDonationDetail(idDonation);
		
		List<UserDonationDTO> userDonationDTOs = donationService.getListUserDonation(idDonation);
		
		// Tinh tong tien quyên góp
//		Kiểm tra status của người quyên góp trong bảng trung gian nếu = 0 (chưa xác nhận) thì không tính vào, = 1 thì tính vào
		Integer totalMoney = 0;
		for(int i = 0; i< userDonationDTOs.size(); i++) {
			if(userDonationDTOs.get(i).getStatus() ==  1) {
				totalMoney += userDonationDTOs.get(i).getMoney();
			}
		}
		model.addAttribute("donationDetailDTO", donationDetailDTO); //1 donation
		model.addAttribute("userDonationDTOs", userDonationDTOs); // nhiều người
		model.addAttribute("totalMoney", totalMoney); // tổng tiền
	
//		Chuyển các model qua html để view ra
		return "templates/admin/detail";
	}
	
	
//	Kết thúc đợt quyên góp (Không có trong yêu cầu bài làm)
//	Khi kết thúc sẽ ko hiện nút cập nhật (sửa th:if trong view)
//	Get param chỗ name trong form (khớp tên là lấy dc) 
	
	@PostMapping("/donation/finishDonation")
	public String finishDonation(@RequestParam("idDonation") Integer id) {
		System.out.println(id);
		
//		update status = 2
		donationService.updateStatusDonationToFinish(id);
		
//		Load lại trang
		return "redirect:/admin/donation/list";
	}
	
	@PostMapping("/donation/closeDonation")
	public String closeDonation(@RequestParam("idDonation") Integer id) {
		System.out.println(id);
		
//		update status = 3
		donationService.updateStatusDonationToClose(id);
		
//		Load lại trang
		return "redirect:/admin/donation/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
