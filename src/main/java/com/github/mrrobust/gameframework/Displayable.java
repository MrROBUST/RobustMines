package com.github.mrrobust.gameframework;

import javax.swing.*;
import java.awt.*;

public interface Displayable {
    void Display(Location location, Graphics g);

    static Image LoadImage(String filepath) {
        ImageIcon icon = new ImageIcon(Displayable.class.getResource(filepath));
        return icon.getImage();
    }
}
