package org.epal.client_service.service;


import client.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User find(Long id);

    User save(User user);

    void delete(Long id);

    void delete(User user);

}
