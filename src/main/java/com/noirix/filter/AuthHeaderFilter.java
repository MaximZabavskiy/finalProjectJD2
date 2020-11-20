package com.noirix.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class AuthHeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.println("In Auth filter!");

        HttpServletRequest castedRequest = (HttpServletRequest) request;
        String authHeader = castedRequest.getHeader("X-Auth-Token");
        if (StringUtils.isNotBlank(authHeader)) { //for future JWT Token Auth
            System.out.println("Header was found with payload: " + authHeader);
        } else {
            System.out.println("Header was not found!");
        }
        chain.doFilter(request, response);
    }
}