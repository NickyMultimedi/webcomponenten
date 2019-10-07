package servlets;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.io.*;

@WebServlet("/Calculator")
public class CalculatorServlet extends HttpServlet {
    private final String RESULT = "CalculatorServlet.result";
    private final String NUMBER = "number";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int result = 0;
        String message = "";
        HttpSession session = request.getSession();
        Object o = session.getAttribute(RESULT);
        String number = request.getParameter(NUMBER);

        if (o != null) {
            result = (Integer) o;
        }
        if (number != null) {
            try {
                result += Integer.parseInt(number);
            } catch (NumberFormatException nfe) {

            }
        }

        session.setAttribute(RESULT, result);
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Calculator");
            out.println("</title></head><body>");
            out.println("<form method='Get' >");
            out.println(message + "<br />");
            out.println("Result: " + result + "<br />");
            out.println("<input type");
            out.println("");
            out.println("");
        }
    }
}
