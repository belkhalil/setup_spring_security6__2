package com.aba.SpringSecuritySocle.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class TodoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
