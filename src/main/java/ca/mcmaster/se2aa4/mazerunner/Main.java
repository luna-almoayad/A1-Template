package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*; 

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        //Step 1: use apache CLI to search for -i flag
        Options options= new Options();
        options.addOption("i",true, "File path for maze.");

        CommandLineParser parser = new DefaultParser();
      

        try {
            CommandLine cmd = parser.parse(options,args);

            if (cmd.hasOption("i")){
                String fileName = cmd.getOptionValue("i");
                logger.info("**** Reading the maze from file " + fileName);
                Maze maze = new Maze(fileName);
                maze.getEntry();
                maze.getExit();
    
                //Runner runner = new Runner(maze);
            }

            
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }

    

}
