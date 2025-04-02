package ca.mcmaster.se2aa4.mazerunner;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner extends Subject implements MazeSolver {

    private PathGenerator generator;
    private static final Logger logger = LogManager.getLogger(Runner.class);
    

    //Constructor method to initialize pathfinder object
    public Runner (PathGenerator generator){
        this.generator= generator;
        addObserver(generator);
    }

    //method responsible for maze traversal and solving 
    public String solveMaze (Maze maze){
        //start position and initial direction 
        MazeLocation currentPos = maze.getEntry();
        Directions currentDir = Directions.E; 

        // loop through algorithm while the current position is not at exit of maze 
        while (!currentPos.equals(maze.getExit())){

            Command command = getNextCommand(maze, currentPos, currentDir);
            MazeLocation nextPos = command.execute(maze, currentPos, currentDir);
            notifyObservers (nextPos, command.getNewDir(currentDir), command.getAction());
            currentPos = nextPos;
            currentDir = command.getNewDir(currentDir);    
               
            logger.debug("Current Position: " + currentPos.toString()+ "\n Current path:" + generator.getPath());
        }

        return generator.getPath(); // return final path 

    }

    public Command getNextCommand(Maze maze, MazeLocation pos, Directions dir){
        if (maze.isWall(pos.makeMove(dir.rightTurn()))){
            //case 1: move forward if no wall
            if (!maze.isWall(pos.makeMove(dir))){
                return new MoveForwardCommand();
            }
            //case 2: turn left if forward is wall and left is not 
            else if (!maze.isWall(pos.makeMove(dir.leftTurn()))){
                return new MoveLeftCommand();
            }
            //case 3: no other options, must u-turn
            else{
                return new UturnCommand();
            }
            
        //right hand side is not wall, turn right
        }else{
            return new MoveRightCommand();
        }
    }

   
}