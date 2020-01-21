package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


public class Field extends GameObject implements Displayable {

    public MineSweeperSetup setup;
    public Cell[][] cells;
    public Flag[][] flags;

    public Field(MineSweeperSetup setup) {
        this.setup = setup;

        cells = new Cell[setup.GetRows()][setup.GetColons()];
        flags = new Flag[setup.GetRows()][setup.GetColons()];

        InitializeField();
    }

    private static int getRandomNumberInRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    protected void InitializeField() {
        putCells();
        putMines();
        putLandMarks();
    }

    void putCells() {
        for (int cy = 0; cy < setup.GetRows(); ++cy) {
            for (int cx = 0; cx < setup.GetColons(); ++cx)
                cells[cx][cy] = new Cell();
        }
    }

    void putMines() {
        ArrayList<Cell> memo = new ArrayList<Cell>();
        for (int cy = 0; cy < setup.GetRows(); ++cy) {
            for (int cx = 0; cx < setup.GetColons(); ++cx)
                memo.add(cells[cx][cy]);
        }

        int cells = setup.GetColons() * setup.GetRows();
        int last_cell = cells - 1;
        int mines = Math.min(setup.GetMines(), last_cell);
        for (int i = 0; i < mines; ++i) {
            int rng = getRandomNumberInRange(i + 1, last_cell);
            Collections.swap(memo, i, rng);
            memo.get(i).content = new Mine();
        }
        if (mines < setup.GetMines())
            memo.get(last_cell).content = new Mine();
    }

    Boolean notInBounds(Location loc) {
        return
                loc.x() < 0 ||
                        loc.y() < 0 ||
                        loc.x() >= setup.GetColons() ||
                        loc.y() >= setup.GetRows();
    }

    Cell getCell(Location loc) {
        if (notInBounds(loc))
            return null;
        return cells[loc.x()][loc.y()];
    }

    Flag getFlag(Location loc) {
        if (notInBounds(loc))
            return null;
        return flags[loc.x()][loc.y()];
    }

    GameObject getCellContent(Location loc) {
        if (notInBounds(loc))
            return null;
        return getCell(loc).content;
    }

    GameObject getCellContent(Cell cell) {
        return cell.content;
    }

    private final Location[] neighbours = {
            new Location(-1, -1),
            new Location(0, -1),
            new Location(1, -1),
            new Location(-1, 0),
            new Location(1, 0),
            new Location(-1, 1),
            new Location(0, 1),
            new Location(1, 1),
    };

    int countNeighbourMines(Location loc) {
        int count = 0;
        for (int i = 0; i < neighbours.length; ++i) {
            GameObject neighbour = getCellContent(loc.Sum(neighbours[i]));
            if (neighbour != null && neighbour instanceof Mine)
                ++count;
        }
        return count;
    }

    void putLandMarks() {
        for (int cy = 0; cy < setup.GetRows(); ++cy) {
            for (int cx = 0; cx < setup.GetColons(); ++cx) {
                Location loc = new Location(cx, cy);
                Cell cell = getCell(loc);
                if (cell.content != null)
                    continue;
                int neighbours = countNeighbourMines(loc);
                if (neighbours > 0)
                    cell.content = new LandMark(neighbours);
            }
        }
    }

    public class FieldDisplay implements Displayable {

        Image image = Displayable.LoadImage("/img/field.png");
        int imageSize = Math.max(image.getWidth(null), image.getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            for (int cy = 0; cy < setup.GetRows(); ++cy) {
                for (int cx = 0; cx < setup.GetColons(); ++cx) {
                    cells[cx][cy].Display(new Location(cx, cy), g);

                    Flag flag = flags[cx][cy];
                    if (flag != null)
                        flag.Display(new Location(cx, cy), g);
                }
            }
        }
    }

    private FieldDisplay display = new FieldDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }

    public void RevealCell(Location loc) {
        if (notInBounds(loc))
            return;

        if (getFlag(loc) != null)
            return;

        if (getCell(loc).revealed)
            return;

        getCell(loc).Trigger();

        if (cells[loc.x()][loc.y()].content == null)
            for (int i = 0; i < neighbours.length; ++i) {
                RevealCell(loc.Sum(neighbours[i]));
            }

    }

    public void PutFlag(Location loc) {
        if (getCell(loc).revealed)
            return;
        Flag flag = getFlag(loc);
        if (flag == null)
            flags[loc.x()][loc.y()] = new Flag();
        else
            flags[loc.x()][loc.y()] = null;
    }

}
