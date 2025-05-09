package ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class PathFinder {

    //Constructor method to initialize a new path
    public PathFinder(){
    }

    //Method to traverse through maze to validate user path 
    private Boolean isCorrectPath(Maze maze, String userPath) {
        //current position is start and initital orientation is right 
        MazeLocation currentPos = maze.getEntry(); 
        Directions currentDir = Directions.E;  

        // Iterate through each character of user string 
        for (int i = 0; i < userPath.length(); i++) {
            char step = userPath.charAt(i);
            
            // complete the appropriate action for each step 
            if (step == 'R') {
                currentDir = currentDir.rightTurn();
            } else if (step == 'L') {
                currentDir = currentDir.leftTurn();
            } else if (step == 'F') {
                // check if there's no wall before moving forward 
                MazeLocation nextPos = currentPos.makeMove(currentDir);
                if (maze.isWall(nextPos)) {
                    return false; 
                }
                // update position
                currentPos = nextPos;
            }
        }

        // check if exit is reached to determine if valid path 
        if (currentPos.equals(maze.getExit())){
            return true;  
        }
        return false;  
    }

    // checks user provided path 
    public boolean checkPath(Maze maze, String userPath){
         // convert path in case it is factorized 
        String cleanedPath= expandFactorizedForm(userPath);
        // reverse path to check for west - east traversal 
        String reversedPath= reversePath(cleanedPath);
         //determine if it is correct by traversing through maze
        if (isCorrectPath(maze, cleanedPath) || isCorrectPath(maze, reversedPath) ){
            System.out.println("Correct Path!");
            return true;
        }else{
            System.out.println("Incorrect Path.");
            return false;
        }
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
