package carrentalcompany.demo.service;

import carrentalcompany.demo.mappers.CarMapper;
import carrentalcompany.demo.model.CarTypes;
import carrentalcompany.demo.model.Vehicle;
import carrentalcompany.demo.model.dtos.VehicleDtos;
import carrentalcompany.demo.repository.CarTypesRepository;
import carrentalcompany.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {


    private VehicleRepository vehicleRepository;
    private CarMapper carMapper;
    private CarTypesRepository carTypesRepository;

    public VehicleService(VehicleRepository vehicleRepository, CarMapper carMapper, CarTypesRepository carTypesRepository) {
        this.vehicleRepository = vehicleRepository;
        this.carMapper = carMapper;
        this.carTypesRepository = carTypesRepository;
    }

    public List<Vehicle> getVehicle() {
        return vehicleRepository.findAll();
    }

    public Vehicle gettCarByPlate(String model) {
        return vehicleRepository.findVehicleByModel(model).get();
    }

    public boolean addVehicle(VehicleDtos carDTO) {

        Optional<Vehicle> car = vehicleRepository.findVehicleByModel(carDTO.getModel());
//        Optional.of(carRepository.findCarByPlate(carDTO.getPlate()).orElseGet(() -> carRepository.findCarByPlate(carDTO.getPlate()).ifPresent(d -> {})

        Optional<CarTypes> optionalCarTypes = carTypesRepository.findCarTypesByType(carDTO.getCarType());

        if (car.isPresent()) {
            System.out.println("Car already exists");
            return false;
        } else {
//            Car carDao = new Car(carDTO.getBrand(),
//                    carDTO.getModel(),
//                    carDTO.getPlate(),
//                    carDTO.getPlate());
//            carRepository.save(carDao);
            vehicleRepository.save(Vehicle.builder()
                    .amortization(carDTO.getAmortization())
                    .carTypes(optionalCarTypes.get())
                    .model(carDTO.getModel())
                    .price(carDTO.getPrice())
                    .plate(carDTO.getPlate())
                    .build());

            return true;
        }
    }


    // ----------------------------------__DTOS-------------------------------------

    public List<VehicleDtos> getAllVehiclesDtos() {

        List<VehicleDtos> vehicleDtos = new ArrayList<>();
        List<Vehicle> vehicles = vehicleRepository.findAll();

        for (Vehicle vehicle : vehicles) {
            vehicleDtos.add(carMapper.map(vehicle));
        }
        return vehicleDtos;
    }
}
