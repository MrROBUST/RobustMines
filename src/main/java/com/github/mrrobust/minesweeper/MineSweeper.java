package com.github.mrrobust.minesweeper;

import com.github.mrrobust.gameframework.ObjectDisplay;
import com.github.mrrobust.gameframework.Game;
import com.github.mrrobust.minesweeper.gameobjects.Field;
import com.github.mrrobust.minesweeper.gameobjects.MineSweeperSetup;
import com.github.mrrobust.minesweeper.gameobjects.MineBoard;
import com.github.mrrobust.minesweeper.gameobjects.Selector;

public class MineSweeper extends Game {

    {
        title = "RobustMines";
    }

    private MineSweeperSetup setup;

    public MineSweeperSetup GetSetup() {
        return setup;
    }

    private Field field;
    public ObjectDisplay GetFieldDisplay() { return field.getDisplay(); }

    public Selector selector;
    public ObjectDisplay GetSelectorDisplay() { return selector.getDisplay(); }

    public MineSweeper(int colons, int rows, int mines) {

        setup = new MineSweeperSetup(colons, rows, mines);
        field = new Field(setup);
        selector = new Selector();
        component = new MineBoard(this);

    }

}
