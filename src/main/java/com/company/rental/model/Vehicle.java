package com.company.rental.model;

public class Vehicle {

    private int id;


    private String model;
    private CarTypes carTypes;
    private float price;
    private float amortization;

//    public Vehicle(String model, CarTypes carTypes, float price) {
//        this.model = model;
//        this.carTypes = carTypes;
//        this.price = price;
//    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setAmortization(float amortization) {
        this.amortization = amortization;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarTypes getCarTypes() {
        return carTypes;
    }

    public void setCarTypes(CarTypes carTypes) {
        this.carTypes = carTypes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmortization() {
        return amortization;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", carTypes=" + carTypes +
                ", price=" + price +
                ", amortization=" + amortization +
                '}';
    }

}
