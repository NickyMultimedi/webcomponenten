package servlets;

import listeners.VisitorSessionListener;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(name="VisitorIncludeServlet", value="/VisitorInclude")
public class VisitorIncludeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int total = (Integer) getServletContext().getAttribute(VisitorSessionListener.TOTAL);
        int active = (Integer) getServletContext().getAttribute(VisitorSessionListener.ACTIVE);
        @SuppressWarnings("resource")
        PrintWriter out = response.getWriter();
        out.printf("Total visitors: %d <br />", total);
        out.printf("Current visitors: %d <br />", active);
    }
}
