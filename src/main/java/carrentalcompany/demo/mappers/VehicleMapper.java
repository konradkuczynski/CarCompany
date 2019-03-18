package carrentalcompany.demo.mappers;

import carrentalcompany.demo.commons.Mapper;
import carrentalcompany.demo.model.Reservation;
import carrentalcompany.demo.model.dtos.ReservationDtos;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper implements Mapper<Reservation, ReservationDtos> {


    @Override
    public ReservationDtos map(Reservation from) {
        return ReservationDtos.builder()
                .reservationFrom(from.getReservationFrom().toString())
                .reservationTo(from.getReservationTo().toString())
                .vehicle(from.getVehicle().getPlate())
                .build();
    }
}
