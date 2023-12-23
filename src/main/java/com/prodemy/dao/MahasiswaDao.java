package com.prodemy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.prodemy.model.ModelMahasiswa;
import com.prodemy.viewmodel.ViewModelMahasiswa;

@Repository
public class MahasiswaDao {

    private static Connection conn = null;
    private static PreparedStatement preparedStatement = null;

    public List<ViewModelMahasiswa> getAllMahasiswa() {
        List<ViewModelMahasiswa> mhs = new ArrayList<>();
        String sql = "SELECT m.mhsnim, m.mhsnm, m.mhsaddr, p.prodnm, f.faknm FROM t_mahasiswa m JOIN t_prodi p ON m.prodkd = p.prodkd JOIN t_fakultas f ON p.fakkd = f.fakkd";
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                mhs.add(new ViewModelMahasiswa(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
            conn.close();
            preparedStatement.close();
            return mhs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mhs;
    }

    public ViewModelMahasiswa getMahasiswaByNim(String nim) {
        ViewModelMahasiswa mhs = null;
        String sql = "SELECT m.mhsnim, m.mhsnm, m.mhsaddr, p.prodnm, f.faknm FROM t_mahasiswa m JOIN t_prodi p ON m.prodkd = p.prodkd JOIN t_fakultas f ON p.fakkd = f.fakkd WHERE mhsnim="
                + nim;
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {

                mhs = new ViewModelMahasiswa(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            conn.close();
            preparedStatement.close();
            return mhs;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mhs;
    }

    public boolean deleteMahasiswaByNim(String nim) {
        String sql = "DELETE FROM t_mahasiswa WHERE mhsnim=" + nim;
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            int rs = preparedStatement.executeUpdate();

            if (rs == 1) {
                conn.close();
                preparedStatement.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean addMahasiswa(ModelMahasiswa mhs) {
        String sql = "INSERT INTO t_mahasiswa VALUES(?,?,?,?)";

        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, mhs.getMhsnim());
            preparedStatement.setString(2, mhs.getMhsnm());
            preparedStatement.setString(3, mhs.getMhsaddr());
            preparedStatement.setString(4, mhs.getProdkd());
            int rs = preparedStatement.executeUpdate();

            if (rs == 1) {
                conn.close();
                preparedStatement.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateMahasiswa(String oldMhsnim, ModelMahasiswa mhs) {
        String sql = "UPDATE t_mahasiswa SET mhsnim=?, mhsnm=?, mhsaddr=?, prodkd=? WHERE mhsnim=?";

        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, mhs.getMhsnim());
            preparedStatement.setString(2, mhs.getMhsnm());
            preparedStatement.setString(3, mhs.getMhsaddr());
            preparedStatement.setString(4, mhs.getProdkd());
            preparedStatement.setString(5, oldMhsnim);
            int rs = preparedStatement.executeUpdate();

            if (rs == 1) {
                conn.close();
                preparedStatement.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public String getLastMhsnmByProdkd(String prodkd) {
        String sql = "SELECT mhsnim FROM t_mahasiswa WHERE prodkd=? ORDER BY mhsnim DESC LIMIT 1";
        String mhsnim = null;
        try {
            makeJDBCConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, prodkd);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                mhsnim = rs.getString(1);
                conn.close();
                preparedStatement.close();
                return mhsnim;
            }
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
