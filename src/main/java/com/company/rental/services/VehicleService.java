package com.company.rental.services;

import com.company.rental.DbHandler;
import com.company.rental.model.Car;
import com.company.rental.model.CarTypes;
import com.company.rental.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleService {

    public static void saveVehicle(Vehicle vehicle) {

        String SQL = "INSERT INTO tvehicle (model, cartype, price, amortization) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);

            preparedStatement.setString(1, vehicle.getModel() );
            preparedStatement.setString(2, vehicle.getCarTypes().toString());
            preparedStatement.setDouble(3, vehicle.getPrice());
            preparedStatement.setDouble(4, vehicle.getAmortization());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Vehicle> getVehicles() {
        String SQL = "SELECT model, cartype, price, amortization, id FROM tvehicle";
        List<Vehicle> list = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);
            boolean isResultSet = preparedStatement.execute();

//            while (rs.next()) {
//                Vehicle vehicleFromDb = new Vehicle();
//
//                vehicleFromDb.setModel(rs.getString("model"));
//
//                vehicleFromDb.setCarTypes(CarTypes.isType(rs.getString("cartype")));
//                vehicleFromDb.setPrice(rs.getFloat("price"));
//                vehicleFromDb.setAmortization(rs.getFloat("amortization"));
//                list.add(vehicleFromDb);
//            }


            while (isResultSet) {
                if (isResultSet) {
                    ResultSet rs = preparedStatement.getResultSet();

                    while (rs.next()) {
                        Vehicle vehicleFromDb = new Vehicle();

                        vehicleFromDb.setModel(rs.getString("model"));

                        vehicleFromDb.setCarTypes(CarTypes.isType(rs.getString("cartype")));

                        vehicleFromDb.setPrice(rs.getFloat("price"));
                        vehicleFromDb.setAmortization(rs.getFloat("amortization"));
                        vehicleFromDb.setId(rs.getInt("id"));
//                        System.out.println(vehicleFromDb.toString());
                        list.add(vehicleFromDb);
                    }

                    rs.close();
                    isResultSet = preparedStatement.getMoreResults();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println(list.size());
        return list;
    }


}
