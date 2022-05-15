package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface ServiceUser extends UserDetailsService {

    boolean checkCredentials(User user);

    Set getRoles(String username);
}
