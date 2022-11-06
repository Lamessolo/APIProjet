package com.api.security.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.api.security.constant.SecurityConstant.*;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpStatus.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.security.utility.JWTTokenProvider;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthorisationFilter extends OncePerRequestFilter {

	private JWTTokenProvider jwtTokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		if(request.getMethod().equalsIgnoreCase(OPTIONS_HTTP_METHOD)) {
			response.setStatus(OK.value());
		}else {
			String authorizationHeader = request.getHeader(AUTHORIZATION);
			if(authorizationHeader == null || authorizationHeader.startsWith(TOKEN_PREFIX)) {
				
				filterChain.doFilter(request, response);
				return;
			}
			
			String token = authorizationHeader.substring(TOKEN_PREFIX.length());
			
			String username = jwtTokenProvider.getSubject(token);
			
			if(jwtTokenProvider.isTokenValid(username, token)&& SecurityContextHolder.getContext()== null) {
				List<GrantedAuthority> authorities  = jwtTokenProvider.getAuthorities(token);
				Authentication authentication = jwtTokenProvider.getAuthentication(username, authorities, request);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				
			}
			else {
				SecurityContextHolder.clearContext();
			}	
		}
		
		filterChain.doFilter(request, response);
	}

	
}
