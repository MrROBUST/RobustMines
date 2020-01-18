package com.github.mrrobust.gameframework;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;

public abstract class UserInterface extends JPanel {

    protected Game game;

    private ArrayList<ObjectDisplay> displayBatch;

    public void PutDisplayBatch(ArrayList<ObjectDisplay> displayBatch) {
        this.displayBatch = displayBatch;
    }

    public UserInterface(Game game) {
        this.game = game;
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    protected void OnMouseMove(MouseEvent e) {}
    protected void OnMouseClick(MouseEvent e) {}

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (ObjectDisplay d : displayBatch) {
            Graphics g2 = g.create();
            d.Display(g);
            g2.dispose();
        }

    }

    private MouseController mouseController = new MouseController();
    private class MouseController extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {

            super.mouseMoved(e);
            OnMouseMove(e);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            super.mouseClicked(e);
            OnMouseClick(e);

        }
    }
}
