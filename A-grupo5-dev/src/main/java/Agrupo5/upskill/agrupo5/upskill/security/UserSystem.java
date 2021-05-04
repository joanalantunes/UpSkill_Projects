package Agrupo5.upskill.agrupo5.upskill.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class UserSystem extends User {

    private Long id;

    private String nome;

    public UserSystem(String nome, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);

        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
