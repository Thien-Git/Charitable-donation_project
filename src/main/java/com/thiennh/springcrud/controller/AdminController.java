package com.thiennh.springcrud.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thiennh.springcrud.dto.RoleDTO;
import com.thiennh.springcrud.dto.UserAddDto;
import com.thiennh.springcrud.dto.UserDTO;
import com.thiennh.springcrud.service.RoleService;
import com.thiennh.springcrud.service.UserService;

@Controller
@RequestMapping("/admin")
@Valid
public class AdminController {
	
	private UserService userService;
	private RoleService roleService;

	public AdminController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	

//	Trang home (trang chính của admin)
	
	@GetMapping("/home") 
	public String homeAdmin(Model model) {
		return "templates/admin/home"; 
	}

	
//	5.1.1. Hiển thị ra danh sách của người dùng
	
	@GetMapping("/account/list")
	public String listAccount(Model model) {
		List<UserDTO> list = userService.getList();
		model.addAttribute("list", list);
		
		return "templates/admin/listAccount";
	}
	
	
//	Hiện form để thêm mới 1 người dùng
	
	@GetMapping("/account/showForm")
	public String tshowFormForAdd(Model model) {
		UserAddDto user = new UserAddDto();
		model.addAttribute("user", user);
		
//		Lấy ra danh sách role => để lựa chọn khi tạo user
		List<RoleDTO> roles = new ArrayList<RoleDTO>();
		roles = roleService.getRoles();
		model.addAttribute("roles",roles);
		
		return "templates/form/form-add-user";
	}
	
	
//	5.1.2. Thêm mới một người dùng (Valid thêm jar file của hibernate-validator-6.2.5.Final-dist)
	
	@PostMapping("/account/addUser")
	public String taddUser(@Valid @ModelAttribute("user") UserAddDto user, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/account/showForm";
		}
		userService.saveUser(user);
		
//		Chuyển hướng về list account
		return "redirect:/admin/account/list";
	}
	
	
	
	
	
	
	
	
}
