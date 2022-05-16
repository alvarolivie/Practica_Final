package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.User;
import Peroli.Practica_Final.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceUserImpl implements ServiceUser{

    @Autowired
    private RepositoryUser repoUser;

    @Override
    public boolean checkCredentials(User user){
        Optional<User> user1=repoUser.findById(user.getUsername());
        if (user1.isPresent()){
            User userFound=user1.get();
            if(user.getPassword().equals(userFound.getPassword())){
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }


    }

    public ArrayList<Long> getRoles(String username){
        ArrayList<Long> roles = new ArrayList<>();
        repoUser.findById(username).get().getRoles().forEach(role -> roles.add(role.getRoleId()));
        return roles;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = repoUser.findById(username).get();
        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        user.getRoles().forEach(role -> roles.add(new SimpleGrantedAuthority(role.getRoleId().toString())));
        UserDetails newUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword() , roles);
        return newUser;
    }
}
