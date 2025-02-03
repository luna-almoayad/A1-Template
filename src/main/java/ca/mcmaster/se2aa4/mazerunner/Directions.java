package ca.mcmaster.se2aa4.mazerunner;

// enum responsible for navigation system of maze runner 
public enum Directions {
    UP,
    DOWN,
    RIGHT, 
    LEFT;

    // handles direction switching when turning right 
    public Directions rightTurn() {
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

        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }

    // handles direction switching when turning left 
    public Directions leftTurn() {
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

        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }
}


