package carrentalcompany.demo.repository;

import carrentalcompany.demo.model.CarTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarTypesRepository extends JpaRepository<CarTypes, Integer> {

    List<CarTypes> findAll();

    @Query( "SELECT c FROM CarTypes c where c.type = ?1")
    Optional<CarTypes> findCarTypesByType(String type);




}
