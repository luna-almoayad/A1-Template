package ca.mcmaster.se2aa4.mazerunner.Path;
import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;
import ca.mcmaster.se2aa4.mazerunner.Commands.Action;

//abstract subject class that implements the observer pattern
public abstract class Subject {
    private final List<MovementObserver> observers = new ArrayList<>();

    // method to add an observer to the list of observers
    protected void addObserver(MovementObserver observer) {
        observers.add(observer);
    }
    // method to notify all observers of a movement event
    protected void notifyObservers(MazeLocation location, Directions direction, Action action) {
        for (MovementObserver obs : observers) {
            obs.onMove(location, direction, action);
        }
    }

    // method to remove an observer from the list of observers
    protected void removeObserver(MovementObserver observer) {
        observers.remove(observer);
    }
    
}
