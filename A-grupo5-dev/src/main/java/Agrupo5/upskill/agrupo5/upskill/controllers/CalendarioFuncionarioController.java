package Agrupo5.upskill.agrupo5.upskill.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarioFuncionarioController {
    @GetMapping(value = "/calendario_funcionario")
    public String calendario_funcionario(){
        return "calendario_funcionario";
    }
}

