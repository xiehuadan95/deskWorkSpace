package com.xie.jwt;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * Author:Eric
 * DATE:2023/2/21-23:02
 * Decription:
 */
public class JwtTest {
    //一天 1秒过期
    private static long tokenExpiration=1000*60*60*24; //
    private static String tokenSignKey="xieeric123456";
    //得到JWT字符串
    @Test
    public void testCreateToken(){
        JwtBuilder builder = Jwts.builder();
        //头，载荷，签名哈希
        //alg 算法 type 类型
      String jwtToken=  builder.setHeaderParam("alg","HS256").setHeaderParam("typ","JWT")
                //有效载荷部分 的自定义信息
                .claim("name","haha")
                .claim("avatar","head.jpg")
                .claim("role","admin")
                //载荷默认信息 7个
                //.claim("sub","主题用户信息")  有默认方法
                .setSubject("主题1")
                .setIssuer("签发者1")
                .setAudience("接收方1")
                .setIssuedAt(new Date())//令牌的签发时间
                .setExpiration(new Date(System.currentTimeMillis()+tokenExpiration))//令牌过期时间
                .setNotBefore(new Date(System.currentTimeMillis()+1000*20))//这个时间之前令牌不可用 生效时间 20秒后生效
                .setId(UUID.randomUUID().toString())   //唯一身份标识 作为一次性token 回避重放攻击

                //签名哈希
                .signWith(SignatureAlgorithm.HS256,tokenSignKey)
                //组装JWT字符串
                .compact();
        System.out.println(jwtToken);
        /**
         * eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
         * .eyJuYW1lIjoiaGFoYSIsImF2YXRhciI6ImhlYWQuanBnIiwicm9sZSI6ImFkbWluIiwic3ViIjoi5Li76aKYMSIsImlzcyI6IuetvuWPkeiAhTEiLCJhdWQiOiLmjqXmlLbmlrkxIiwiaWF0IjoxNjc2OTkyNzA4LCJleHAiOjE2NzcwNzkxMDgsIm5iZiI6MTY3Njk5MjcyOCwianRpIjoiZmY4OTk1YzAtNjgzYi00NjE1LTljZGEtYTUyMGEyYTg2MTBjIn0
         * .BFgj2N6mE5hpoJ0mxm5rS_AwjQ0vwMuAPelUH-pPcGY
         */
    }
    //解析JWT
    @Test
    public void testGetUserInfo(){
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiaGFoYSIsImF2YXRhciI6ImhlYWQuanBnIiwicm9sZSI6ImFkbWluIiwic3ViIjoi5Li76aKYMSIsImlzcyI6IuetvuWPkeiAhTEiLCJhdWQiOiLmjqXmlLbmlrkxIiwiaWF0IjoxNjc2OTkzMDY0LCJleHAiOjE2NzY5OTMwNjUsIm5iZiI6MTY3Njk5MzA4NCwianRpIjoiNjgzOTBlZjQtNWRmZC00ZjE1LWFhMzctMmIyZGU5NWY2MThiIn0.4zfDZ3TBjTXXNof100U5z4JdZUf9jD_RVHKVFlqMgNE";

        JwtParser jwtParser = Jwts.parser();

        Jws<Claims> claimsJws = jwtParser.setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        String name = (String)claims.get("name");
        String role = (String)claims.get("role");

        String id = claims.getId();
        System.out.println("name:"+name);
        System.out.println("role:"+role);
        System.out.println("id:"+id);



    }




}
