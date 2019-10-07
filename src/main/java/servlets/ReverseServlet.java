package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Reversed")
public class ReverseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Step 1 : Get parameters
        String text = request.getParameter("text");

        //Step 2 : generate content
        StringBuilder reversedText = new StringBuilder(text.toLowerCase());
        reversedText.reverse();

        //Step 3 : set header
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Step 4 : get PrintWriter
        try(PrintWriter out = response.getWriter()) {
            //Step 5 : write content
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Echo Servlet </title></head><body>");
            out.println(reversedText.toString());
            out.println("</body></html>");
        }
    }
}
