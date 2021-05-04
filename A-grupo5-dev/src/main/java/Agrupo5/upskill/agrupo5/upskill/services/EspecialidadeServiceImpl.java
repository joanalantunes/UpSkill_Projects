package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Especialidade;
import Agrupo5.upskill.agrupo5.upskill.entities.Medico;
import Agrupo5.upskill.agrupo5.upskill.repositories.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService{

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Override
    public void addEspecialidade(String especialidade) {
        Especialidade nova = new Especialidade(especialidade);
        especialidadeRepository.save(nova);
    }

    @Override
    public void removeEspecialidade(int id) {
        especialidadeRepository.deleteById(id);
    }


    @Override
    public List<Especialidade> getEspecialidade(){
        return especialidadeRepository.findAll();
    }

    @Override
    public List<String> getMedicosPorEspecialidade(int numero) {
        return especialidadeRepository.findNomeMedicos(numero);
    }

    @Override
    public List<String> getMedicos() {
        return especialidadeRepository.findNomeMedicos();
    }


}
