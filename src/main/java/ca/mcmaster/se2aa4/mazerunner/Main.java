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
        CommandLine cmd;

        final ArrayList<ArrayList<Boolean>> maze = new ArrayList<>();


        try {
            cmd = parser.parse(options,args);
            String fileName = cmd.getOptionValue("i");

            logger.info("**** Reading the maze from file " + fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int row= 0;

            while ((line = reader.readLine()) != null) {
                maze.add(0,new ArrayList<Boolean>());
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        logger.info("WALL "); //ask if these need to be displayed or if i should use trace 
                        maze.get(row).add(idx,false);

                    } else if (line.charAt(idx) == ' ') {
                        logger.info("PASS ");
                        maze.get(row).add(idx,true);

                    }
                }row++;
                System.out.print(System.lineSeparator());// DOES END OF LINE, SO CAN I DO LOGGER.TRACE ("LINE ENDS")
            }
            reader.close();
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");
        logger.warn("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
