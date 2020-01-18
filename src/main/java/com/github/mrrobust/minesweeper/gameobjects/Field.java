package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;

public class Field extends GameObject implements Displayable {

    public MineSweeperSetup setup;
    public Cell[][] cells;
    public Flag[][] flags;

    public Field(MineSweeperSetup setup) {
        this.setup = setup;

        cells = new Cell[setup.GetRows()][setup.GetColons()];
        flags = new Flag[setup.GetRows()][setup.GetColons()];

        for (int cy = 0; cy < setup.GetRows(); ++cy) {
            for (int cx = 0; cx < setup.GetColons(); ++cx) {
                cells[cx][cy] = new Cell();
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
                }
            }
        }
    }

    private FieldDisplay display = new FieldDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }

}
