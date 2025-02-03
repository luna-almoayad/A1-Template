package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Runner {

    private PathFinder pathFinder;

    private static final Logger logger = LogManager.getLogger(Runner.class);

    //Constructor method to initialize pathfinder object
    public Runner (PathFinder pathFinder){
        this.pathFinder= pathFinder;
    }

    //method responsible for maze traversal and solving 
    public String solveMaze (Maze maze){
        //start position and initial direction 
        MazeLocation currentPos = maze.getEntry();
        Directions currentDir = Directions.RIGHT; 

        // loop through algorithm while the current position is not at exit of maze 
        while (!currentPos.equals(maze.getExit())){
    
            //turn right if there is no wall 
            if (!maze.isWall(currentPos.makeMove(currentDir.rightTurn()))){
                currentDir = currentDir.rightTurn();
                pathFinder.generatePath('R'); // update path with every movement 
                currentPos = currentPos.makeMove(currentDir);
                pathFinder.generatePath('F'); // append a forward step to account for lack of movement when turning
            } else {
                // move forward if no wall 
                if(!maze.isWall(currentPos.makeMove(currentDir))){
                    currentPos= currentPos.makeMove(currentDir);
                    pathFinder.generatePath('F');

                } // turn left if unable to move forward but left is possible 
                else if (!maze.isWall(currentPos.makeMove(currentDir.leftTurn()))){
                    currentDir= currentDir.leftTurn();
                    pathFinder.generatePath('L');
                    currentPos= currentPos.makeMove(currentDir);
                    pathFinder.generatePath('F');
                }   

                // u-turn if there are no other options 
                else {
                    currentDir= currentDir.rightTurn().rightTurn();
                    pathFinder.generatePath('R');
                    pathFinder.generatePath('R');
                 
                }
            }
            logger.debug("Current Position: " + currentPos.toString()+ "\n Current path:" +pathFinder.getPath());
        }

        

        return pathFinder.getPath(); // return final path 

    }
    
    

}

