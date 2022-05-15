package Peroli.Practica_Final.service;


import Peroli.Practica_Final.model.Arroz;
import Peroli.Practica_Final.repository.RepositoryArroz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceArrozImpl implements ServiceArroz {

    @Autowired
    private RepositoryArroz repoArroz;

    @Override
    public Arroz getArroz(Long id){
        Optional<Arroz> arroz=repoArroz.findById(id);
        Arroz arrozFound=null;
        if (arroz.isPresent()){
            arrozFound=arroz.get();

        }
        return arrozFound;

    }
}
