package dev.potatoo.projectlist.controller;

import javax.servlet.http.HttpServletRequest;

import dev.potatoo.projectlist.jwt.PotatooVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.potatoo.projectlist.dto.UserDTO;
import dev.potatoo.projectlist.service.MainService;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MainController {
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

	@ResponseBody
	@RequestMapping("/loginCheck")
	public PotatooVo loginCheck(@RequestBody Map<String,Object> map) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserID((String)map.get("userID"));
		userDTO.setUserPW((String)map.get("userPW"));

		System.out.println(userDTO);

		return mainService.loginCheck(userDTO);
	}

}
