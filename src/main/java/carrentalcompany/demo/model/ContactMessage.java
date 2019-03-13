package carrentalcompany.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactMessage {

    private String nameSurname;
    private String email;
    private String phoneNumber;
    private String message;

}
