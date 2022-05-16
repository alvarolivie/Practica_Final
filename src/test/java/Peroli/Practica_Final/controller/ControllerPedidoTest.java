package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.repository.RepositoryPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import Peroli.Practica_Final.model.Momento;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPedido;
import Peroli.Practica_Final.repository.RepositoryUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;

import static org.assertj.core.api.BDDAssertions.then;

import java.time.LocalDate;
import java.util.Iterator;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerPedidoTest {
    @LocalServerPort
    private int port;

    @Autowired
    private RepositoryPedido repositoryPedido;

    @Autowired
    private TestRestTemplate restTemplate;

   /* @Test
    public void clientPostTest() {

        Pedido pedido = new Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","626298810",12,1, LocalDate.of(2023, 1, 1), Momento.CENA,"Madrid","Calle Serrano 14");

        String url = "http://localhost:" + Integer.toString(port) + "/ElPeroli/v1/client/newPedido";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic UGVkcm86MTIzNDU=");
        HttpEntity<Pedido> entity = new HttpEntity<>(pedido, headers);


        ResponseEntity<Pedido> result = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<Pedido>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);

    }*/




}
