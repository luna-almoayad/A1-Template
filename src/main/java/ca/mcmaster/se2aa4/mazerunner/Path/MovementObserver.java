package ca.mcmaster.se2aa4.mazerunner.Path;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;
import ca.mcmaster.se2aa4.mazerunner.Commands.Action;

public interface MovementObserver {
    void onMove (MazeLocation location, Directions direction, Action action);
}
