package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;
import java.text.BreakIterator;

public class Flag extends GameObject implements Displayable{

    static enum State {
        Neutral,
        Pass,
        Miss
    }

    public State state = State.Neutral;

    public class FlagDisplay implements Displayable {

        Image image = Displayable.LoadImage("/img/flag.png");
        Image image_pass = Displayable.LoadImage("/img/flag-true.png");
        Image image_miss = Displayable.LoadImage("/img/flag-false.png");
        int imageSize = Math.max(image.getWidth(null), image.getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            switch (state) {
                case Neutral:
                    g.drawImage(image,
                            location.x() * imageSize,
                            location.y() * imageSize,
                            null);
                    break;
                case Pass:
                    g.drawImage(image_pass,
                            location.x() * imageSize,
                            location.y() * imageSize,
                            null);
                    break;
                case Miss:
                    g.drawImage(image_miss,
                            location.x() * imageSize,
                            location.y() * imageSize,
                            null);
                    break;
            }

        }
    }

    private FlagDisplay display = new FlagDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }
}
