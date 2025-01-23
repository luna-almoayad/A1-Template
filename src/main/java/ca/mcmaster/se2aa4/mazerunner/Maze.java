package ca.mcmaster.se2aa4.mazerunner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*; 
import java.util.ArrayList;
import java.util.List;

//MVP work for one maze, has factor thing for one maze 

public class Maze{

    private ArrayList<ArrayList<Boolean>> maze;
    private int entryRow, entryCol;
    private int exitRow,exitCol;

    private static final Logger logger = LogManager.getLogger(Maze.class);

    public Maze (String fileName) throws IOException{
        maze = new ArrayList<>();
        loadMaze(fileName);
    }

    private void loadMaze (String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        int row = 0;

        while ((line = reader.readLine()) != null) {
            maze.add(new ArrayList<>());
            for (int idx = 0; idx < line.length(); idx++) {
                if (line.charAt(idx) == '#') {
                    maze.get(row).add(false);

                } else if (line.charAt(idx) == ' ') {
                    maze.get(row).add(true);
        
                } /*else if (line.charAt(idx) == '\n'){  
                    for (int i =0; idx < line.length(); i++){
                        maze.get(row).add(true);
                    }
                }*/
            }
            row ++;
            System.out.print(System.lineSeparator());
        }
        reader.close();
       
    }

    public void getEntry(){
        for (int row=0; row < maze.size(); row++){
            if (maze.get(row).get(0) == true) {
                entryRow = row;
                entryCol= 0; 
                System.out.println("Enter:" +entryRow + ","  +entryCol);
            }
        }

    }

    public void getExit() {
        int cols= (maze.get(0).size()) - 1; 
        for (int row=0; row < maze.size(); row++){
            if (maze.get(row).get(cols) == true) {
                exitRow = row;
                exitCol= cols; 
                System.out.println("Exit:"+ exitRow + ","  +exitCol);
            }
        }
    }
}


   