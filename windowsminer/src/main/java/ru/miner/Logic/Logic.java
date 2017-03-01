package ru.miner.Logic;

import ru.miner.Fields.Cell;

/**
 * Created by Alexey Davydov.
 */
public interface Logic {
    /**
     * загружаем поле
     */
    void loadField(Cell[][] cells);

    /**
     * взорвется ли поле или нет, т.е. логика программы
     */
    boolean explodeField(int x, int y);

    /**
     * поле разминировано или нет
     */
    boolean finish();

    /**
     * событие от пользвателя
     */
    void event(int x, int y, boolean bomb);
}
