package ru.miner.Fields;

/**
 * Created by Alexey Davydov
 */
public interface Field {
    /**
     * Рисуем поле
     */
    void drawField(Cell[][] cells);

    /**
     * Рисуем ячейку
     */
    void drawCell(int x, int y);

    /**
     * Взрыв всех ячеек
     */
    void explodedCells();

    /**
     * Вы прошли уровень
     */
    void nextLevel();
}
