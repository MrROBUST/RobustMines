package com.github.mrrobust.gameframework;

public abstract class GameObject {
    private static int count = 0;
    private static int lastid = count;
    private int id;

    public GameObject() {
        id = lastid++;
        ++count;
    }

    public int GetId() {
        return id;
    }
}
