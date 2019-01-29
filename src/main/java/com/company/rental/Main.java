package com.company.rental;

import com.company.rental.model.*;
import com.company.rental.services.AdminService;
import com.company.rental.services.ReservationService;
import com.company.rental.services.VehicleService;
import com.company.rental.threads.VariableRunnable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {


        DbHandler.connect();

        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.schedule(new VariableRunnable(), 1, TimeUnit.SECONDS );



        while (true) {
            System.out.println("Main menu - choose option");
            System.out.println("1. Log as Admin \n2. Guest mode \n3. Register as Admin");

            Scanner sc = new Scanner(System.in);

            int num = sc.nextInt();

            switch (num) {
                case 1:
                    Admin admin = new Admin();
                    System.out.println("Type login: \t");
                    admin.setLogin(sc.next());
                    System.out.println("Type password: \t");
                    admin.setPassword(sc.next());
                    if (AdminService.authorizedAdmin(admin)) {
                        System.out.println("Zalogowany");
                        System.out.println("Admin menu - choose option");
                        System.out.println("1. Add vehicle \n2. Print all vehicles");

                        int numAdmin = sc.nextInt();
                        switch (numAdmin) {
                            case 1:

                                try {
                                    Vehicle vehicle = new Vehicle();
                                    System.out.println("Type car types");
                                    vehicle.setCarTypes(CarTypes.isType(sc.next()));
                                    if (vehicle.getCarTypes() == null) {
                                        System.out.println("Wrong cat type");
                                        continue;
                                    }
                                    try {
                                        System.out.println("Type car amortization");
                                        vehicle.setAmortization(sc.nextInt());
                                        System.out.println("Type car price");
                                        vehicle.setPrice(sc.nextInt());
                                        System.out.println("Type car model");
                                        vehicle.setModel(sc.next());
                                    }  catch (InputMismatchException e) {
                                        System.out.println(e.getMessage());
                                        continue;
                                    }

                                    VehicleService.saveVehicle(vehicle);
                                    System.out.println("Vehicle saved into database !!");
                                    continue;
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                    continue;

                                }

                            case 2:
                                System.out.println("Our vehicles in database:");
                                VehicleService.getVehicles().stream().forEach(n -> System.out.println(n));
                                continue;
                        }


                    } else {
                        System.out.println("Incorrect password");
                        break;
                    }
                case 2:

                    System.out.println("Guest menu - choose option");
                    System.out.println("1. Print all vehicles \n2. Reserve vehicle");
                    int numGuest = sc.nextInt();
                    switch (numGuest) {
                        case 1:
                            System.out.println("Our vehicles in database:");
                            VehicleService.getVehicles().stream().forEach(n -> System.out.println(n.getId() + ": " +n));
                            break;
                        case 2:
                            Reservation reservation = new Reservation();
                            System.out.println("Our list of vehicles - choose number");
                            VehicleService.getVehicles().stream().forEach(n -> System.out.println(n.getId() + ": " +n));
                            try {
                                reservation.setVehicle(VehicleService.getVehicles().get(sc.nextInt()-1));
                                System.out.println("Type start date of your reservation in format DD-MM-RRRR");
                                reservation.setReservationFrom(Reservation.checkDate(sc.next()));
                                System.out.println("Type end date of your reservation in format DD-MM-RRRR");
                                reservation.setReservationTo(Reservation.checkDate(sc.next()));
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println("Wrong number - leaving");
                                continue;
                            } catch (java.time.DateTimeException e) {
                                System.out.println("wrong data format - should be in format DD-MM-RRRR");
                                continue;
                            }


                            System.out.println("Cost of your reservation per day is: " + reservation.getReservationCost());
                            System.out.println("Total cost of your reservation  is: " + reservation.getAllReservationCost());
                            System.out.println("Do you accept? type yes/no");
                            String question = sc.next();
                            if (question.equals("yes")) {
                                ReservationService.saveReservation(reservation);
                                System.out.println("Reservation saved into database");
                                break;
                            } else {
                                System.out.println("Leaving... ");
                                break;
                            }
                    }
            }
        }
    }
}
