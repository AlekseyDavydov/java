package ru.itis.dao;

import ru.itis.models.Auto;

import java.util.List;

public interface AutoDao {
    List<Auto> getAutos();

    Auto findAuto(int id);

    boolean update(Auto auto);

    boolean deleteAuto(int id);

    int saveAuto(Auto auto);
}
