package carrentalcompany.demo.model.dtos;

import carrentalcompany.demo.model.CarTypes;
import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDtos {

    private String model;
    private String carType;
    private float price;
    private float amortization;

}
