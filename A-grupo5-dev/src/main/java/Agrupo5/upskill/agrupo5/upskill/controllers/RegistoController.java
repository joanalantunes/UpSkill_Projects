package Agrupo5.upskill.agrupo5.upskill.controllers;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.RoleRepository;
import Agrupo5.upskill.agrupo5.upskill.services.PasswordService;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import Agrupo5.upskill.agrupo5.upskill.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistoController {

    @Autowired
    ValidationService validationService;

    @Autowired
    UsersService userService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordService passwordService;

    @GetMapping(value = "/registo")
    public String registo(){
        return "registo";
    }

    @PostMapping(value = "/registo")
    public ModelAndView validateSignUp(ModelMap map, @RequestParam String nome, @RequestParam String username, @RequestParam String email, @RequestParam String password, @RequestParam String password2){

        ModelAndView mav = new ModelAndView("/registo");

        if (!validationService.validateNome(nome)){
            mav.addObject("errorMessageNome","O Nome não é válido.");
            return mav;
        }

        if (!validationService.validateUsername(username)){
            mav.addObject("errorMessageUsername","Esse Username não é válido.");
            return mav;
        }

        if (!validationService.validateUsernameSame(username)) {
            mav.addObject("errorMessageUserSame", "Esse Username já existe.");
            return mav;
        }

        if(!validationService.validateEmail(email)){
            mav.addObject("errorMessageEmail","Esse Email não é válido.");
            return mav;
        }

        if(!validationService.validateEmailSame(email)){
            mav.addObject("errorMessageEmailSame","Esse Email já tem uma conta associada.");
            return mav;
        }

        if(!validationService.validatePassword(password)){
            mav.addObject("errorMessagePass01","Mínimo de 8 caracteres, uma letra maiúscula e minuscula");
            mav.addObject("errorMessagePass02"," e um número. Não pode conter caracteres especiais.");
            return mav;
        }

        if(!validationService.validatePassword2(password, password2)){
            mav.addObject("errorMessagePass2","A Password não corresponde à sua confirmação.");
            return mav;
        }

        User user = new User(nome,email,username,passwordService.encryptPassword(password));

        Role role = roleRepository.findByName("Utente");
        user.setRole(role);

        userService.createUser(user);

        return new ModelAndView("/login");
    }

}
