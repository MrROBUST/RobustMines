package com.github.mrrobust.gameframework;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
    private final int CELL_SIZE = 24;
    private final int N_ROWS = 16;
    private final int N_COLS = 16;

    private final int BOARD_WIDTH = N_COLS * CELL_SIZE;
    private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE;

    private Image field;
    private Image selector;

    public Board() {
        initBoard();
    }

    private Image getImage(String filepath) {
        ImageIcon icon = new ImageIcon(getClass().getResource(filepath));
        return icon.getImage();
    }

    private void initBoard() {

        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

        field = getImage("/img/field.png");
        selector = getImage("/img/selector.png");

        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int cy = 0; cy < N_ROWS; ++cy) {
            for (int cx = 0; cx < N_COLS; ++cx) {
                    g.drawImage(field, (cx * CELL_SIZE),
                            (cy * CELL_SIZE), this);

            }
        }

        g.drawImage(selector, (selectorCol * CELL_SIZE),
                (selectorRow * CELL_SIZE), this);

    }

    int selectorCol = -1;
    int selectorRow = -1;

    private MouseController mouseController = new MouseController();
    private class MouseController extends MouseAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            super.mouseMoved(e);

            int x = e.getX();
            int y = e.getY();

            selectorCol = x / CELL_SIZE;
            selectorRow = y / CELL_SIZE;

            repaint();
        }

    }
}
