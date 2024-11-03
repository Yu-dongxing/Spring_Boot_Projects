package com.yuxs;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","yuxs");
        //生成JWT代码
        String token = JWT.create()
                    .withClaim("user",claims)//添加信息
                    .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
                    .sign(Algorithm.HMAC256("YUXS"));//添加密
        System.out.println(token);
    }
    @Test
    public void testParse(){
        //定义字符串，模拟token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6Inl1eHMifSwiZXhwIjoxNzMwMzE5ODk5fQ.Z8sEUEHvWJpXF8ArLQHsnTDJzwnqS4UivVFyFTTGs2Y";
        JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256("YUXS")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.printf(String.valueOf(claims.get("user")));
    }
}
