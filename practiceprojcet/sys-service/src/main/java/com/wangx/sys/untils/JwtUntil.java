package com.wangx.sys.untils;

import com.wangx.entities.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangxu
 * @date: 2020/3/19 15:35
 */
//todo:这个位置我们将来整合SpringCloud时会加一个注解
//@RefreshScope:作用就是配置文件热部署,就是当我配置文件里jwt.key这个值变了以后,不需要重启,直接就可以生效
@Slf4j
@Component
public class JwtUntil {

    //获取配置配置文件中的key值
    private static String SECRET_KEY;
    private static final String CLAIM_KEY_USER_ID = "sub";
    private static final String CLAIM_KEY_CREATED = "created";

    /**
     * 这个位置要注意下:
     * 为什么要写这个方法?
     * 我们下面如果想写一个静态方法的工具类,这个方法里面只能用静态变量
     * 这里我们想通过@Value获取到配置文件里面秘钥变量.但是@Value的限制是:
     * 如果是final、static修饰的变量获取不到值,并且这个类必须在容器里面(@Component修饰的类)
     * 所以我们只能使用set方法初始化这个值.
     * 而且这里面要注意一点@Value标注在方法和变量上会在程序启动时进行赋值或是调用该方法.
     */
    //初试化配置文件里面的秘钥
    @Value("${jwt.key}")
    public void setSecretKey(String secretKey) {
        SECRET_KEY = secretKey;
    }

    //获取配置文件中的秘钥
    public static String generateToken(SysUser sysUser) {
        Map<String, Object> claims = new HashMap<String, Object>();
        //在jwt中标准声明
        claims.put(CLAIM_KEY_USER_ID, sysUser.getId());
        //这里面一个问题->如果存时间,Token解析返回来的应该是毫秒,想要计算成时间需要另行处理.
        claims.put(CLAIM_KEY_CREATED, new Date());
        //开会创建token
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY);
        return jwtBuilder.compact();
    }

    //解析token
    public static Claims getTokenInfo(String token, String key) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

}
