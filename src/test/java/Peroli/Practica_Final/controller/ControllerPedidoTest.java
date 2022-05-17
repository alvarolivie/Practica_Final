package Peroli.Practica_Final.controller;

import Peroli.Practica_Final.model.Estado;
import Peroli.Practica_Final.model.Momento;
import Peroli.Practica_Final.model.Pedido;
import Peroli.Practica_Final.repository.RepositoryPedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerPedidoTest {

    @Autowired
    private RepositoryPedido repositoryPedido;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void clientPostTest() {
        //Given
        String address = "http://localhost:" + port + "/elPeroli/v1/cliente/newPedido";

        //Request
        Pedido pedido = new Pedido("ale@gmail.com","Alejandra","626298810",12,1, LocalDate.of(2023, 1, 1), Momento.CENA,"Madrid","Calle Serrano 14");
        //HttpHeaders headers = new HttpHeaders();
        //headers.add("Authorization", "Basic dXNlcjE6cXdlcnR5MTIz");
        HttpEntity<Pedido> request = new HttpEntity<>(pedido);

        //When
        ResponseEntity<Pedido> result = restTemplate.exchange(address,HttpMethod.POST, request, new ParameterizedTypeReference<Pedido>(){});


        Iterable<Pedido> userList = repositoryPedido.findAll();
        Iterator<Pedido> iterator = userList.iterator();
        Pedido last = null;

        while(iterator.hasNext()){
            last = (Pedido) iterator.next();
        }
       pedido.setId(last.getId());
       pedido.setPrecio(last.getPrecio());
       pedido.setEstado(last.getEstado());

        //Then
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(last);
        then(result.getBody()).isEqualTo(pedido);



    }




}
