package Agrupo5.upskill.agrupo5.upskill.services;

import Agrupo5.upskill.agrupo5.upskill.entities.*;
import Agrupo5.upskill.agrupo5.upskill.repositories.EspecialidadeRepository;
import Agrupo5.upskill.agrupo5.upskill.repositories.MedicoRepository;
import Agrupo5.upskill.agrupo5.upskill.repositories.RoleRepository;
import Agrupo5.upskill.agrupo5.upskill.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
//@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    PasswordService passwordService;

    @Override
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addFuncionario(String nome, String username, String email, String roleName, String password, String especialidadeName) {
        Role role = roleRepository.findByName(roleName);

        User novoUser = new User(nome, email, username, passwordService.encryptPassword(password));
        novoUser.setRole(role);
        userRepository.save(novoUser);

        if (roleName.equals("Médico")){
            Especialidade especialidade = especialidadeRepository.findByNome(especialidadeName);
            Medico novoMedico = new Medico(novoUser);
            novoMedico.setEspecialidades(new HashSet(Arrays.asList(especialidade)));
            novoMedico.setUser(novoUser);
            medicoRepository.save(novoMedico);
        }
    }

}
