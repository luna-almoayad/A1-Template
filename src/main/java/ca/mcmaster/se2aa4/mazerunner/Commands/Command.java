package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

// implementing command pattern with an interface with methods that encapsulate the movement command logic 
public interface Command {
    MazeLocation execute(Maze maze, MazeLocation location, Directions dir);
    Action getAction();
    Directions getNewDir(Directions currentDir);
}
