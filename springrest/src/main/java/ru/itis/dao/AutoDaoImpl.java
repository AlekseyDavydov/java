package ru.itis.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itis.models.Auto;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("JpaQlInspection")
public class AutoDaoImpl implements AutoDao {

    // language=SQL
    private static final String SQL_UPDATE_AUTO =
            "UPDATE group_auto SET model=:model, color=:color, user_id=:userId  WHERE id=:autoId";

    // language=SQL
    private static final String SQL_DELETE_AUTO =
            "DELETE FROM group_auto WHERE id =:autoId";

    //language=SQL
    private String SQL_INSERT_AUTO =
            "INSERT INTO group_auto (id,model, color, user_id) VALUES (:autoId, :model, :color, :userId)";

    private NamedParameterJdbcTemplate template;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public AutoDaoImpl(DataSource dataSource) {
        this.template = new NamedParameterJdbcTemplate(dataSource);
    }

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
    public List<Auto> getAutos() {
        Session session = getSession();
        session.beginTransaction();
        List<Auto> autos = session.createQuery("From Auto auto", Auto.class).list();
        session.getTransaction().commit();
        return autos;
    }

    @Override
    public Auto findAuto(int id) {
        Session session = getSession();
        session.beginTransaction();
        Auto auto = session.createQuery("from Auto auto where id = ?", Auto.class)
                .setParameter(0, id).getSingleResult();
        session.getTransaction().commit();
        return auto;
    }

    @Override
    public boolean update(Auto auto) {
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("model", auto.getModel());
        paramsMap.put("color", auto.getColor());
        paramsMap.put("userId", auto.getUser().getId());
        paramsMap.put("autoId", auto.getId());
        if (template.update(SQL_UPDATE_AUTO, paramsMap) == 1) return true;
        return false;
    }

    @Override
    public boolean deleteAuto(int id) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("autoId", id);
        int rows = template.update(SQL_DELETE_AUTO, paramsMap);
        if (rows == 1)
            return true;
        return false;
    }

    @Override
    public int saveAuto(Auto auto) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("autoId", auto.getId());
        paramMap.put("model", auto.getModel());
        paramMap.put("color", auto.getColor());
        paramMap.put("userId", auto.getUser().getId());
        int rows = template.update(SQL_INSERT_AUTO, paramMap);
        return rows;
    }

}
