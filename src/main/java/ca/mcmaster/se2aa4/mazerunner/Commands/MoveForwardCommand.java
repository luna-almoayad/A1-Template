package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

// a concrete implementation of the Command interface, focussed on the forward movement 
public class MoveForwardCommand implements Command{
    private Directions dir;

    public MoveForwardCommand(Directions dir){
        this.dir = dir; 
    }

    // the execute method is called to perform the forward movement in the maze
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions currentDir){
        return location.makeMove(dir);
    }
    // the getAction method returns the action associated with this command
    @Override
    public Action getAction(){
        return Action.forward;
    }

    // the getNewDir method returns the new direction after the forward movement
    @Override 
    public Directions getNewDir(Directions currentDir){
        return currentDir;
    }

    
}
