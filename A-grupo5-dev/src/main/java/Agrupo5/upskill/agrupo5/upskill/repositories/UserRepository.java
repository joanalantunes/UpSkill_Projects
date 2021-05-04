package Agrupo5.upskill.agrupo5.upskill.repositories;

import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

    User findByUsername(String username);

    User findById(Long id);

    User findByRole(Role role);

    User findByNumeroDocumento(String numeroDocumento);

    User findByNif(String nif);


    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<User> customQuery();

}
