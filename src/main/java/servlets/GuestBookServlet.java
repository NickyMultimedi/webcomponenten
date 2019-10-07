package servlets;

import DAO.GuestBookDao;
import Entities.GuestBookBean;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@WebServlet("/GuestBook")
public class GuestBookServlet extends HttpServlet {
    private static GuestBookDao gbd = new GuestBookDao("jdbc:mysql://noelvaes.eu/StudentDB3", "student", "student123");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<GuestBookBean> gbSet = gbd.getGuestBookEntries();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        try(PrintWriter out = response.getWriter()) {
            out.print("<!DOCTYPE html>");
            out.print("<html><head><title>Gastenboek");
            out.print("</title></head><body>");
            for(GuestBookBean el: gbSet) {
                out.print("<p>" + el.toString() + "</p>");
            }
            out.print("<form method='Post'>");
            out.print("Name:");
            out.print("<input name='Name' type='text' /><br />");
            out.print("<textArea name='Message' rows='15' cols='50'></textarea><br />");
            out.print("<input type='submit' value='Submit Message'/>");
            out.print("</form></body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GuestBookBean gbb = new GuestBookBean(0, LocalDateTime.now(),request.getParameter("Name"), request.getParameter("Message"));
        gbd.addGuestBookEntry(gbb);
        this.doGet(request, response);
    }
}
