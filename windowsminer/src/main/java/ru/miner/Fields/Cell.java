package ru.miner.Fields;

/**
 * Created by Alexey Davydov.
 */
public interface Cell<T> {
    /**
     * находится ли в данной ячейке  бомба
     */
    boolean isBomb();

    /**
     * игрок предположил, что в данной ячейку бомба
     */
    boolean isBombCell();

    /**
     * игрок предположил, что данная ячейка пустая
     */
    boolean isEmptyCell();

    /**
     * устанавливаем значение, что в ячейке бомба
     */
    void BombCell();

    /**
     * устанавливаем значение пустой ячейки
     */
    void EmptyCell();

    /**
     * рисуем ячейку
     */
    void draw(T point, boolean real);
}
