package com.github.mrrobust.minesweeper.gameobjects;

public class MineSweeperSetup {

    private int colons;
    private int rows;
    private int mines;

    public MineSweeperSetup(int colons, int rows, int mines) {
        this.colons = colons;
        this.rows = rows;
        this.mines = Math.min(mines, colons * rows);
    }

    public int GetColons() {
        return colons;
    }

    public int GetRows() {
        return rows;
    }

    public int GetMines() {
        return mines;
    }

}
