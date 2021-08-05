package org.epal.client_service.service;

import org.epal.client_service.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User find(Long id);

    User save(User user);

    void delete(Long id);

    void delete(User user);

}
