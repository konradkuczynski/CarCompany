package com.company.rental.services;

import com.company.rental.DbHandler;
import com.company.rental.model.Car;
import com.company.rental.model.Reservation;
import com.company.rental.model.Vehicle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReservationService {

    public static void saveReservation(Reservation reservation) {

        String SQL = "INSERT INTO treservation (id, reservationFrom, reservationTo) VALUES (?,?,?)";

        try {
            PreparedStatement preparedStatement = DbHandler.connection.prepareStatement(SQL);

            preparedStatement.setInt(1, reservation.getVehicle().getId());
            preparedStatement.setString(2, reservation.getReservationFrom().toString());
            preparedStatement.setString(3, reservation.getReservationTo().toString());

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



//    private Vehicle vehicle;
//    private LocalDate reservationFrom;
//    private LocalDate reservationTo;