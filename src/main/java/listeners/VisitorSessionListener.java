package listeners;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class VisitorSessionListener implements HttpSessionListener {
    public static final String TOTAL = "visitorsTotal";
    public static final String ACTIVE = "visitorsActive";

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        ServletContext sc = hse.getSession().getServletContext();
        int visitorsTotal = 1;
        int visitorsActive = 1;

        Integer total = (Integer) sc.getAttribute(TOTAL);
        if(total!= null) {
            visitorsTotal = total+1;
        }
        sc.setAttribute(TOTAL,visitorsTotal);

        Integer active = (Integer) sc.getAttribute(ACTIVE);
        if (active != null) {
            visitorsActive = total + 1;
        }
        sc.setAttribute(ACTIVE,visitorsActive);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        ServletContext sc = hse.getSession().getServletContext();
        Integer active = (Integer) sc.getAttribute(ACTIVE);

        int visitorsActive = 0;
        if (active != null) {
            visitorsActive = active - 1;
        }
        sc.setAttribute(ACTIVE, visitorsActive);
    }
}
