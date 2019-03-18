package carrentalcompany.demo.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDtos {

    private String vehicle;
    private String reservationFrom;
    private String reservationTo;
}
