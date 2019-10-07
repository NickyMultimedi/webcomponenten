package servlets;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/Including")
public class IncludingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        request.getSession();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Visitors</title></head><body>");
            RequestDispatcher disp = getServletContext().getNamedDispatcher("VisitorIncludeServlet");
            disp.include(request, response);
            out.println("</body></html>");
        }
    }
}
