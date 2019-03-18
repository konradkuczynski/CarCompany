package carrentalcompany.demo.service;


import carrentalcompany.demo.mappers.CarMapper;
import carrentalcompany.demo.model.Reservation;
import carrentalcompany.demo.model.Vehicle;
import carrentalcompany.demo.model.dtos.ReservationDtos;
import carrentalcompany.demo.model.dtos.VehicleDtos;
import carrentalcompany.demo.repository.ReservationRepository;
import carrentalcompany.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {


    private CarMapper carMapper;
    private ReservationRepository reservationRepository;
    private VehicleRepository vehicleRepository;

    public ReservationService(CarMapper carMapper, ReservationRepository reservationRepository, VehicleRepository vehicleRepository) {
        this.carMapper = carMapper;
        this.reservationRepository = reservationRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public void addReservation(VehicleDtos vehicleDtos, ReservationDtos reservationDtos) {

        Optional<Vehicle> car = vehicleRepository.findVehicleByPlate(vehicleDtos.getPlate());

        reservationRepository.save(Reservation.builder()
                .reservationFrom(LocalDate.parse(reservationDtos.getReservationFrom()))
                .reservationTo(LocalDate.parse(reservationDtos.getReservationTo()))
                .vehicle(car.get())
                .build());
    }
}
