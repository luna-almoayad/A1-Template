package ca.mcmaster.se2aa4.mazerunner.Commands;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

// concrete implementation of the Command interface focused on turning left 
public class MoveLeftCommand implements Command {
 
    // this method executes the left turn command, updating the maze location 
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir){
        return location.makeMove(dir.leftTurn());
    }

    // this method returns the action associated with the left turn command
    @Override
    public Action getAction(){
        return Action.left;
    }

    // this method returns the new direction after the left turn
    @Override 
    public Directions getNewDir(Directions currentDir){
        return currentDir.leftTurn();
    }

}
