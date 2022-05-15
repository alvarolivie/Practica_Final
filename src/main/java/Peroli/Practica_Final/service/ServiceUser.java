package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.User;

import java.util.Set;

public interface ServiceUser {

    boolean checkCredentials(User user);

    Set getRoles(String username);
}
