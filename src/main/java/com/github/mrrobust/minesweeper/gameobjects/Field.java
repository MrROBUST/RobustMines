package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.GameObject;

public class Field extends GameObject {
    private int rows;
    private int colons;
    private Cell[][] cells;

    public Field(int rows, int colons) {
        this.rows = rows;
        this.colons = colons;

        cells = new Cell[rows][colons];
    }

}
