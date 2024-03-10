package com.thiennh.springcrud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thiennh.springcrud.dto.RoleDTO;
import com.thiennh.springcrud.dto.UserUpdateDTO;
import com.thiennh.springcrud.service.RoleService;
import com.thiennh.springcrud.service.UserService;

@RequestMapping("/ql-user")
@Controller
public class QLUserController {

	@Autowired
	private UserService userService;
	private RoleService roleService;

	@Autowired
	public QLUserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	
//	5.1.4. Cho phép/không cho phép một người dùng sử dụng hệ thống(Khóa) (set status = 0)

	@PostMapping("/lock")
	public String lockUser(@RequestParam("idUser") Integer idUser) {

		userService.updateStatusToLock(idUser);

		return "redirect:/admin/account/list";
	}
//	5.1.4. Cho phép/không cho phép một người dùng sử dụng hệ thống(Mở khóa) (set status = 1)
	
	@PostMapping("/un-lock")
	public String unLockUser(@RequestParam("idUser") Integer idUser) {

		userService.updateStatusToUnLock(idUser);

		return "redirect:/admin/account/list";
	}
	
	
//	5.1.5. Xóa một người dùng

	@PostMapping("/delete")
	public String deleteUser(@RequestParam("idUser") Integer idUser) {

		userService.deleteUser(idUser);

		return "redirect:/admin/account/list";
	}

	
//	Hiện form + data để sửa đổi (cập nhật người dùng)
	
	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("idUser") Integer idUser, Model model) {

		UserUpdateDTO userNeedUpdate = userService.getUserById(idUser);

		model.addAttribute("userNeedUpdate", userNeedUpdate);

		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		roles = roleService.getRoles();
		model.addAttribute("roles", roles);

		return "templates/form/form-update-user";
	}
	

//	5.1.6. Cập nhật thông tin người dùng (xử lý)
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("userNeedUpdate") UserUpdateDTO userNeedUpdate) {
		userService.updateUser(userNeedUpdate);
		return "redirect:/admin/account/list";
	}

}
