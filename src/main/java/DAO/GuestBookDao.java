package DAO;

import Entities.GuestBookBean;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

public class GuestBookDao {
    private String url;
    private String user;
    private String password;

    public GuestBookDao() {

    }
    public GuestBookDao(String url, String user, String password) {
        this.setUrl(url);
        this.setUser(user);
        this.setPassword(password);
        try{Class.forName("com.mysql.jdbc.Driver");}
        catch (ClassNotFoundException cnfe) {}
    }

    private String getUrl() {
        return this.url;
    }
    private String getUser() {
        return this.user;
    }
    private String getPassword() {
        return this.password;
    }

    private void setUrl(String url) {
        this.url = url;
    }
    private void setUser(String user) {
        this.user = user;
    }
    private void setPassword(String password) {
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.getUrl(), this.getUser(), this.getPassword());
    }

    public GuestBookBean getGuestBookEntryById(int id) throws SQLException {
        try(Connection con = getConnection();
            PreparedStatement stmt = con.prepareStatement("Select * from GuestBook where id=?")) {
            stmt.setInt(1,id);
            try(
                    ResultSet rs = stmt.executeQuery()
                    ) {
                if (rs.next()) {
                    GuestBookBean gb = new GuestBookBean(id, rs.getTimestamp("Date").toLocalDateTime(), rs.getString("Name"), rs.getString("Message"));
                    return gb;
                } else {
                    return null;
                }
            }
        }
    }

    public ArrayList<GuestBookBean> getGuestBookEntries() {
        ArrayList<GuestBookBean> gbSet = new ArrayList<>();

        try (
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement("Select * from GuestBook;")
        ) {
            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    gbSet.add(new GuestBookBean(rs.getInt("id"),
                            rs.getTimestamp("Date").toLocalDateTime(),
                            rs.getString("Name"),
                            rs.getString("Message")));

                }
            }
        } catch (SQLException sqle) {
            Stream.of(sqle.getStackTrace()).forEach(System.out::println);
            System.out.println(sqle.getMessage());
        }

        return gbSet;
    }

    public void addGuestBookEntry(GuestBookBean gbb) {
        try(
                Connection con = getConnection();
                PreparedStatement stmt = con.prepareStatement("Insert Into GuestBook (Date, Name, Message) values (?, ?, ?);")
                ) {
            stmt.setTimestamp(1, Timestamp.valueOf(gbb.getDate()));
            stmt.setString(2, gbb.getName());
            stmt.setString(3, gbb.getMessage());
            stmt.executeUpdate();

        } catch (SQLException sqle) {

        }
    }
}
