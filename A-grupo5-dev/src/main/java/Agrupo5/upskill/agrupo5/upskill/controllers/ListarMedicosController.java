package Agrupo5.upskill.agrupo5.upskill.controllers;


import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import Agrupo5.upskill.agrupo5.upskill.services.EspecialidadeService;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ListarMedicosController {

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/listar_medicos/{id}")
    public String showAllMedicos(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        map.put("medicoList", especialidadeService.getMedicos());
        return "listar_medicos";
    }

    @GetMapping(value = "/listar_medicos_func/{id}")
    public String showAllMedicosFunc(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        map.put("medicoList", especialidadeService.getMedicos());
        return "listar_medicos_func";
    }
}
