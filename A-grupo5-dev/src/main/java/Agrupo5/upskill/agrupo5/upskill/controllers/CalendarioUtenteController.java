package Agrupo5.upskill.agrupo5.upskill.controllers;


import Agrupo5.upskill.agrupo5.upskill.services.EspecialidadeService;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalendarioUtenteController {

    @Autowired
    EspecialidadeService especialidadeService;

    @Autowired
    UsersService usersService;



    @GetMapping(value = "/calendario_utente/{id}")
    public String showEspecialidade(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        map.put("especialidadeList", especialidadeService.getEspecialidade());
        return "calendario_utente";
    }


    @PostMapping(value = "/calendario_utente/{id}")
    public ModelAndView selectEspecialidade(@PathVariable Long id, @RequestParam int especialidadeOption){
        ModelAndView map;
        map = new ModelAndView("redirect:/calendario_utente_medico/"+id);
        map.addObject("especialidade", especialidadeOption);
        return map;

    }

    @GetMapping(value = "/calendario_utente_medico/{id}")
    public ModelAndView showMedico(@PathVariable Long id, @RequestParam int especialidade){
        ModelAndView map;
        map = new ModelAndView("calendario_utente_medico");
        map.addObject("user", usersService.getUserById(id));
        if(especialidade == 0) {
            map.addObject("medicoList", especialidadeService.getMedicos());
        }else {
            map.addObject("medicoList", especialidadeService.getMedicosPorEspecialidade(especialidade));
        }
        return map;
    }

    @PostMapping(value = "/calendario_utente_medico/{id}")
    public ModelAndView goInicio(@PathVariable Long id){
        ModelAndView map = new ModelAndView("redirect:/pagina_manutencao");
        return map;
    }

    @GetMapping(value = "/calendario_utente_func/{id}")
    public String showEspecialidadeFunc(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        map.put("especialidadeList", especialidadeService.getEspecialidade());
        return "calendario_utente_func";
    }


    @PostMapping(value = "/calendario_utente_func/{id}")
    public ModelAndView selectEspecialidadeFunc(@PathVariable Long id, @RequestParam int especialidadeOption){
        ModelAndView map;
        map = new ModelAndView("redirect:/calendario_utente_medico_func/"+id);
        map.addObject("especialidade", especialidadeOption);
        return map;

    }

    @GetMapping(value = "/calendario_utente_medico_func/{id}")
    public ModelAndView showMedicoFunc(@PathVariable Long id, @RequestParam int especialidade){
        ModelAndView map;
        map = new ModelAndView("calendario_utente_medico_func");
        map.addObject("user", usersService.getUserById(id));
        if(especialidade == 0) {
            map.addObject("medicoList", especialidadeService.getMedicos());
        }else {
            map.addObject("medicoList", especialidadeService.getMedicosPorEspecialidade(especialidade));
        }
        return map;
    }

    @PostMapping(value = "/calendario_utente_medico_func/{id}")
    public ModelAndView goInicioFunc(@PathVariable Long id){
        ModelAndView map = new ModelAndView("redirect:/pagina_manutencao");
        return map;
    }


}
