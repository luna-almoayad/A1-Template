package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public interface Command {
    MazeLocation execute(Maze maze, MazeLocation location, Directions dir);
    Action getAction();
    Directions getNewDir(Directions currentDir);
}
