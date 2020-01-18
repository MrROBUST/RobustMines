package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Location;
import com.github.mrrobust.gameframework.ObjectDisplay;
import com.github.mrrobust.gameframework.GameObject;

import java.awt.*;

public class Field extends GameObject {

    private MineSweeperSetup setup;
    private Cell[][] cells;

    public Field(MineSweeperSetup setup) {
        this.setup = setup;

        cells = new Cell[setup.GetRows()][setup.GetColons()];

        display = new Display();
    }

    private static class DisplayData {

        public static int iconSize = 24;
        public static Image icon;

        static {
            icon = ObjectDisplay.getImage("/img/field.png");
        }

    }

    public class Display extends ObjectDisplay {

        @Override
        public void Display(Graphics g) {

            for (int cy = 0; cy < setup.GetRows(); ++cy) {
                for (int cx = 0; cx < setup.GetColons(); ++cx) {
                    g.drawImage(
                            DisplayData.icon,
                            (cx *  DisplayData.iconSize),
                            (cy *  DisplayData.iconSize),
                            null);
                }
            }

        }
    }

    private Display display;

    public Display getDisplay() {
        return display;
    }

}
