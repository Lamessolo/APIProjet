package com.api.security.constant;


public class SecurityConstant {

	public static final long EXPIRATION_TIME  = 432_000_000; // 5 days expressed in ms
	
	public static final String TOKEN_HEADER="Bearer";
	
	
	public static final String TOKEN_PREFIX="Token prefix";
	
	public static final String JWT_TOKEN_HEADER="Jwt-Token";
	
	public static final String TOKEN_CANNOT_BE_VERIFIED ="Token cannot be verified";
	
	public static final String GET_ARRAY_LLC="Get array, LLC";
	
	public static final String GET_ARRAY_ADMINISTRATION="User Management Portal";
	
	public static final String AUTHORITIES ="Authorities";
	
	public static final String FORBIDDEN_MESSAGE="You need to log access this page";
	
	public static final String ACCESS_DENIED_MESSAGE = "you do not have permission to access this page";
	
	public static final String OPTIONS_HTTP_METHOD ="OPTIONS";
	
	public static final String[] PUBLIC_URLS = {"/user/login"
			                                     ,"/user/register"
			                                     ,"/user/resetpassword/**"
			                                     ,"/user/image/**"};
	
	
}
