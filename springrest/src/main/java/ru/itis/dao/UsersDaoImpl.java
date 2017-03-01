package ru.itis.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.models.User;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDaoImpl implements UsersDao {

    // language=SQL
    private static final String SQL_INSERT_USERS =
            "INSERT INTO group_users( name, age) VALUES ( :userName, :userAge)";

    // language=SQL
    private static final String SQL_DELETE_USER =
            "DELETE FROM group_users WHERE id =:userId";


    // language=SQL
    private static final String SQL_UPDATE_USER =
            "UPDATE group_users SET name =:name, age=:age WHERE  id=:userId";

    private NamedParameterJdbcTemplate template;

    @Autowired
    public UsersDaoImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public User find(int id) {
        Session session = getSession();
        session.beginTransaction();
        User user = session.createQuery("from User user where id = :userId", User.class)
                .setParameter("userId", id).getSingleResult();
        session.getTransaction().commit();
        return user;
    }

    @Override
    public List<User> findAll() {
        Session session = getSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User", User.class).list();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public boolean delete(int id) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("userId", id);
        if (template.update(SQL_DELETE_USER, paramsMap) == 1) return true;
        return false;
    }

    @Override
    public boolean update(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("name", user.getName());
        paramsMap.put("age", user.getAge());
        paramsMap.put("userId", user.getId());
        if (template.update(SQL_UPDATE_USER, paramsMap) == 1) return true;
        return false;
    }

    @Override
    public int save(User user) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("userId", user.getId());
        paramsMap.put("userName", user.getName());
        paramsMap.put("userAge", user.getAge());
        int rows = template.update(SQL_INSERT_USERS, paramsMap);
        return rows;
    }
}
