package carrentalcompany.demo.mappers;

import carrentalcompany.demo.commons.Mapper;
import carrentalcompany.demo.model.Vehicle;
import carrentalcompany.demo.model.dtos.VehicleDtos;
import org.springframework.stereotype.Component;

@Component
public class CarMapper implements Mapper<Vehicle, VehicleDtos> {


    @Override
    public VehicleDtos map(Vehicle from) {
        return VehicleDtos.builder()
                .amortization(from.getAmortization())
                .carType(from.getCarTypes().getType())
                .model(from.getModel())
                .price(from.getPrice())
                .plate(from.getPlate())
                .build();
    }
}
