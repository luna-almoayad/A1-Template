package ca.mcmaster.se2aa4.mazerunner;

// enum responsible for navigation system of maze runner 
public enum Directions {
    UP,
    DOWN,
    RIGHT, 
    LEFT;

    // handles direction switching when turning right 
    public Directions rightTurn() {
        // based on the current direction, return the correct direction upon turning 
        if (this == UP){
            return RIGHT;
        }
        else if (this == DOWN){
            return LEFT;
        }
        else if (this == LEFT){
            return UP;
        }
        else if (this == RIGHT){
            return DOWN;
        }
        // handle exceptions and errors 
        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }

    // handles direction switching when turning left 
    public Directions leftTurn() {
        // based on current direction, return direction upon turning left 
        if (this == UP){
            return LEFT;
        }
        else if (this == DOWN){
            return RIGHT;
        }
        else if (this == LEFT){
            return DOWN;
        }
        else if (this == RIGHT){
            return UP;
        }
        //handle exceptions and errors 
        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }
}


