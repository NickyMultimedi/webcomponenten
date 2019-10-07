import DAO.GuestBookDao;
import Entities.GuestBookBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GuestBookDao gbd = new GuestBookDao("jdbc:mysql://noelvaes.eu/StudentDB3", "student", "student123");

        for (GuestBookBean el: gbd.getGuestBookEntries()) {
            System.out.println(el.toString());
        }
    }
}
