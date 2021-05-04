package Agrupo5.upskill.agrupo5.upskill.services;

public interface PasswordService {

    String encryptPassword(String password);

    boolean isSamePassword(String encryptedPassword, String password);
}
