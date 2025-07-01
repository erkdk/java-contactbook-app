package com.contactbook.dao;

import com.contactbook.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {
    private String jdbcURL = "jdbc:mysql://192.168.56.14:3306/contactdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password123"; // change this as per your password

    private static final String INSERT_CONTACT_SQL = "INSERT INTO contacts (name, email, phone) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_CONTACTS = "SELECT * FROM contacts;";

    public ContactDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC Driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertContact(Contact contact) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_CONTACT_SQL)) {
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getEmail());
            ps.setString(3, contact.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CONTACTS);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                contacts.add(new Contact(id, name, email, phone));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return contacts;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex)
            if (e instanceof SQLException)
                e.printStackTrace();
    }
}

