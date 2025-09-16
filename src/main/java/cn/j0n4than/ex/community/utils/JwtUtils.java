package cn.j0n4than.ex.community.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Properties;

public class JwtUtils {
    private static final SecretKey secretKey;

    static {
        String _secret;
        InputStream inputStream = JwtUtils.class.getClassLoader().getResourceAsStream("jjwt.properties");
        Properties properties = new Properties();

        try {
            properties.load(inputStream);
            _secret = properties.getProperty("jjwt.secret");
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e) {
            // Using random secret
            // The secret must be >= 256bit(32 bytes)
            _secret = MiscUtils.randString(32);
            System.out.println("Err: " + e.getMessage());
            System.out.println("Using random secret: " + _secret);
        }
        secretKey = Keys.hmacShaKeyFor(_secret.getBytes());
    }

    public static String crete(Object data, long expired) {
        return Jwts.builder()
                .claim("data", data)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expired))
                .signWith(secretKey)
                .compact();
    }

    public static <T> T parse(String token, Class<T> t) {
        JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
        Claims payload = parser.parseSignedClaims(token).getPayload();
        LinkedHashMap data = payload.get("data", LinkedHashMap.class);

        try {
            T targetObj = t.newInstance();
            Field[] fields = t.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(targetObj, data.get(field.getName()));
            }

            return targetObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
