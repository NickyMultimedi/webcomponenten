package servlets;

import listeners.VisitorSessionListener;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/Visitors")
public class VisitorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession();
        int total = (Integer) getServletContext().getAttribute(VisitorSessionListener.TOTAL);
        int active = (Integer) getServletContext().getAttribute(VisitorSessionListener.ACTIVE);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Visitors</title></head><body>");
            out.printf("Total visitors: %d <br />", total);
            out.printf("Current visitors: %d <br />", active);
            out.println("</body></html>");
        }
    }
}
