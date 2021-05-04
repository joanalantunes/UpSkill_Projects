package Agrupo5.upskill.agrupo5.upskill.controllers;

import Agrupo5.upskill.agrupo5.upskill.entities.Login;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.RoleRepository;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import Agrupo5.upskill.agrupo5.upskill.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;


@Controller
public class LogoutController {

    @GetMapping(value = {"/logout"})
    public String logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return "redirect:/";
    }
}


