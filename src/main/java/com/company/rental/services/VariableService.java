package com.company.rental.services;

import com.company.rental.DbHandler;
import com.company.rental.model.Variable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VariableService {

    public static void saveVariable() {

        String SQL = "INSERT INTO tvariable (value) VALUES (?)";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);
            Variable.setVariable();

            preparedStatement.setInt(1, Variable.getVariable());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateVariable() {
        String SQL = "UPDATE tvariable SET value=? WHERE id=3";
        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);
            Variable.setVariable();

            preparedStatement.setInt(1, Variable.getVariable());
//            System.out.println(Variable.getVariable());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getVariable() {

        String SQL = "SELECT * FROM tvariable";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int i = rs.getInt("value");

                return i;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
