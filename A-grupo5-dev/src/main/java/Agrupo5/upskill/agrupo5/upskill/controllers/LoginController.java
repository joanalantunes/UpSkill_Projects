package Agrupo5.upskill.agrupo5.upskill.controllers;

import Agrupo5.upskill.agrupo5.upskill.entities.Login;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.RoleRepository;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import Agrupo5.upskill.agrupo5.upskill.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
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
import java.util.List;


@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = {"/login", "/"})
    public ModelAndView loginPage() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("login", new Login());
            return mav;
        }

        for(GrantedAuthority authority: authentication.getAuthorities()) {
            String role = authority.getAuthority();
            ModelAndView mav = null;


            if (role.equals("Utente")) {
                mav = new ModelAndView("redirect:/inicio_utente");
            } else if (role.equals("Médico")) {
                mav = new ModelAndView("redirect:/inicio_medico");
            } else if (role.equals("Responsável de Unidade")) {
                mav = new ModelAndView("redirect:/inicio_respunidade");
            } else if (role.equals("Funcionário")) {
                mav = new ModelAndView("redirect:/inicio_funcionario");
            }

            if (mav != null) {
                User user =userRepository.findByUsername((String) authentication.getPrincipal());
                //mav.addObject("username", login.getUsername());
                //mav.addObject("user", user);

                mav.setViewName(mav.getViewName()+"/"+user.getId());

                return mav;
            }
        }

        return null;

    }


    @PostMapping(value = {"/login"})
    public ModelAndView loginClicked(@ModelAttribute("login") Login login) {
        Role role = loginService.validateLogin(login);

        if (role == null) {
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("errorMessage", "Invalid Credentials");
            return mav;
        }

        ModelAndView mav;


        if (role.getName().equals("Utente")) {
            mav = new ModelAndView("redirect:/inicio_utente");
        } else if (role.getName().equals("Médico")) {
            mav = new ModelAndView("redirect:/inicio_medico");
        } else if (role.getName().equals("Responsável de Unidade")) {
            mav = new ModelAndView("redirect:/inicio_respunidade");

        } else if (role.getName().equals("Funcionário")) {
            mav = new ModelAndView("redirect:/inicio_funcionario");
        } else {
            mav = new ModelAndView("login");
            mav.addObject("errorMessage", "Invalid Credentials");
            return mav;
        }




        User user =userRepository.findByUsername(login.getUsername());
        //mav.addObject("username", login.getUsername());
        //mav.addObject("user", user);

        mav.setViewName(mav.getViewName()+"/"+user.getId());

        Authentication authentication =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(role.getName())));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Para o logout
        //SecurityContextHolder.getContext().setAuthentication(null);


        return mav;
    }
}




