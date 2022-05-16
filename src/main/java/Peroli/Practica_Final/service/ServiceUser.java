package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.ArrayList;
import java.util.Set;

public interface ServiceUser extends UserDetailsService {

    boolean checkCredentials(User user);

    ArrayList<Long> getRoles(String username);
}
