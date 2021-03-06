package com.github.mrrobust.gameframework;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Location Sum(Location offset) {
        return new Location(x + offset.x(), y + offset.y());
    }
}
