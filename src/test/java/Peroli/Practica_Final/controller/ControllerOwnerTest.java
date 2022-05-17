package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Momento;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPedido;
import Peroli.Practica_Final.repository.RepositoryUser;
import org.junit.jupiter.api.Test;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerOwnerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private RepositoryPedido repositoryPedido;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void pedidosGetTest() {
        Iterable<Pedido> pedidos = repositoryPedido.findAll();

        String url = "http://localhost:" + Integer.toString(port) + "/elPeroli/v1/owner/viewPedidos";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWx2YXJvOmFsdmFybzEyMw==");
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<Iterable<Pedido>> result = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<Iterable<Pedido>>(){}
        );

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(pedidos);
    }




}
