package com.github.mrrobust.minesweeper.gameobjects;

import com.github.mrrobust.gameframework.ObjectDisplay;
import com.github.mrrobust.gameframework.GameObject;

import java.awt.*;

public class Cell extends GameObject{

    protected GameObject content;

    public Cell() {}
    public Cell(GameObject payload) {
        PutContent(payload);
    }

    public GameObject GetContent() {
        return content;
    }

    public void PutContent(GameObject payload) {
        content = payload;
    }

}
