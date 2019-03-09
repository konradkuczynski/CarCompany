package carrentalcompany.demo.mappers;


import carrentalcompany.demo.commons.Mapper;
import carrentalcompany.demo.model.CarTypes;
import carrentalcompany.demo.model.dtos.CarTypesDtos;


public class CarTypesMapper implements Mapper<CarTypes, CarTypesDtos> {


    @Override
    public CarTypesDtos map(CarTypes from) {
        return CarTypesDtos.builder().type(from.getType()).build();
    }
}
