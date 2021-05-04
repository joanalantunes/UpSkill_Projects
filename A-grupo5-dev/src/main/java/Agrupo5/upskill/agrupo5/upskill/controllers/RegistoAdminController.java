package Agrupo5.upskill.agrupo5.upskill.controllers;


import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistoAdminController {

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/registo_admin")
    public String RegistoAdmin(){
        return "registo_admin";
    }

    @PostMapping(value = "/registo_admin")
    public String addNovoFuncionario (@RequestParam String nome, @RequestParam String username, @RequestParam String email, @RequestParam String role, @RequestParam String password, @RequestParam String especialidade) {
        usersService.addFuncionario(nome, username, email, role, password, especialidade);
        return "redirect:/login";
    }

}
