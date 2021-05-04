package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Especialidade;
import Agrupo5.upskill.agrupo5.upskill.entities.Medico;

import java.util.List;

public interface EspecialidadeService {

    void addEspecialidade (String especialidade);

    void removeEspecialidade (int id);

    List<Especialidade> getEspecialidade ();

    List<String> getMedicosPorEspecialidade(int numero);

    List<String> getMedicos ();
}
