package com.company.rental.services;

import com.company.rental.DbHandler;
import com.company.rental.model.Admin;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminService {

    public static void saveAdmin(Admin admin) {
        String SQL = "INSERT INTO tadmin (login, password) VALUES (?,?)";


        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);
            preparedStatement.setString(1, admin.getLogin());
            String hash = DigestUtils.md5Hex(admin.getPassword());
            preparedStatement.setString(2, hash);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Admin getUserById(int i) {
        String SQL = "SELECT * FROM tadmin WHERE id=?";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);

            preparedStatement.setInt(1, i);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Admin adminFromDb = new Admin();
                adminFromDb.setId(i);
                adminFromDb.setLogin(rs.getString("login"));
                adminFromDb.setPassword(rs.getString("password"));

                return adminFromDb;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static boolean authorizedAdmin(Admin admin) {

        String SQL = "SELECT * FROM tadmin WHERE login=?";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);

            preparedStatement.setString(1, admin.getLogin());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                if (rs.getString("password").equals(DigestUtils.md5Hex(admin.getPassword()))) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
