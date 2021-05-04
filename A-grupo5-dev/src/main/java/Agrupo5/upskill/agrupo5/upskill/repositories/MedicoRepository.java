package Agrupo5.upskill.agrupo5.upskill.repositories;

import Agrupo5.upskill.agrupo5.upskill.entities.Medico;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

    Medico findById(int id_medico);

   /* @Query(value = "SELECT * FROM medico", nativeQuery = true)
    List<Medico> customQuery();*/

    @Query(value = "SELECT * FROM (SELECT * FROM USERS JOIN FUNCIONARIO ON ID_USERS = USERS_ID JOIN MEDICO ON ID_FUNCIONARIO = FUNCIONARIO_ID)", nativeQuery = true)
    List<Medico> customQuery();



}
