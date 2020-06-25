package com.coronavirus.insumos.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;

import static com.coronavirus.insumos.Authentication.Constants.*;

public class JwtUtils {

    //se crea un token de Authorizacion
    static  void addAuthentication(HttpServletResponse response, String username){
        String token = Jwts.builder()
                .setSubject(username)
                //tiempo de expiracion de 3 horas
                .setExpiration(new Date(System.currentTimeMillis()+ TOKEN_EXPIRATION_TIME))

                .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
                .compact();
        response.addHeader(AUTHORIZATION, TOKEN_BEARER_PREFIX + token);
    }

    //se verifica el token de Authorizacion
    static Authentication getAuthentication(HttpServletRequest request){

        String token = request.getHeader(AUTHORIZATION);

        if ( token != null && token != "") {
            String user = Jwts.parser()
                    .setSigningKey(SUPER_SECRET_KEY)
                    .parseClaimsJws(token.replace(TOKEN_BEARER_PREFIX,""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList())
                    : null;
        }
        return null;
    }
}
