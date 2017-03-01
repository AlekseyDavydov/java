package ru.miner.Logic;

import ru.miner.Fields.Cell;

/**
 * Created by Alexey Davydov.
 */
public class LogicImpl implements Logic {
    private Cell[][] cells;

    public void loadField(Cell[][] cells) {
        this.cells = cells;
    }

    public boolean explodeField(int x, int y) {
        Cell select = this.cells[x][y];
        return select.isBombCell() && !select.isEmptyCell();
    }

    public boolean finish() {
        boolean finish = false;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                finish = ((cell.isBombCell() && cell.isBomb()) ||
                        (cell.isEmptyCell() && !cell.isBomb()));
            }
        }
        return finish;
    }

    public void event(int x, int y, boolean bomb) {
        if (bomb) {
            cells[x][y].BombCell();
        } else {
            cells[x][y].EmptyCell();
        }
    }
}
