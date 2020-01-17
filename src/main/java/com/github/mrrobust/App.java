package com.github.mrrobust;

import com.github.mrrobust.gameframework.Game;
import com.github.mrrobust.minesweeper.MineSweeper;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {

    private Game game;

    public App() {

        game = new MineSweeper();
        initUI();
        game.Start();

    }

    private void initUI() {

        add(game.GetComponent());

        setResizable(false);
        pack();

        setTitle(game.GetTitle());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });

    }

}
