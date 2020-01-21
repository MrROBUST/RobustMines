package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.Displayable;
import com.github.mrrobust.gameframework.GameObject;
import com.github.mrrobust.gameframework.Location;

import java.awt.*;

public class Cell extends GameObject implements Displayable{

    public GameObject content;
    public Boolean revealed = true;

    public Cell() {}
    public Cell(GameObject content) {
        this.content = content;
    }

    public class CellDisplay implements Displayable {

        Image image = Displayable.LoadImage("/img/field.png");
        Image image_revealed = Displayable.LoadImage("/img/revealed.png");
        int imageSize = Math.max(image.getWidth(null), image.getHeight(null));

        @Override
        public void Display(Location location, Graphics g) {
            if (!revealed) {
                g.drawImage(image,
                        location.x() * imageSize,
                        location.y() * imageSize,
                        null);
                return;
            }
            g.drawImage(image_revealed,
                    location.x() * imageSize,
                    location.y() * imageSize,
                    null);
            if (content != null && content instanceof Displayable)
                ((Displayable) content).Display(location, g);

        }
    }

    private CellDisplay display = new CellDisplay();

    @Override
    public void Display(Location location, Graphics g) {
        display.Display(location, g);
    }
}
