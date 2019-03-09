package carrentalcompany.demo.repository;

import carrentalcompany.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    List<Vehicle> findAll();

    @Query(value = "select * FROM vehicle where  id=?1", nativeQuery = true) //liczna 1 oznacza numer parametru w metodzie
    Optional<Vehicle> findVehicleByModel(String model);
}
