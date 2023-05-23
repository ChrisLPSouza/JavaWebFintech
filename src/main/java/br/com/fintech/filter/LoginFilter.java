package br.com.fintech.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/*")
public class LoginFilter /*implements Filter*/ {

//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpSession session = httpRequest.getSession();
//        String url = httpRequest.getRequestURI();
//
//        if (session.getAttribute("usuario") == null) {
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }else {
//            filter.doFilter(request, response);
//        }
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
