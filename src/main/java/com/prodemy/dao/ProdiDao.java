package com.prodemy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prodemy.model.ModelProdi;
import com.prodemy.viewmodel.*;

@Repository
public class ProdiDao {

    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public List<ViewModelProdi> getAllProdi() {

        List<ViewModelProdi> prod = new ArrayList<>();
        String sql = "SELECT p.prodkd, p.prodnm, f.faknm FROM t_prodi p JOIN t_fakultas f ON p.fakkd = f.fakkd ";
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                prod.add(new ViewModelProdi(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
            conn.close();
            preparedStatement.close();
            return prod;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return prod;

    }

    public ModelProdi getProdByProdnm(String prodnm) {
        String sql = "SELECT * FROM t_prodi WHERE prodnm=?";
        ModelProdi prod = null;
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, prodnm);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                prod = new ModelProdi(rs.getString(1), rs.getString(2), rs.getString(3));
            }
            conn.close();
            preparedStatement.close();
            return prod;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    private static void makeJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
