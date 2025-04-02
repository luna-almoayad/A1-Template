package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class MoveForwardCommand implements Command{
    private Directions dir;
    public MoveForwardCommand(Directions dir){
        this.dir = dir; 
    }

    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions currentDir){
        return location.makeMove(dir);
    }

    @Override
    public Action getAction(){
        return Action.forward;
    }

    @Override 
    public Directions getNewDir(Directions currentDir){
        return currentDir;
    }

    
}
