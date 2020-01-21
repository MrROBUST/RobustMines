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

    public MineSweeper() {

        setup = new MineSweeperSetup(16, 16, 40);
        userInterface = new MineSweeperUI(this);
        Start();
    }

    @Override
    public void Start() {
        super.Start();

        field = new Field(setup);
        selector = new Selector();

        ArrayList<Displayable> displays = new ArrayList<Displayable>();
        displays.add(field);
        displays.add(selector);
        ((MineSweeperUI)userInterface).PutDisplayBatch(displays);

    }

    @Override
    public void Restart() {
        super.Restart();
    }
}
