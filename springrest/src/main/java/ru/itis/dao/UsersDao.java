package ru.itis.dao;

import ru.itis.models.User;

import java.util.List;

public interface UsersDao {
    List<User> findAll();

    boolean update(User user);

    boolean delete(int id);

    User find(int id);

    int save(User user);
}
