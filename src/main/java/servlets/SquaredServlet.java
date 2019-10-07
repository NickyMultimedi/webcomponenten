package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Squared")
public class SquaredServlet extends HttpServlet {

    //
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Step 1 : Get parameters
        String text = request.getParameter("text");
        Double num;
        //Step 3 : set header
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        //Step 2 : generate content

        // Step 4 : get PrintWriter
        try(PrintWriter out = response.getWriter()) {
            //Step 5 : write content
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Echo Servlet </title></head><body>");
            try {
                num = Double.parseDouble(text);
                out.println(num * num);
            } catch( NumberFormatException nfe) {
                out.println((new StringBuilder(text)).reverse().toString());
            }
            out.println("</body></html>");
        }
    }
}
