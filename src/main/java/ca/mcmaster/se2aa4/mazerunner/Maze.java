package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;


public class Maze{

    private ArrayList<ArrayList<Boolean>> maze;
    private int entryRow, entryCol;
    private int exitRow,exitCol;

    private static final Logger logger = LogManager.getLogger(Maze.class);

    public Maze (String fileName) throws IOException{
        maze = new ArrayList<>();
        loadMaze(fileName);
    }

    //Load maze from file and append it to 2d aray 
    private void loadMaze (String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        int row = 0;
        int maxCols =0;
        while ((line = reader.readLine()) != null) {
            maze.add(new ArrayList<>());

            maxCols = Math.max(maxCols, line.length());
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    maze.get(row).add(false);
                    logger.trace("WALL");

                } else if (line.charAt(idx) == ' ') {
                    maze.get(row).add(true);
                    logger.trace("PASS");
        
                }
                
            }
            // handle cases where there's an empty row (all passes)
            if (line.trim().isEmpty()){
                for (int i = 0; i < maze.get(0).size(); i++){
                    maze.get(row).add(true);
                    logger.trace("PASS");
                }
            }
            //handles cases where there are few columns in a row 
            while (maze.get(row).size() < maxCols) {
                maze.get(row).add(true);  
            }

            row ++;
            logger.trace("End of Line");
        }
        reader.close();

        logger.info("Maze loaded successfully. Rows: " + maze.size() + " Columns: "+ maze.get(0).size());
       
    }
    

    //determine entry coordinates and return as object of the MazeLocation class 
    public MazeLocation getEntry(){
        for (int row=0; row < maze.size(); row++){
            if (maze.get(row).get(0) == true) {
                entryRow = row;
                entryCol= 0; 
                logger.info ("Entry point: (" + entryCol+" , " + entryRow + ")");
                MazeLocation entrance = new MazeLocation(entryCol, entryRow);
                return entrance ; 
            }
        }
        logger.warn("No entry point found");
        return null;
    }

    //determine exit coordinates and return as object of the MazeLocation class 
    public MazeLocation getExit() {
        int cols= (maze.get(0).size()) - 1; 
        for (int row=0; row < maze.size(); row++){
            if (maze.get(row).get(cols) == true) {
                exitRow = row;
                exitCol= cols; 
                MazeLocation exit = new MazeLocation(exitCol, exitRow);
                logger.info ("Exit point: (" + exitCol +" , " + exitRow + ")");
                return exit;
        
            }
        }
        logger.warn("No exit point found");
        return null;
    }

    // determine whether a location is a wall or passable
    public boolean isWall (MazeLocation location){
        
        //Edge case: treat any out of bounds locations as walls
        if (location.y < 0 || location.y >= maze.size() || location.x < 0 || location.x >= maze.get(0).size()) {
            return true; 
        }

        return !maze.get(location.y).get(location.x);
    }
   

}


   