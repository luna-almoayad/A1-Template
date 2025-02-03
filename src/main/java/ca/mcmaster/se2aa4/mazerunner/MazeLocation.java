package ca.mcmaster.se2aa4.mazerunner;


public class MazeLocation {
    public int x, y; 
    //constructor method initialize coordinates 
    public MazeLocation( int x, int y){
        this.x = x;
        this.y= y;
    }

    //Private helper method to add a move to the current location (Updates location of maze runner)
    private MazeLocation addMove(MazeLocation previous){
        return new MazeLocation (this.x + previous.x, this.y +previous.y);
    }


    // Method to move current location based on specificed directions 
    public MazeLocation makeMove(Directions direction){
        // if moving down, runner moves down one row and columns does'nt change 
        if (direction == Directions.DOWN){
            return this.addMove(new MazeLocation( 0, 1)); 
        }
        // if moving up, runner moves up one row and columns does'nt change 
        else if (direction == Directions.UP){
            return this.addMove(new MazeLocation (0, -1));// move up 
        }
        // if moving left, runner moves up one column and rows does'nt change 
        else if (direction == Directions.LEFT){
            return this.addMove(new MazeLocation (-1, 0));// move left 
        }
        // if moving right, runner moves down one column and rowns does'nt change 
        else if (direction == Directions.RIGHT){
            return this.addMove(new MazeLocation (1, 0));// move right
        // account for any errors/ exceptions
        }else{
            throw new IllegalStateException ("Value ( " + this +" ) not accepted:");
        }
    }
    
    //Overrode equals method for objects within MazeLocation class to ensure proper terminatio of solveMaze loop
    @Override
    public boolean equals(Object obj) {
        // check if both references point to same object 
        if (this == obj) {
            return true;
        }
        //check that objects belong to same class and that they are not null 
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MazeLocation that = (MazeLocation) obj;
        return x == that.x && y == that.y; // compare x and y coordinates 
    }

}

