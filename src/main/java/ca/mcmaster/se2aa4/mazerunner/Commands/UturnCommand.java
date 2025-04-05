package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

// concrete command class for uturn command
public class UturnCommand implements Command {

    //executes uturn command, updating the maze location
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir) {
        return location.makeMove(dir.rightTurn().rightTurn());
    }

    // this method returns the action associated with the uturn command
    @Override
    public Action getAction() {
        return Action.uturn;
    }

    // this method returns the new direction after the uturn
    @Override
    public Directions getNewDir(Directions currentDir) {
        return currentDir.rightTurn().rightTurn();
    }
    
}
