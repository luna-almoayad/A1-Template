package ca.mcmaster.se2aa4.mazerunner;

public class MoveForwardCommand implements Command{
    

    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir){
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
