package Agrupo5.upskill.agrupo5.upskill.controllers;

import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InformacoesController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/informacoes_utente/{id}")
    public ModelAndView informacoes_utente(@PathVariable Long id, ModelMap map) {
        User dbUser = usersService.getUserById(id);
        map.put("user", dbUser);

        ModelAndView mav = new ModelAndView("informacoes_utente");
        return mav;
    }

    @GetMapping(value = "/informacoes_medico/{id}")
    public ModelAndView informacoes_medico(@PathVariable Long id, ModelMap map) {
        User dbUser = usersService.getUserById(id);
        map.put("user", dbUser);

        ModelAndView mav = new ModelAndView("informacoes_medico");
        return mav;
    }


    @GetMapping(value = "/pagina_manutencao")
    public String pagina_manutencao(){
        return "pagina_manutencao";
    }

}

