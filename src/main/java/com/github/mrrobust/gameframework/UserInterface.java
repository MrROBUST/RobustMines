package com.github.mrrobust.gameframework;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;

public abstract class UserInterface extends JPanel {

    protected Game game;

    private ArrayList<Displayable> displayBatch = new ArrayList<Displayable>();

    public void PutDisplayBatch(ArrayList<Displayable> displayBatch) {
        this.displayBatch = displayBatch;
    }

    public UserInterface(Game game) {
        this.game = game;
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
        addKeyListener(keyboardController);
        setFocusable(true);
    }

    protected void OnMouseMove(MouseEvent e) {}
    protected void OnMouseClick(MouseEvent e) {}
    protected void OnKeyPressed(KeyEvent e) {}

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (Displayable d : displayBatch) {
            Graphics g2 = g.create();
            d.Display(null, g);
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
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            OnMouseClick(e);
        }
    }

    private KeyboardController keyboardController = new KeyboardController();
    private class KeyboardController extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            OnKeyPressed(e);
        }

    }
}
