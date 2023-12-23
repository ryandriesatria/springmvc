package com.prodemy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prodemy.model.*;

@Repository
public class FakultasDao {

    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    private static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitas", "root", "");

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
    }
}