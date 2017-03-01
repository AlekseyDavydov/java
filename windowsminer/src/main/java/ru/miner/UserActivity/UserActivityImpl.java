package ru.miner.UserActivity;


import ru.miner.Fields.CreateField;
import ru.miner.Fields.Field;
import ru.miner.Fields.Cell;
import ru.miner.Logic.Logic;

/**
 * Created by Alexey Davydov.
 */
public class UserActivityImpl implements UserActivity {
    private Logic logic;
    private Field field;
    private CreateField createField;

    public UserActivityImpl(Logic logic, Field field, CreateField createField) {
        this.logic = logic;
        this.field = field;
        this.createField = createField;
    }

    public void init() {
        Cell[][] cells = createField.create();
        this.field.drawField(cells);
        this.logic.loadField(cells);
    }

    public void select(int x, int y, boolean bomb) {
        logic.event(x,y,bomb);
        field.drawCell(x, y);
        if (logic.explodeField(x, y)){
            field.explodedCells();
        }
        if (logic.finish()) {
            field.nextLevel();
        }
    }
}
