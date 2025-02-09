package com.projet.si.security.jwt;

import com.projet.si.security.services.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException {
    try {
      String authorizationHeader = request.getHeader("Authorization");



      if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
        String jwt = authorizationHeader.substring(7); // Remove "Bearer " prefix
        logger.error("JWT: {}", jwt);

        if (jwtUtils.validateJwtToken(jwt)) {
          String username = jwtUtils.getUserNameFromJwtToken(jwt);

          UserDetails userDetails = userDetailsService.loadUserByUsername(username);

          logger.error("userDetails: " + userDetails.getUsername());

          //UsernamePasswordAuthenticationToken is a class provided by Spring Security.
          // It represents an authentication request token that contains a username and password,
          // typically used for authenticating users based on their provided credentials.
          UsernamePasswordAuthenticationToken authentication =
                  new UsernamePasswordAuthenticationToken(userDetails,
                          null,
                          userDetails.getAuthorities());
          //credentials : This parameter usually represents the user's credentials (password),
          // but in this code, it's set to null. This suggests that the password is not provided in this particular step of authentication, or it might be handled separately.
          authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

          //new WebAuthenticationDetailsSource(): This creates a new instance of WebAuthenticationDetailsSource.
          // The WebAuthenticationDetailsSource is a class provided by Spring Security used to create WebAuthenticationDetails objects,
          // which capture additional details about the authentication request, such as the user's IP address and the session ID.

          SecurityContextHolder.getContext().setAuthentication(authentication);

          //SecurityContextHolder.getContext().setAuthentication(authentication);
          // is a common operation in Spring Security used to set the current user's authentication information into the security context.
        }
      }
    } catch (Exception e) {
      logger.error("Cannot set user authentication: {}", e);
    }

    filterChain.doFilter(request, response);
  }


  private String parseJwt(HttpServletRequest request) {
    String jwt = null;

    // Get the JWT token from cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("cnc-cookies")) {
          jwt = cookie.getValue();
          logger.debug("JWT token from cookie: {}", jwt);
          break;
        }
      }
    }

    return jwt;
  }


}
