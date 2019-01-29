package com.company.rental.model;

import java.util.Random;

public class Variable {

    public static int variable;

    public static int getVariable() {
        return variable;
    }
//TEST
    public static void setVariable() {
        Random r = new Random();
        Variable.variable =r.nextInt(30);
    }
}
