package ru.itis.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.UsersDao;
import ru.itis.models.User;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public User getUser(int id) {
        return usersDao.find(id);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

    public boolean delete(int id) {
        return usersDao.delete(id);
    }

    public int save(User user) {
        return usersDao.save(user);
    }

    public boolean update(User user) {
        return usersDao.update(user);
    }

    public boolean isRegistered(String login) {
        List<User> users = usersDao.findAll();
        for (User user : users) {
            if (user.getName().equals(login)) {
                return true;
            }
        }
        return false;
    }
}
