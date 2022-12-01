package dev.potatoo.projectlist.jwt;

import lombok.Data;

import java.util.Map;

@Data
public class PotatooVo {
    private String jwt;
    private Map<String,Object> verifyJWT;
}
