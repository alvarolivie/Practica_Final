package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.User;


import java.util.ArrayList;
import java.util.Set;

public interface ServiceUser {

    boolean checkCredentials(User user);

    ArrayList<Long> getRoles(String username);
}
