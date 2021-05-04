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
public class InicioUtenteController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/inicio_utente/{id}")
    public ModelAndView inicio_utente(@PathVariable Long id, ModelMap map) {
        User dbUser = usersService.getUserById(id);
        map.put("user", dbUser);

        ModelAndView mav = new ModelAndView("inicio_utente");
        return mav;
    }
}

