package com.learn.jwtlearn.jwtTest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.HashMap;
import java.util.Map;

/**
 * jwt 小demo
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String token = createToken();
        System.out.println("Token : "+token);
        //
        //secret : 公用密钥 -- 保存在服务端,客户不知道密钥,防止被攻击
        String value = verifyToken(token,"secret","name");
        System.out.println("Value : "+value);
    }
    public static String createToken() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)    //header
                .withClaim("name", "ws")    //payload
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("secret"));//加密
        return token;
    }
    public static String verifyToken(String token,String secret,String key) throws Exception{

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        return claims.get(key).asString();
    }

}