package ca.mcmaster.se2aa4.mazerunner.Path;
import java.util.ArrayList;
import java.util.List;
import ca.mcmaster.se2aa4.mazerunner.Commands.*;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;


public class PathFinder {

    // checks user provided path 
    public boolean checkPath(Maze maze, String userPath){
        String cleanedPath = expandFactorizedForm(userPath);
        String reversedPath = reversePath(cleanedPath);
        List<Command> commands = pathToCommands(cleanedPath, Directions.E);
        List<Command> reversedCommands = pathToCommands(reversedPath, Directions.W);

        // Try East-to-West path traversal 
        if (simulatePath(maze, maze.getEntry(), Directions.E, commands)) {
            System.out.println("Correct Path!");
            return true;
        }
    
        // Try West-to-East path traversal
        if (simulatePath(maze, maze.getEntry(), Directions.W, reversedCommands)) {
            System.out.println("Correct Path!");
            return true;
        }
    
        System.out.println("Incorrect Path.");
        return false;
    }

    public List<Command> pathToCommands(String path, Directions startDir) {
        List<Command> commands = new ArrayList<>();
        Directions currentDir = startDir;

        for (char c : path.toCharArray()) {
            if (c == 'F'){
                commands.add(new MoveForwardCommand(currentDir));
            }else if (c == 'L'){
                currentDir = currentDir.leftTurn();
                commands.add(new MoveForwardCommand(currentDir));
            }else if( c== 'R'){
                currentDir = currentDir.rightTurn();
                commands.add(new MoveForwardCommand(currentDir));      
            }
        }
        return commands;
    }

    public boolean simulatePath(Maze maze, MazeLocation start, Directions startDir, List<Command> commands) {
        MazeLocation currentPos = start;
        Directions currentDir = startDir;
    
        for (Command cmd : commands) {
            MazeLocation nextPos = cmd.execute(maze, currentPos, currentDir);
            if (maze.isWall(nextPos)) {
                return false;
            }
            currentDir = cmd.getNewDir(currentDir);
            currentPos = nextPos;
        }
    
        return currentPos.equals(maze.getExit());
    }
    

    // Expands factorized form to canonical
    public String expandFactorizedForm(String path){
        StringBuilder toCanonical = new StringBuilder();
        // iterate through string until digit is found 
        for (int i=0; i < path.length(); i++){
            char current = path.charAt(i);
            if (Character.isDigit(current)){
                if (i+1 < path.length()){
                    //Convert char digit to number and append the corresponding direction
                    char nextChar = path.charAt(i+1);
                    int count= Character.getNumericValue(current);
                    for (int j=0; j<count; j++){
                        toCanonical.append(nextChar);
                    }
                    //skip next char as it was already processed
                    i++;
                
                } else{
                    System.out.println("Cannot have digit with no following letter.");
                }
            // skip character if it is an empty space
            } else if (current == ' '){
                continue;
            }else{
                toCanonical.append(current);
            }

        }
        return toCanonical.toString();
    }

    // method to reverse path for traversal from west to east 
    public String reversePath (String path){
        // reverse current path 
        StringBuilder reverse= new StringBuilder(path).reverse();
        //iterate through each character in reversed path 
        for (int i =0; i<reverse.length(); i++){
            char current= reverse.charAt(i);
            //switch left and right to account for orientation change
            if (current == 'R'){
                reverse.setCharAt(i, 'L');
            }else if (current == 'L'){
                reverse.setCharAt(i,'R');
            }
        }
        return reverse.toString();
    }
        
            
}


