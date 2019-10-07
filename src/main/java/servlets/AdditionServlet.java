package servlets;

import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/Addition")
public class AdditionServlet extends HttpServlet {
    /**
     *
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try(PrintWriter out = response.getWriter()) {
            out.print("<html><head><title>Addition Servlet");
            out.print("</title></head><body>");
            out.print("<form method='Post' >");
            out.print("Enter two numbers:");
            out.print("<input type='number' name='number1'/>");
            out.print("<input type='number' name='number2'/>");
            out.print("<input type='submit' value='Calculate'/>");
            out.print("</body></html>");
        }
    }

    /**
     * doPost method that calculates the sum of two numbers.
     * @param request
     * @param response
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answer;
        try {
            int number1 = Integer.parseInt(request.getParameter("number1"));
            int number2 = Integer.parseInt(request.getParameter("number2"));
            answer = "The sum is " + (number1 + number2);
        } catch (Exception e) {
            answer = "Invalid number";
        }
        response.setContentType("Text/html");
        response.setCharacterEncoding("UTF-8");

        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.print("<html><head><title>Addition Servlet");
            out.print("</title></head><body>");
            out.print(answer);
            out.print("<form method='Get'>");
            out.print("<input type='submit' value='Go Back'/>");
            out.print("</form></body></html>");
        }
    }
}
