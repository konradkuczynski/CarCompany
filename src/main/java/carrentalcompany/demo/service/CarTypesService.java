package carrentalcompany.demo.service;

import carrentalcompany.demo.model.CarTypes;
import carrentalcompany.demo.model.dtos.CarTypesDtos;
import carrentalcompany.demo.repository.CarTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarTypesService {

    private CarTypesRepository carTypesRepository;

    public CarTypesService(CarTypesRepository carTypesRepository) {
        this.carTypesRepository = carTypesRepository;
    }

    public List<CarTypes> getCarTypes() {
        return carTypesRepository.findAll();
    }

    public void addCarTypes(CarTypesDtos carTypesDtos) {

        Optional<CarTypes> carTypes = carTypesRepository.findCarTypesByType(carTypesDtos.getType());

        if (carTypes.isPresent()) {
            System.out.println("Types exists!!!!!");
        } else {
            carTypesRepository.save(CarTypes.builder().type(carTypesDtos.getType()).build());
        }

    }
}
