package dev.potatoo.projectlist.jwt;

import dev.potatoo.projectlist.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class TESTJWT {
    final String key = "secret";
    private UserDTO dto;


    //토큰 생성
    public String createToken(){

        //Header 부분 설정
        Map<String,Object> headers = new HashMap<>();
        headers.put("typ","JWT");
        headers.put("alg","HS256");

        //payload 부분 설정
        Map<String,Object> payloads = new HashMap<>();
        payloads.put("data","{" +
                "userID --> " + dto.getUserID() +
                "userPW --> " + dto.getUserPW() +
                 "}");

        Long expiredTime = 1000 * 60L * 60L * 1L; // 토큰 유효 시간 (1시간)

        Date ext = new Date(); // 토큰 만료시간
        ext.setTime(ext.getTime() + expiredTime);

        //토큰 Builder
        String jwt = Jwts.builder()
                .setHeader(headers)
                .setClaims(payloads)
                .setSubject("user") //토큰 용도
                .setExpiration(ext) // 토큰 만료시간 설정
                .signWith(SignatureAlgorithm.HS256, key.getBytes()) //HS256과 Key로 Sign
                .compact(); //토큰 생성

        return jwt;
    }

    //토큰 검증
    public Map<String,Object> verifyJWT(String jwt) throws UnsupportedJwtException {
        Map<String,Object> claimMap = null;
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8")) // Set Key
                    .parseClaimsJws(jwt) // 파싱 및 검증 , 실패 시 에러
                    .getBody();

            claimMap = claims;

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }

        return claimMap;
    }




}
