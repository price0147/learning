package com.wangx.sys.until;

import com.wangx.entities.SysUser;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/19 15:35
 */
@Slf4j
public class JwtUntil {
    //这个是加密算法的秘钥一会还有修改,最后将秘钥存到配置文件中去.
    private static final String SECRET_KEY = "wangx";

    private static final String CLAIM_KEY_USER_ID = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    public String generateToken(SysUser sysUser){
        Map<String,Object> claims = new HashMap<String, Object>();
        //在jwt中标准声明
        claims.put(CLAIM_KEY_USER_ID, sysUser.getId());
        claims.put(CLAIM_KEY_CREATED,new Date());
        //开会创建token
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,SECRET_KEY);
        return jwtBuilder.compact();
    }
}
