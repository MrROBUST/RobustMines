package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Location;
import com.github.mrrobust.gameframework.UserInterface;
import com.github.mrrobust.minesweeper.MineSweeper;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class MineSweeperUI extends UserInterface {

    protected int iconSize = 24;
    protected int width;
    protected int height;

    public MineSweeperUI(MineSweeper game) {

        super(game);

        width = game.GetSetup().GetColons() * iconSize;
        height = game.GetSetup().GetRows() * iconSize;
        initBoard();

    }

    private void initBoard() {

        setPreferredSize(new Dimension(width, height));

    }

    @Override
    protected void OnMouseMove(MouseEvent e) {

        super.OnMouseMove(e);

        int x = e.getX();
        int y = e.getY();

        Selector selector = ((MineSweeper) game).selector;
        selector.setLocation(new Location(
                x / iconSize,
                y / iconSize));

        repaint();

    }

    @Override
    protected void OnMouseClick(MouseEvent e) {

        super.OnMouseClick(e);

        int x = e.getX();
        int y = e.getY();

        Location loc = new Location(x / iconSize, y / iconSize);

        Selector selector = ((MineSweeper) game).selector;
        selector.setLocation(loc);

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                ((MineSweeper) game).MakeTurn(loc, MineSweeper.Turn.RevealCell);
                break;
            case MouseEvent.BUTTON3:
                ((MineSweeper) game).MakeTurn(loc, MineSweeper.Turn.PutFlag);
                break;
        }

        repaint();

    }

    @Override
    protected void OnKeyPressed(KeyEvent e) {

        super.OnKeyPressed(e);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_F2:
                game.Restart();
                break;
        }

        repaint();
    }

}
