package ca.mcmaster.se2aa4.mazerunner.Path;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;
import ca.mcmaster.se2aa4.mazerunner.Commands.Action;

//implementing observer pattern interface style

public interface MovementObserver {
    // upon movement, the observer will be notified with the current location, direction and action
    void onMove (MazeLocation location, Directions direction, Action action);
}
