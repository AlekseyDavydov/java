package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dao.AutoDao;
import ru.itis.models.Auto;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
      private AutoDao autoDao;

    public List<Auto> getAutos() {
        return autoDao.getAutos();
    }

    public boolean deleteAuto(int id) {
        return autoDao.deleteAuto(id);
    }

    public boolean update(Auto auto) {
        return autoDao.update(auto);
    }

    public int saveAuto(Auto auto) {
        return autoDao.saveAuto(auto);
    }

    public Auto findAuto(int id) {
        return autoDao.findAuto(id);
    }
}
