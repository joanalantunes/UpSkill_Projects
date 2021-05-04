package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Login;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;

import java.util.List;

public interface LoginService {

    Role validateLogin(Login login);
}
