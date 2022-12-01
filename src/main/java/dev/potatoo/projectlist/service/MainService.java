package dev.potatoo.projectlist.service;

import dev.potatoo.projectlist.jwt.TESTJWT;
import org.springframework.stereotype.Service;

import dev.potatoo.projectlist.dto.UserDTO;

@Service
public class MainService {
	//MainMapper mainMapper;
	
	//생성자
//	public MainService(MainMapper mainMapper) {
//		this.mainMapper = mainMapper;
//	}
	
	public String loginCheck(UserDTO dto) {

		TESTJWT test = new TESTJWT(dto);

		String jwt = test.createToken();

		System.out.println(jwt);
		System.out.println(test.verifyJWT(jwt));

		return null;
	}
	
	
	
}
