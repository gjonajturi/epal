package org.epal.client_service.service;

import client.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    static List<User> list = new ArrayList<>();

    @Override
    public List<User> findAll() {
        list.add(new User(1L, "username", "password", "firstname", "lastname"));
        list.add(new User(2L, "username2", "password", "firsname", "lastname"));
        return list;
    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        list.add(user);
        return user;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(User user) {

    }
}
