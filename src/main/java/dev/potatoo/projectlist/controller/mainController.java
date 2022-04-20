package dev.potatoo.projectlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.potatoo.projectlist.dto.UserDTO;
import dev.potatoo.projectlist.service.MainService;

@Controller
public class mainController {
	@Autowired
	MainService mainService;
	
	
	@RequestMapping("/")
	public String main() {
		return "main_page";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/loginCheck")
	public String loginCheck(HttpServletRequest request, @ModelAttribute UserDTO userDTO) {
		HttpSession session = request.getSession();
		
		String test = mainService.loginCheck(userDTO);
		
		System.out.println("test : " + test);
		
		
		return "introduce";
	}
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce";
	}
	
	
	
	
	
	
}
