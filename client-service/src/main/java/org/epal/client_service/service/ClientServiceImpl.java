package org.epal.client_service.service;

import client.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    static List<Client> list = new ArrayList<>();

    @Override
    public List<Client> findAll() {
        list.add(new Client(1L, "client-1"));
        list.add(new Client(2L, "client-1"));
        return list;
    }

    @Override
    public Client find(Long id) {
        return null;
    }

    @Override
    public Client save(Client user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Client user) {

    }
}
