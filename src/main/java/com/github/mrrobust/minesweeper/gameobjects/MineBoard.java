package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Location;
import com.github.mrrobust.gameframework.ObjectDisplay;
import com.github.mrrobust.gameframework.UserInterface;
import com.github.mrrobust.minesweeper.MineSweeper;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MineBoard extends UserInterface {

    protected int iconSize = 24;
    protected int width;
    protected int height;

    public MineBoard(MineSweeper game) {

        super(game);

        width = game.GetSetup().GetColons() * iconSize;
        height = game.GetSetup().GetRows() * iconSize;
        initBoard();

    }

    private void initBoard() {

        ArrayList<ObjectDisplay> batch = new ArrayList<ObjectDisplay>();
        batch.add(((MineSweeper)game).GetFieldDisplay());
        batch.add(((MineSweeper)game).GetSelectorDisplay());
        PutDisplayBatch(batch);
        setPreferredSize(new Dimension(width, height));

    }

    @Override
    protected void OnMouseMove(MouseEvent e) {

        super.OnMouseMove(e);

        int x = e.getX();
        int y = e.getY();

        Selector selector = ((MineSweeper)game).selector;
        selector.setLocation(
                new Location(
                        x / Selector.DisplayData.getIconSize(),
                        y / Selector.DisplayData.getIconSize()));

        repaint();

    }

}
