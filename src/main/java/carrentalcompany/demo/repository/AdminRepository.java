package carrentalcompany.demo.repository;

import carrentalcompany.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {


}
