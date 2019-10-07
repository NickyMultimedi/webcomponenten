package servlets;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="HelloServlet", value="/HelloWorld", initParams=@WebInitParam(name="text",value="Hello World"))
public class HelloWorldServlet extends HttpServlet {
    private String text;

    @Override
    public void init() throws ServletException {
        text = getInitParameter("text");
        if (text == null) {
            throw new ServletException("Parameter text not found");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPR html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(text);
            out.println("</body>");
            out.println("</html>");

        }
    }
}
