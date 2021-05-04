package Agrupo5.upskill.agrupo5.upskill.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordServiceImpl implements PasswordService {



    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(-1, new SecureRandom("GRUPO5".getBytes()));


    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isSamePassword(String encryptedPassword, String password) {
        return passwordEncoder.matches(password, encryptedPassword);
    }
}
