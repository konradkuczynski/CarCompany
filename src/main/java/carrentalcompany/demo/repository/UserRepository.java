package carrentalcompany.demo.repository;


import carrentalcompany.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

//    @Query(value = "select * from user where name = ?1", nativeQuery = true) //SQL
    @Query(value = "select u from Users u where u.name= ?1")
    Optional<Users> findUserByName(String username);
}
