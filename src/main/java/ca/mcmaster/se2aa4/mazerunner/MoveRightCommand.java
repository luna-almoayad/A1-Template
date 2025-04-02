package ca.mcmaster.se2aa4.mazerunner;

public class MoveRightCommand implements Command {
    
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir){
        return location.makeMove(dir.rightTurn());
    }

    @Override
    public Action getAction(){
        return Action.right;
    }

    @Override
    public Directions getNewDir(Directions currentDir){
        return currentDir.rightTurn();
    }
}
