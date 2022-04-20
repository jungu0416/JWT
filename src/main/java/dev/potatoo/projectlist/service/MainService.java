package dev.potatoo.projectlist.service;

import org.springframework.stereotype.Service;

import dev.potatoo.projectlist.dto.UserDTO;
import dev.potatoo.projectlist.mapper.MainMapper;

@Service
public class MainService {
	MainMapper mainMapper;
	
	//생성자
	public MainService(MainMapper mainMapper) {
		this.mainMapper = mainMapper;
	}
	
	public String loginCheck(UserDTO dto) {
		return mainMapper.loginCheck(dto);
	}
	
	
	
}
