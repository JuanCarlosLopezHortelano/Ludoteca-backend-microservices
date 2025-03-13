package com.ccsw.tutorial_prestamo.client;

import com.ccsw.tutorial_prestamo.client.model.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "SPRING-CLOUD-EUREKA-CLIENT-CLIENT", url = "http://localhost:8080")
public interface ClientClient {

    @GetMapping(value = "/client")
    List<ClientDto> findAll();
}
