package carrentalcompany.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String model;

    @ManyToOne
    @JoinColumn(name = "fk_type")
    private CarTypes carTypes;

    private float price;
    private float amortization;
    private String plate;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", carTypes=" + carTypes +
                ", price=" + price +
                ", amortization=" + amortization +
                '}';
    }
}

