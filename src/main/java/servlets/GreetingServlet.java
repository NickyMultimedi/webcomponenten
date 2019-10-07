package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="GreetingServlet", value="/GreetMe", initParams=@WebInitParam(name="greeting",value="Welcome"))
public class GreetingServlet extends HttpServlet {
    private String greeting;

    @Override
    public void init() throws ServletException {
        log("Init is opgeroepen, pagina draait vanaf nu.");
        greeting = getInitParameter("greeting");
        if (greeting == null) {
            throw new ServletException("Parameter text not found");
        }
    }

    @Override
    public void destroy() {
        log("Destroy has been called, pagina is afgesloten en draait niet meer.");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log("doGet service has been called. Page visited by 1 person");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPR html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Hello World Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println(greeting);
            out.println("</body>");
            out.println("</html>");

        }
    }
}
