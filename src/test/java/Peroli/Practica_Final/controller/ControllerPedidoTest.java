package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Estado;
import Peroli.Practica_Final.model.Momento;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerPedidoTest {
    @LocalServerPort
    private int port;

    @Autowired
    private RepositoryPedido repositoryPedido;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void clientPostTest() {
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1";

        //Request
        //Pedido example = new Pedido(Long.valueOf("4"),"ale@gmail.com","Alejandra","626298810",12,1, LocalDate.of(2023, 1, 1), Momento.CENA,"Madrid","Calle Serrano 14", BigDecimal.valueOf(0.0), Estado.ACEPTADA);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic dXNlcjE6cXdlcnR5MTIz");
        //HttpEntity<Pedido> request = new HttpEntity<>(example, headers);

        //When
        //ResponseEntity<Pedido> result = restTemplate.postForEntity(address, request, Pedido.class);

        //Then
       // then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        //then(result.getBody()).isEqualTo(example);

    }




}
