package carrentalcompany.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variable")
public class Variable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int variable;

    public void setVariableValue() {
        Random r = new Random();
        this.variable =r.nextInt(30);
    }

}
