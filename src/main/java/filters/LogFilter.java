package filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(urlPatterns="/*")
public class LogFilter implements Filter {
     @Override
     public void init(FilterConfig fConfig) throws ServletException {

     }

     @Override
    public void destroy() {

     }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LocalDateTime now = LocalDateTime.now();
        String message = String.format("%td/%<tm/%<tY %<tH:%<tM:%<tS %s %s\n", now, req.getRequestURL(), req.getRemoteHost());
        req.getServletContext().log(message);
        chain.doFilter(request, response);
    }
}
