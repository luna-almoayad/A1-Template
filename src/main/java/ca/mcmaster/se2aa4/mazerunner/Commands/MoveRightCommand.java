package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

// concrete command class for moving right
public class MoveRightCommand implements Command {
    
    /// This method is called when the command is executed, updating the location
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir){
        return location.makeMove(dir.rightTurn());
    }

    /// This method returns the action associated with the right turn command
    @Override
    public Action getAction(){
        return Action.right;
    }

    /// This method returns the new direction after the right turn
    @Override
    public Directions getNewDir(Directions currentDir){
        return currentDir.rightTurn();
    }
}
