package Entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GuestBookBean implements Serializable {
    private int id;
    private LocalDateTime date;
    private String name;
    private String message;

    public GuestBookBean() {

    }
    public GuestBookBean(int id, LocalDateTime date, String name, String message) {
        this.setId(id);
        this.setDate(date);
        this.setName(name);
        this.setMessage(message);
    }

    public int getId() {
        return this.id;
    }
    public LocalDateTime getDate() {
        return this.date;
    }
    public String getName() {
        return this.name;
    }
    public String getMessage() {
        return this.message;
    }

    private void setId(int id) {
        this.id = id;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s : %s", this.getDate(), this.getName(), this.getMessage());
    }
}
