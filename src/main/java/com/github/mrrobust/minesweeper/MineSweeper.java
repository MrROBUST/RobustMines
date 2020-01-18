package com.github.mrrobust.minesweeper;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.Game;
import com.github.mrrobust.minesweeper.gameobjects.*;

import java.util.ArrayList;

public class MineSweeper extends Game {

    {
        title = "RobustMines";
    }

    private MineSweeperSetup setup;

    public MineSweeperSetup GetSetup() {
        return setup;
    }

    private Field field;
    public Selector selector;

    public MineSweeper(int colons, int rows, int mines) {

        setup = new MineSweeperSetup(colons, rows, mines);
        field = new Field(setup);
        selector = new Selector();
        userInterface = new MineSweeperUI(this);

        ArrayList<Displayable> displays = new ArrayList<Displayable>();
        displays.add(field);
        displays.add(selector);
        ((MineSweeperUI)userInterface).PutDisplayBatch(displays);

    }

}
