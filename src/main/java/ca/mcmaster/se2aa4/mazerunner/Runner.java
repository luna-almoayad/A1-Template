package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Runner {

    private PathFinder pathFinder;
    private Maze maze; 

    private static final Logger logger = LogManager.getLogger(Runner.class);

    public Runner (PathFinder pathFinder){
        this.pathFinder= pathFinder;
    }

    public String solveMaze (Maze maze){

        MazeLocation currentPos = maze.getEntry();
        Directions currentDir = Directions.RIGHT; 

        while (!currentPos.equals(maze.getExit())){
    
            if (!maze.isWall(currentPos.makeMove(currentDir.rightTurn()))){
                currentDir = currentDir.rightTurn();
                pathFinder.generatePath('R');
                currentPos = currentPos.makeMove(currentDir);
                pathFinder.generatePath('F');
               // System.out.println("here");
            } else {

                if(!maze.isWall(currentPos.makeMove(currentDir))){
                    currentPos= currentPos.makeMove(currentDir);
                    pathFinder.generatePath('F');
                    //System.out.println("hi");

                }
                else if (!maze.isWall(currentPos.makeMove(currentDir.leftTurn()))){
                    currentDir= currentDir.leftTurn();
                    pathFinder.generatePath('L');
                    currentPos= currentPos.makeMove(currentDir);
                    pathFinder.generatePath('F');
                    //System.out.println("he");
                }   

          
                else {
                    currentDir= currentDir.rightTurn().rightTurn();
                    pathFinder.generatePath('R');
                    pathFinder.generatePath('R');
                    //System.out.println("end");
                }
            }
            logger.debug("Current Position: " + currentPos.toString()+ "\n Current path:" +pathFinder.getPath());
        }

        

        return pathFinder.getPath();

    }
    
    

}

