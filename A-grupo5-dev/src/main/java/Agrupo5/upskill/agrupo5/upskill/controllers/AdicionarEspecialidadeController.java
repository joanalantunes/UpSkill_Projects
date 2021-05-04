package Agrupo5.upskill.agrupo5.upskill.controllers;


import Agrupo5.upskill.agrupo5.upskill.entities.Especialidade;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.services.EspecialidadeService;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdicionarEspecialidadeController {

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/adicionar_especialidade/{id}")
    public String inicio(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));

        return "adicionar_especialidade";
    }

    @PostMapping (value = "/adicionar_especialidade/{id}")
    public String addEspecialidade (@RequestParam String novaEspecialidade, @PathVariable Long id, ModelMap map) {
        map.put("user", usersService.getUserById(id));

        List<Especialidade> especialidadeList = especialidadeService.getEspecialidade();
        for (Especialidade especialidade: especialidadeList) {
            if (especialidade.getNome().equals(novaEspecialidade)) {
                return "redirect:/adicionar_especialidade/"+id;
            }
        }

        especialidadeService.addEspecialidade(novaEspecialidade);
        return "redirect:/adicionar_especialidade/"+id;
    }

}
