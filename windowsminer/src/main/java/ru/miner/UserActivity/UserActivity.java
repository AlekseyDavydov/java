package ru.miner.UserActivity;

/**
 * Created by Alexey Davydov.
 */
public interface UserActivity {
    void init();

    void select(int x, int y, boolean bomb);
}
