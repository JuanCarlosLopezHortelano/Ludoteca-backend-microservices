package com.ccsw.tutorial_client.client;

import com.ccsw.tutorial_client.client.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Optional<Client> findByName(String name);
}
