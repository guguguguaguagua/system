package com.util;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding",value = "UTF-8")
        }
)
public class EncodingFilter implements Filter {

    protected String encoding = null;
    protected FilterConfig config;

    public String getEncoding() {
        return encoding;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req.getCharacterEncoding() == null) {
            String encode = getEncoding();
            if (encode != null) {
                req.setCharacterEncoding(encode);
                resp.setCharacterEncoding(encode);
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        this.encoding = config.getInitParameter("encoding");
    }

}
