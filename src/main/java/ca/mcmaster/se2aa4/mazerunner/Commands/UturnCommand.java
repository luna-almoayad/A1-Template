package ca.mcmaster.se2aa4.mazerunner.Commands;

import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class UturnCommand implements Command {
    @Override
    public MazeLocation execute(Maze maze, MazeLocation location, Directions dir) {
        return location.makeMove(dir.rightTurn().rightTurn());
    }

    @Override
    public Action getAction() {
        return Action.uturn;
    }

    @Override
    public Directions getNewDir(Directions currentDir) {
        return currentDir.rightTurn().rightTurn();
    }
    
}
