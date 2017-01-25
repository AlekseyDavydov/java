package ru.itis.service;


import ru.itis.models.User;

import java.util.List;

public interface UsersService {
    User getUser(int id);

    boolean isRegistered(String login);

    List<User> findAll();

    boolean update(User user);

    boolean delete(int id);

    int save(User user);

}
