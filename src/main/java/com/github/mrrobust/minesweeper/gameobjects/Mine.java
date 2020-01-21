package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;
import com.github.mrrobust.gameframework.Triggerable;

import java.awt.*;

public class Mine extends GameObject implements Displayable, Triggerable{

    public Boolean exploded = false;

    public class MineDisplay implements Displayable {

        Image image = Displayable.LoadImage("/img/mine.png");
        Image image_explode = Displayable.LoadImage("/img/explode.png");
        int imageSize = Math.max(image.getWidth(null), image.getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            if (!exploded)
                g.drawImage(image,
                        location.x() * imageSize,
                        location.y() * imageSize,
                        null);
            else
                g.drawImage(image_explode,
                        location.x() * imageSize,
                        location.y() * imageSize,
                        null);

        }
    }

    private MineDisplay display = new MineDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }

    @Override
    public void Trigger() {
        exploded = true;
    }
}
