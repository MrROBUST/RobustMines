package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;

public class Selector implements Displayable {

    public Location location;

    {
        location = new Location(-1, -1);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public class SelectorDisplay implements Displayable {

        protected Image image = Displayable.LoadImage("/img/selector.png");
        protected int imageSize = Math.max(image.getWidth(null), image.getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            g.drawImage(image,
                    (getLocation().x() *  imageSize),
                    (getLocation().y() *  imageSize),
                    null);
        }
    }

    private SelectorDisplay display = new SelectorDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }
}
