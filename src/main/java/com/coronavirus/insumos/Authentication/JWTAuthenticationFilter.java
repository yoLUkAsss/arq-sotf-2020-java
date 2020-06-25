package com.coronavirus.insumos.Authentication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coronavirus.insumos.dto.LogInDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

        public JWTAuthenticationFilter(String url, AuthenticationManager authManager) {
            super(new AntPathRequestMatcher(url,"POST"));
            setAuthenticationManager(authManager);
            setFilterProcessesUrl(url);
        }

        @Override
        public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response)
                throws AuthenticationException, IOException,ServletException{
            InputStream body = request.getInputStream();
            LogInDto user = new ObjectMapper().readValue(body, LogInDto.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(), user.getPassword(),
                            Collections.emptyList() ));
        }

        @Override
        protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                          FilterChain chain, Authentication auth) throws IOException, ServletException {
            JwtUtils.addAuthentication(response,auth.getName()); }

}
