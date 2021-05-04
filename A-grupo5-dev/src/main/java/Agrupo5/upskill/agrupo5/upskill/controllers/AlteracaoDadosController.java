package Agrupo5.upskill.agrupo5.upskill.controllers;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import Agrupo5.upskill.agrupo5.upskill.services.ValidationService;
import Agrupo5.upskill.agrupo5.upskill.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class AlteracaoDadosController {

    @Autowired
    ValidationService validationService;

    @Autowired
    UsersService usersService;

    @Autowired
    UserRepository userRepository;

    private void updateUser(Long id, User user, ModelMap map, MultipartFile multipartFile) throws IOException {
        User dbUser = usersService.getUserById(id);
        user.setPassword(dbUser.getPassword());
        user.setUsername(dbUser.getUsername());
        user.setRole(dbUser.getRole());

        if (multipartFile != null) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            if (!StringUtils.isEmpty(fileName)) {
                user.setPhoto(fileName);

                String uploadDir = "user-photos/" + id;

                FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
            }
            else {
                user.setPhoto(null);
            }
        } else {
            user.setPhoto(null);
        }

        //------------------------------------------Validação DocumentNumber---------------------------------


        if (validationService.validateDocumentNumberAndRoleDif(user.getNumeroDocumento(), user.getRole()) /* && option is selected */) {
            user.setNumeroDocumento(user.getNumeroDocumento());
        } else {
            user.setNumeroDocumento(dbUser.getNumeroDocumento());
        }
        //-------------------------------------Fim de validação DocumentNumber------------------------------

         if (validationService.validateNif(user.getNif())) {
             user.setNif(user.getNif());
         } else {
             user.setNif(dbUser.getNif());
         }

        dbUser = usersService.updateUser(user);
        map.put("user", dbUser);
    }

     @GetMapping(value = "/alteracao_dados_utente/{id}")
     public String showDadosUtentePage(@PathVariable Long id, ModelMap map){
         map.put("user", usersService.getUserById(id));
         return "alteracao_dados_utente";
     }

     @PostMapping (value = "/alteracao_dados_utente/{id}")
     public String postDadosUtenteUser(@PathVariable Long id, @ModelAttribute User user, ModelMap map, @RequestParam("image") MultipartFile multipartFile) throws IOException {
         this.updateUser(id, user, map, multipartFile);
         return "redirect:/inicio_utente/"+id;
     }


    @GetMapping(value = "/alteracao_dados_funcionario/{id}")
    public String showDadosFuncionarioPage(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        return "alteracao_dados_funcionario";
    }

    @PostMapping(value = "/alteracao_dados_funcionario/{id}")
    public String postDadosFuncionarioUser(@PathVariable Long id, @ModelAttribute User user, ModelMap map,@RequestParam("image") MultipartFile multipartFile) throws IOException {
        this.updateUser(id, user, map, multipartFile);

        return "redirect:/inicio_funcionario/"+id;
    }

    @GetMapping(value = "/alteracao_dados_medico/{id}")
    public String showDadosMedicoPage(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        return "alteracao_dados_medico";
    }

    @PostMapping(value = "/alteracao_dados_medico/{id}")
    public String postDadosMedicoUser(@PathVariable Long id, @ModelAttribute User user, ModelMap map, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        this.updateUser(id, user, map, multipartFile);

        return "redirect:/inicio_medico/"+id;
    }

    @GetMapping(value = "/alteracao_dados_respunidade/{id}")
    public String showDadosRespUnidadePage(@PathVariable Long id, ModelMap map){
        map.put("user", usersService.getUserById(id));
        return "alteracao_dados_respunidade";
    }

    @PostMapping(value = "/alteracao_dados_respunidade/{id}")
    public String postDadosRespUnidadeUser(@PathVariable Long id, @ModelAttribute User user, ModelMap map, @RequestParam("image") MultipartFile multipartFile) throws IOException {
        this.updateUser(id, user, map, multipartFile);

        return "redirect:/inicio_respunidade/"+id;
    }

}
