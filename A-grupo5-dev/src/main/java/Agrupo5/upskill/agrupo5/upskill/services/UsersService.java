package Agrupo5.upskill.agrupo5.upskill.services;
import Agrupo5.upskill.agrupo5.upskill.entities.User;

import java.util.List;

public interface UsersService {

        List<User> getUsers();

        User getUserById(Long id);

        User getUserByUsername(String username);

        User updateUser(User user);

        void deleteUser(Long id);

        void createUser(User user);

        void addFuncionario (String nome, String username, String email, String role, String password, String especialidade);


    }
