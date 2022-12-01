package dev.potatoo.projectlist.service;

import dev.potatoo.projectlist.jwt.PotatooJwt;
import dev.potatoo.projectlist.jwt.PotatooVo;
import org.springframework.stereotype.Service;

import dev.potatoo.projectlist.dto.UserDTO;

import java.util.Map;

@Service
public class MainService {
	
	public PotatooVo loginCheck(UserDTO dto) {

		PotatooJwt potatooJwt = new PotatooJwt(dto);
		PotatooVo vo = new PotatooVo();

		String jwt = potatooJwt.createToken();
		Map<String,Object> verifyJWT = potatooJwt.verifyJWT(jwt);
		System.out.println(jwt);
		System.out.println(verifyJWT);

		vo.setJwt(jwt);
		vo.setVerifyJWT(verifyJWT);

		return vo;
	}
	
	
	
}
