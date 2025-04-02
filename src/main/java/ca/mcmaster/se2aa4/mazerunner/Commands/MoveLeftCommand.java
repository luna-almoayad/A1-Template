package ca.mcmaster.se2aa4.mazerunner.Commands;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class MoveLeftCommand implements Command {
 
    
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir){
        return location.makeMove(dir.leftTurn());
    }

    @Override
    public Action getAction(){
        return Action.left;
    }

    @Override 
    public Directions getNewDir(Directions currentDir){
        return currentDir.leftTurn();
    }

}
