package ca.mcmaster.se2aa4.mazerunner.Path;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;
import ca.mcmaster.se2aa4.mazerunner.Commands.Action;

public abstract class Subject {
    private final List<MovementObserver> observers = new ArrayList<>();

    protected void addObserver(MovementObserver observer) {
        observers.add(observer);
    }

    protected void notifyObservers(MazeLocation location, Directions direction, Action action) {
        for (MovementObserver obs : observers) {
            obs.onMove(location, direction, action);
        }
    }

    protected void removeObserver(MovementObserver observer) {
        observers.remove(observer);
    }
    
}
