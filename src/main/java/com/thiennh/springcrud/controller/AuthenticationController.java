package com.thiennh.springcrud.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.thiennh.springcrud.dto.UserLoginDTO;
import com.thiennh.springcrud.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	private UserService userService;

	@Autowired

	public AuthenticationController(UserService userService) {
		this.userService = userService;
	}

//	Hiện form để đăng nhập
	@GetMapping("/user/login")
	public String login(Model model) {
		return "templates/admin/login";
	}

//	Xử lý đăng nhập
	@PostMapping("/user/process-login")
	public String processLogin(HttpServletRequest request, Model model) {
		
//		Lấy dữ liệu được nhập
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Lấy đối tượng user từ DB bằng email vs password (SELECT * FROM... WHERE email = ... AND password = ....)
		UserLoginDTO user =  userService.getUserCheckLogin(email, password);
		
//		private Integer id;
//		private String fullName;
//		private String email;
//		private String password;
//		private Integer roleId;
//		private Integer status; để check bị khóa không

		// Kiểm tra thông tin đăng nhập (nếu user khác null là có tồn tại trong DB)
//		status để kiểm tra người dùng có bị khóa không
		if (user != null && user.getStatus() == 1) {
			// Nếu đăng nhập thành công, tạo session và đặt giá trị vào session
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			
//			Kiểm tra người đăng nhập là admin hay user bằng cách kiểm tra roleId
			if(user.getRoleId()== 1) {
				//	Người đăng nhập là admin, chuyển hướng sang trang home admin
				return "redirect:/admin/home";
				
//				return "templates/test/testLayDataTuSession";
			} else {
				//	Người đăng nhập là người dùng, chuyển hướng sang trang home user
				return "redirect:/user/home";
			}
		} else {
			// Nếu đăng nhập không thành công, hiển thị lại trang đăng nhập với thông báo lỗi
			model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
			return "templates/admin/login";
		}

	}
	
	
//	Đăng xuất (logout) dành cho người dùng
	@GetMapping("/user/logout") // Người dùng là user
	public String userLogout(HttpServletRequest request) {
		// Lấy đối tượng HttpSession từ HttpServletRequest
        HttpSession session = request.getSession(false);

        // Kiểm tra xem session có tồn tại không
        if (session != null) {
            // Xóa hết dữ liệu trong session
            session.invalidate();
        }

        // Chuyển hướng người dùng đến trang đăng nhập (nếu là admin)
        // hoặc trang chính (nếu là user)
		return "redirect:/user/home";
	}
	
	// Đăng xuất_Người dùng là admin
	@GetMapping("/admin/logout") 
	public String adminLogout(HttpServletRequest request) {
		// Lấy đối tượng HttpSession từ HttpServletRequest
        HttpSession session = request.getSession(false);

        // Kiểm tra xem session có tồn tại không
        if (session != null) {
            // Xóa hết dữ liệu trong session
            session.invalidate();
        }

        // Chuyển hướng người dùng đến trang đăng nhập (nếu là admin)
        // hoặc trang chính (nếu là user)
		
        return "templates/admin/login";
	}
}
