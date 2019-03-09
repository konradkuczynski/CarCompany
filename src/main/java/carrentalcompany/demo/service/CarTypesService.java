package carrentalcompany.demo.service;

import carrentalcompany.demo.model.CarTypes;
import carrentalcompany.demo.model.dtos.CarTypesDtos;
import carrentalcompany.demo.repository.CarTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypesService {

    private CarTypesRepository carTypesRepository;

    public CarTypesService(CarTypesRepository carTypesRepository) {
        this.carTypesRepository = carTypesRepository;
    }

    public List<CarTypes> getCarTypes() {
        return carTypesRepository.findAll();
    }
}
