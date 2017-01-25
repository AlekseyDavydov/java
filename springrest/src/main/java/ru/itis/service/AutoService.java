package ru.itis.service;

import ru.itis.models.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAutos();
    boolean deleteAuto(int id);
    boolean update(Auto auto);
    int saveAuto(Auto auto);
    Auto findAuto(int id);
}
