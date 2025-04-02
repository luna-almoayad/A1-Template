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
            // if wall is on right hand side 
            if (maze.isWall(currentPos.makeMove(currentDir.rightTurn()))){
                //case 1: move forward if no wall
                if (!maze.isWall(currentPos.makeMove(currentDir))){
                    currentPos = currentPos.makeMove(currentDir);
                    notifyObservers(currentPos, currentDir, Action.forward);
                }
                //case 2: turn left if forward is wall and left is not 
                else if (!maze.isWall(currentPos.makeMove(currentDir.leftTurn()))){
                    currentPos= currentPos.makeMove(currentDir.leftTurn());
                    currentDir= currentDir.leftTurn();
                    notifyObservers(currentPos, currentDir, Action.left);
                }
                //case 3: no other options, must u-turn
                else{
                    currentDir= currentDir.rightTurn().rightTurn();
                    notifyObservers(currentPos, currentDir, Action.uturn);
                }
                
            //right hand side is not wall, turn right
            }else{
                currentPos = currentPos.makeMove(currentDir.rightTurn());
                currentDir = currentDir.rightTurn();
                notifyObservers(currentPos, currentDir, Action.right);

            }
               
            logger.debug("Current Position: " + currentPos.toString()+ "\n Current path:" + generator.getPath());
        }

        return generator.getPath(); // return final path 

    }

   
}