package com.company.rental.model;

import com.company.rental.services.VariableService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private int id;
    private Vehicle vehicle;
    private LocalDate reservationFrom;
    private LocalDate reservationTo;



    public static LocalDate checkDate(String s) throws DateTimeException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate localDate = LocalDate.parse(s, formatter);

        return localDate;

    }

    public double getReservationCost() {
        double cost = this.getVehicle().getCarTypes() instanceof Car? 0.5: this.getVehicle().getCarTypes() instanceof Machine? 0.99: 0.7;
        System.out.println(ChronoUnit.DAYS.between(this.getReservationFrom(), this.getReservationTo()));
        return this.vehicle.getPrice() * cost * VariableService.getVariable();
    }

    public double getAllReservationCost() {
        double cost = this.getVehicle().getCarTypes() instanceof Car? 0.5: this.getVehicle().getCarTypes() instanceof Machine? 0.99: 0.7;
        return this.vehicle.getPrice() * cost * VariableService.getVariable() * this.getReservationFrom().compareTo(this.getReservationTo()) *
                ChronoUnit.DAYS.between(this.getReservationFrom(), this.getReservationTo());
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(LocalDate reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    public LocalDate getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(LocalDate reservationTo) {
        this.reservationTo = reservationTo;
    }
}
