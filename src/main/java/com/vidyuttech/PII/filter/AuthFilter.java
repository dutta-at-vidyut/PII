package com.vidyuttech.PII.filter;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class AuthFilter  implements Filter {

    @Value("${api.key.token}")
    private String xApiToken;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();

        if (path.startsWith("/health")) {
            chain.doFilter(request, response);
            return;
        }
        String key = req.getHeader("x-api-key") == null ? "" : req.getHeader("x-api-key");
        if (xApiToken.equals(key)) {
            chain.doFilter(request, response);
            return;
        }else {
            HttpServletResponse resp = (HttpServletResponse) response;
            String error = "Invalid API key";
            resp.reset();
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentLength(error .length());
            response.getWriter().write(error);
        }
    }
}

