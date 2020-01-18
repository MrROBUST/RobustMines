package com.github.mrrobust.gameframework;

import javax.swing.*;
import java.awt.*;

public abstract class ObjectDisplay {

    public abstract void Display(Graphics g);

    public static Image getImage(String filepath) {
        ImageIcon icon = new ImageIcon(ObjectDisplay.class.getResource(filepath));
        return icon.getImage();
    }

}
