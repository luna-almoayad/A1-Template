package ca.mcmaster.se2aa4.mazerunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.apache.commons.cli.*; 

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        //use apache CLI to search for -i or -p flag
        Options options= new Options();
        options.addOption("i",true, "File path for maze.");
        options.addOption("p",true,  "Path for maze.");

        CommandLineParser parser = new DefaultParser();
      

        try {
            CommandLine cmd = parser.parse(options,args);

            // check for user flages 
            if (cmd.hasOption("i")){
                // Run maze runner program to find path out of given maze 
                String fileName = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + fileName);
                //Create new instances of maze, pathfinder and runner to solve maze
                Maze maze = new Maze(fileName);
                PathGenerator generator = new PathGenerator();
                Runner runner = new Runner(generator);
                String solution= runner.solveMaze(maze);

                if (cmd.hasOption("p")){
                    //validate user path and output correct path
                    String userPath = cmd.getOptionValue("p");
                    PathFinder pathFinder = new PathFinder();
                    logger.info("**** Validating Path: " + userPath);
                    pathFinder.checkPath(maze,userPath);
                }else {
                    System.out.println("The correct path is (assuming east-west): "+ solution);
                }
            
            } else {
                logger.error("No maze file provided. Use -i flag to specify the file path.");
            }

        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\"+ e);
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED.");
        logger.info("** End of MazeRunner");
    }

    

}
