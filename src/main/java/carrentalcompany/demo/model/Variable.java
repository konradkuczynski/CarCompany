package carrentalcompany.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;



public class Variable {


    private static int variable;

    public static int getVariable() {
        return variable;
    }

    public static void setVariableValue() {
        Random r = new Random();
        variable =r.nextInt(30);
    }

}
