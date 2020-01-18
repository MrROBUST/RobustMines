package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Location;
import com.github.mrrobust.gameframework.ObjectDisplay;

import java.awt.*;

public class Selector {

    private Location location;

    {
        location = new Location(-1, -1);
        display = new Display();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public static class DisplayData {

        protected static int iconSize = 24;
        protected static Image image;

        static {
            image = ObjectDisplay.getImage("/img/selector.png");
        }

        public static int getIconSize() {
            return iconSize;
        }

        public static Image getImage() {
            return image;
        }

    }

    public class Display extends ObjectDisplay {

        @Override
        public void Display(Graphics g) {

            g.drawImage(
                    DisplayData.image,
                    (location.x() *  DisplayData.iconSize),
                    (location.y() *  DisplayData.iconSize),
                    null);

        }

    }

    private Display display;

    public Display getDisplay() {
        return display;
    }

}
