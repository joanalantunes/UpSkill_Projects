package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.xml.bind.ValidationException;
import java.util.List;

@Service
public class ValidationServiceImpl implements ValidationService{

    //Registo

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean validateNome(String nome)  {
       //throw new ValidationException("O Nome não é válido.");
            return nome.matches("^[^0-9]+$");
    }

    @Override
    public boolean validateUsername(String username)  {
        //throw new ValidationException("Esse Username não é válido.");

            return username.matches("^(?=.*\\d)(?=.*[a-z]).{3,}$");
    }

    @Override
    public boolean validateUsernameSame(String username) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                //throw new ValidationException("Esse Username já existe.");
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validateEmail(String email) {
        // throw new ValidationException("Esse Email não é válido.");
        return email.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    }

    @Override
    public boolean validateEmailSame(String email){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                //throw new ValidationException("Esse Email já tem uma conta associada.");
                return false;
            }

        }
        return true;
    }

    @Override
    public boolean validatePassword(String password){
        //throw new ValidationException("Essa Password não é válida.");
        return password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");

    }
    @Override
    public boolean validatePassword2(String password, String password2) {
        // throw new ValidationException("A Password não corresponde à sua confirmação.");
        return password2.equals(password);
    }

    //Campos de Perfil (números de documentos, verificar o role e depois o ciclo que percorre a base de dados)
    
    @Override
    public boolean validateDocumentNumberAndRoleDif(String numeroDocumento, Role role) {
        if (numeroDocumento == null || StringUtils.isEmpty(numeroDocumento)) {
            return true;
        }

        User user = userRepository.findByNumeroDocumento(numeroDocumento);
        if (user != null && user.getRole().equals(role)) {
            if (user.getNumeroDocumento() != null && user.getNumeroDocumento().equals(numeroDocumento)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean validateNif(String nif) {
        if (nif == null || StringUtils.isEmpty(nif)) {
            return true;
        }

        User user = userRepository.findByNif(nif);
        if (user != null) {
            return false;
        }

        return true;
    }
}
