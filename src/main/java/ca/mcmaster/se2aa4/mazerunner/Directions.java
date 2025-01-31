package ca.mcmaster.se2aa4.mazerunner;


public enum Directions {
    UP,
    DOWN,
    RIGHT, 
    LEFT;

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


