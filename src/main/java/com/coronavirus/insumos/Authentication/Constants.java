package com.coronavirus.insumos.Authentication;

public class Constants {
    // Spring Security
    public static final String REGISTER_URL = "/autentication/singUp";
    public static final String LOGIN_URL = "/autentication/logIn";
    public static final String LOGOUT_URL = "/autentication/logOut";
    public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
    public static final String TOKEN_BEARER_PREFIX = "Bearer ";

    // JWT
    public static final String AUTHORIZATION = "Authorization";
    public static final String SUPER_SECRET_KEY = "1234";
    public static final long TOKEN_EXPIRATION_TIME = 1800000; // 3 horas

}
