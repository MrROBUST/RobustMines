package com.github.mrrobust.gameframework;

public abstract class GameObject {

    private static int count = 0;
    private static int lastId = count;
    private int id;

    public GameObject() {
        id = lastId++;
        ++count;
    }

    public int GetId() {
        return id;
    }

    public static int getCount() {
        return count;
    }

}
