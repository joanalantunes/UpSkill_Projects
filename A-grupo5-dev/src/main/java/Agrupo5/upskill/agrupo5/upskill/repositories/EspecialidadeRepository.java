package Agrupo5.upskill.agrupo5.upskill.repositories;

import Agrupo5.upskill.agrupo5.upskill.entities.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

    Especialidade findByNome(String nome);

    Especialidade findById(int id_especialidade);

    @Query(value = "SELECT Nome, Nome_Especialidade FROM (SELECT * FROM USERS JOIN MEDICO ON ID_USERS = USER_ID JOIN MEDICO_ESPECIALIDADE ON ID_MEDICO = MEDICO_ID JOIN ESPECIALIDADE ON ESPECIALIDADE_ID = ID_ESPECIALIDADE) as t WHERE id_especialidade =?1", nativeQuery = true)
    List<String> findNomeMedicos(int id_especialidade);

    @Query(value = "SELECT Nome, Nome_Especialidade FROM (SELECT * FROM USERS JOIN MEDICO ON ID_USERS = USER_ID JOIN MEDICO_ESPECIALIDADE ON ID_MEDICO = MEDICO_ID JOIN ESPECIALIDADE ON ESPECIALIDADE_ID = ID_ESPECIALIDADE) as t ", nativeQuery = true)
    List<String> findNomeMedicos();

}
