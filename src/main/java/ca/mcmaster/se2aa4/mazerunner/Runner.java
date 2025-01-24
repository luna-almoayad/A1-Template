package ca.mcmaster.se2aa4.mazerunner;

public class Runner {

    private Maze maze;
    private int row, col; 

    public Runner (Maze maze){
        this.maze = maze;
        this.row= maze.getEntryRow();
        this.col= maze.getEntryCol();
    }


    public String generatePath(){
        //Path for straight maze 
        String canonPath = "FFFFF";
        return canonPath;
    }


}

