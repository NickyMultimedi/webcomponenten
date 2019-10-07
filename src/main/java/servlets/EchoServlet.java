package servlets;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Echo")
@ServletSecurity(value=@HttpConstraint(rolesAllowed="Administrators"))
public class EchoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Step 1 : Get parameters
        String text = request.getParameter("text");

        //Step 2 : generate content

        //Step 3 : set header
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Step 4 : get PrintWriter
        try(PrintWriter out = response.getWriter()) {
            //Step 5 : write content
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Echo Servlet </title></head><body>");
            out.println(text);
            out.println("</body></html>");
        }
    }
}
