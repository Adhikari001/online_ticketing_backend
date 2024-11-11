package com.example.onlineticketing.comms.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class RequestLoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        log.info("New http request, request {} {} {} route {}://{}:{}{} Remote address {}://{}:{} {} {}  ",
                request.getProtocol(),
                request.getMethod(),
                request.getServerName(),
                request.getScheme(),
                request.getLocalAddr(),
                request.getServerPort(),
                request.getRequestURI(),
                request.getScheme(),
                request.getRemoteAddr(),
                request.getRemotePort(),
                request.getRemoteHost(),
                request.getRemoteUser());
        filterChain.doFilter(request, response);
    }
}
