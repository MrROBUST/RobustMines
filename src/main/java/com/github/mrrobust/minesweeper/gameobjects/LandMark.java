package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;

public class LandMark extends GameObject implements Displayable{

    public int count = 0;

    public LandMark(int count) {
        this.count = count;
    }

    public class MineCounterDisplay implements Displayable {

        final int images = 8;
        Image image[] = new Image[images];
        {
            String filepath;
            for (int i = 0; i < images; ++i) {
                filepath = "/img/neighbours-" + (i + 1) + ".png";
                image[i] = Displayable.LoadImage(filepath);
            }
        }
        int imageSize = Math.max(image[0].getWidth(null), image[0].getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            if (count > 0)
                g.drawImage(image[count - 1],
                        location.x() * imageSize,
                        location.y() * imageSize,
                        null);
        }
    }

    private MineCounterDisplay display = new MineCounterDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }
}
