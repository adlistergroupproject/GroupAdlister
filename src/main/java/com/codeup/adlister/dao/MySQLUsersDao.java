package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }




    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);

        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }


    @Override
    public User findUserById(long id) {
        String query = "SELECT * FROM users WHERE id = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by id", e);
        }
    }



    @Override
    public User updateUserPassword(String password, long id){
        String query = "UPDATE users SET password = ? WHERE id = ?";
        User updatedUserPassword;
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            updatedUserPassword = findUserById(id);

        } catch (SQLException e) {
            throw new RuntimeException("Error updating the user", e);
        }
        return updatedUserPassword;
    }



    @Override
    public User updateUserInfo(String username, String email, long id){
        String query = "UPDATE users SET username = ?, email = ? WHERE id = ?";
        User updatedUserInfo;
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, email);
            stmt.setLong(3, id);
            stmt.executeUpdate();
            updatedUserInfo = findUserById(id);

        } catch (SQLException e) {
            throw new RuntimeException("Error updating the user", e);
        }

//        this is the updated user object

        return updatedUserInfo;

    }

    public void deleteUser(User user){
        String query = "DELETE FROM users WHERE id = ?";
        try{
            System.out.println(query);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user.getId());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void deleteUsersAds(User user) {
        String query = "DELETE FROM ads WHERE user_id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user.getId());
            System.out.println(query);
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }




}
