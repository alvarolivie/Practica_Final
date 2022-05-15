package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Arroz;
import Peroli.Practica_Final.service.ServiceArroz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("elPeroli/v1/arroz/")
public class ControllerArroz {

    @Autowired
    private ServiceArroz serviceArroz;

    @GetMapping("/loadArroz/{id}")
    public ResponseEntity<Arroz> loadArroz(@PathVariable(value = "id") Long id){
        Arroz arroz=serviceArroz.getArroz(id);
        return ResponseEntity.ok().body(arroz);
    }

}
