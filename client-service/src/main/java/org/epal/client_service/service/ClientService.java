package org.epal.client_service.service;


import org.epal.commons.client.model.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();

    Client find(Long id);

    Client save(Client user);

    void delete(Long id);

    void delete(Client user);

}
