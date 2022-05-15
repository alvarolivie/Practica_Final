package Peroli.Practica_Final.service;

import Peroli.Practica_Final.model.RoleRef;
import Peroli.Practica_Final.model.User;
import Peroli.Practica_Final.repository.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

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

    @Override
    public Set<RoleRef> getRoles(String username){
        System.err.println(repoUser.findById(username).get().getRoles());
        return repoUser.findById(username).get().getRoles();

    }

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = repoUser.findById(username).get();
        UserDetails newUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword() , (Collection<? extends GrantedAuthority>) user.getRoles());
        return newUser;
    }
}
