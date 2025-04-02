package ca.mcmaster.se2aa4.mazerunner;

public interface MovementObserver {
    void onMove (MazeLocation location, Directions direction, Action action);
}
