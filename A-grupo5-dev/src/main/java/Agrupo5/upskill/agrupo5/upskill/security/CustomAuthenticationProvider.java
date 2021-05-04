package Agrupo5.upskill.agrupo5.upskill.security;

import Agrupo5.upskill.agrupo5.upskill.entities.Login;
import Agrupo5.upskill.agrupo5.upskill.entities.Role;
import Agrupo5.upskill.agrupo5.upskill.services.LoginService;
import Agrupo5.upskill.agrupo5.upskill.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        Role role = loginService.validateLogin(login);

        if (role != null) {
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList(new SimpleGrantedAuthority(role.getName())));
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?>aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
