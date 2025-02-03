package ca.mcmaster.se2aa4.mazerunner;


public class MazeLocation {
    public int x, y; 

    public MazeLocation( int x, int y){
        this.x = x;
        this.y= y;
    }

    public MazeLocation addMove(MazeLocation previous){
        //add error checkin here
        return new MazeLocation (this.x + previous.x, this.y +previous.y);
    }



    public MazeLocation makeMove(Directions direction){
        if (direction == Directions.DOWN){
            return this.addMove(new MazeLocation( 0, 1));
        }
        else if (direction == Directions.UP){
            return this.addMove(new MazeLocation (0, -1));
        }
        else if (direction == Directions.LEFT){
            return this.addMove(new MazeLocation (-1, 0));
        }
        else if (direction == Directions.RIGHT){
            return this.addMove(new MazeLocation (1, 0));
        }else{
            throw new IllegalStateException ("Value ( " + this +" ) not accepted:");
        }
    }
    
    //Overrode equals method for objects within MazeLocation class 
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MazeLocation that = (MazeLocation) obj;
        return x == that.x && y == that.y;
    }

}

