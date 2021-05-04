package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Role;

import javax.xml.bind.ValidationException;

public interface ValidationService {

    boolean validateNome(String nome);

    boolean validateUsername(String username);

    boolean validateUsernameSame(String username);

    boolean validateEmail(String email) ;

    boolean validateEmailSame(String email);

    boolean validatePassword(String password) ;

    boolean validatePassword2(String password, String password2);

    boolean validateDocumentNumberAndRoleDif(String numeroDocumento, Role role);

    boolean validateNif(String nif);
}
