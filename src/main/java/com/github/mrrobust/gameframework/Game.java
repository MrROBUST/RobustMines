package com.github.mrrobust.gameframework;

import javax.swing.*;

public abstract class Game {

    protected JComponent userInterface;

    public JComponent getUserInterface() {
        return userInterface;
    }

    protected String title;

    public String GetTitle() {
        return title;
    }

    private State state;

    {
        state = State.Stopped;
    }

    protected enum State {
        Stopped,
        Running
    }

    public void Start() {
        if (state == State.Stopped) {
            state = State.Running;
        }
    }

    public void Stop() {
        if (state == State.Running) {
            state = State.Stopped;
        }
    }

    public void Restart() {
        if (state == State.Running) {
            Stop();
        }
        Start();
    }

    public Boolean IsRunning() {
        return state == State.Running;
    }

}
