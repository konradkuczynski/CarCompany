package com.company.rental.model;

public interface CarTypes {

    static CarTypes isType(String type) {

        for (int i = 0; i < Machine.values().length; i++) {
            if (Machine.values()[i].toString().equals(type)) {
                return Machine.valueOf(type);
            }
        }

        for (int i = 0; i < Car.values().length; i++) {
            if (Car.values()[i].toString().equals(type)) {
                return Car.valueOf(type);
            }
        }

        for (int i = 0; i < Truck.values().length; i++) {
            if (Truck.values()[i].toString().equals(type)) {
                return Truck.valueOf(type);
            }
        }

        return null;
    }


}
