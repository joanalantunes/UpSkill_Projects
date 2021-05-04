package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.Login;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.entities.User;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordService passwordService;

    @Override
    public Role validateLogin(Login login) {
        String username = login.getUsername();

        User user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }


        if (!passwordService.isSamePassword(user.getPassword(), login.getPassword())) {
            return null;
        }

        return user.getRole();
    }
}
