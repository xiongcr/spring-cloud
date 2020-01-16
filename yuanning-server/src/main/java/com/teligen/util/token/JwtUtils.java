package com.teligen.util.token;

import com.google.gson.Gson;
import com.teligen.exception.MyException;
import com.teligen.util.returnFormat.StatusCode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//jwt工具类
public class JwtUtils {
    private static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    /**
     * @Author: Helon
     * @Description: 生成JWT字符串
     * 格式：A.B.C
     * A-header头信息
     * B-payload 有效负荷
     * C-signature 签名信息 是将header和payload进行加密生成的
     * @param id - 用户编号
     * @param username - 用户名
     * @Data: 2018/7/28 19:26
     * @Modified By:
     */
    public static String createJWT(String id, String username) {
        //签名算法，选择SHA-256
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前系统时间
        long nowTimeMillis = System.currentTimeMillis();
        Date now = new Date(nowTimeMillis);
        //将BASE64SECRET常量字符串使用base64解码成字节数组
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SecretConstant.BASE64SECRET);
        //使用HmacSHA256签名算法生成一个HS256的签名秘钥Key
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        //添加构成JWT的参数
        Map<String, Object> headMap = new HashMap<>();
        /*
            Header
            {
              "alg": "HS256",
              "typ": "JWT"
            }
         */
        headMap.put("alg", SignatureAlgorithm.HS256.getValue());
        headMap.put("typ", "JWT");
        JwtBuilder builder = Jwts.builder().setHeader(headMap)
                /*
                    Payload
                    {
                      "userId": "1234567890",
                      "password": "123456",
                    }
                 */
                //加密后的userId
                .claim("id", AESSecretUtil.encryptToStr(id, SecretConstant.DATAKEY))
                //密码
                .claim("username", username)
                //客户端浏览器信息
                //.claim("userAgent", identities[0])
                //Signature
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (SecretConstant.EXPIRESSECOND >= 0) {
            long expMillis = nowTimeMillis + SecretConstant.EXPIRESSECOND;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate).setNotBefore(now);
        }
        return builder.compact();
    }

    /**
     * @Author: Helon
     * @Description: 解析JWT
     * 返回Claims对象
     * @param jsonWebToken - JWT
     * @Data: 2018/7/28 19:25
     * @Modified By:
     */
    public static Claims parseJWT(String jsonWebToken) {
        Claims claims = null;
        try {
            if (StringUtils.isNotBlank(jsonWebToken)) {
                //解析jwt
                claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SecretConstant.BASE64SECRET))
                        .parseClaimsJws(jsonWebToken).getBody();
            }else {
                throw new MyException(StatusCode.ERROR,"Token为空");
            }
        } catch (Exception e) {
            throw new MyException(StatusCode.ERROR,"Token 解析异常");
        }
        return claims;
    }

    /**
     * @Author: Helon
     * @Description: 校验JWT是否有效
     * 返回json字符串的demo:
     * {"freshToken":"A.B.C","userName":"Judy","userId":"123", "userAgent":"xxxx"}
     * freshToken-刷新后的jwt
     * userName-客户名称
     * userId-客户编号
     * userAgent-客户端浏览器信息
     * @param jsonWebToken - JWT
     * @Data: 2018/7/24 15:28
     * @Modified By:
     */
    public static String validateLogin(String jsonWebToken) {
        Map<String, Object> retMap = null;
        Claims claims = parseJWT(jsonWebToken);
        if (claims != null) {
            //解密客户编号
            String decryptUserId = AESSecretUtil.decryptToStr((String)claims.get("id"), SecretConstant.DATAKEY);
            retMap = new HashMap<>();
            //加密后的客户编号
            retMap.put("id", decryptUserId);
            //客户名称
            retMap.put("username", claims.get("username"));
            //客户端浏览器信息
            //retMap.put("userAgent", claims.get("userAgent"));
/*            //刷新JWT
            retMap.put("freshToken", createJWT(decryptUserId, (String)claims.get("userName")));*/
        }else {
            throw new MyException(StatusCode.ERROR,"Token 解析异常");
        }
        return retMap!=null? new Gson().toJson(retMap):null;
    }

    public static void main(String[] args) {
        String jsonWebKey = createJWT("1", "1");
        System.out.println(jsonWebKey);
        Claims claims =  parseJWT(jsonWebKey);
        System.out.println(claims);
        System.out.println(validateLogin(jsonWebKey));
    }
}
