package ca.mcmaster.se2aa4.mazerunner;

// enum responsible for navigation system of maze runner 
public enum Directions {
    N,
    S,
    E, 
    W;

    // handles direction switching when turning right 
    public Directions rightTurn() {
        // based on the current direction, return the correct direction upon turning 
        if (this == N){
            return E;
        }
        else if (this == S){
            return W;
        }
        else if (this == W){
            return N;
        }
        else if (this == E){
            return S;
        }
        // handle exceptions and errors 
        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }

    // handles direction switching when turning left 
    public Directions leftTurn() {
        // based on current direction, return direction upon turning left 
        if (this == N){
            return W;
        }
        else if (this == S){
            return E;
        }
        else if (this == W){
            return S;
        }
        else if (this == E){
            return N;
        }
        //handle exceptions and errors 
        throw new IllegalStateException("Value ( " + this +" ) not accepted:");

    }
}


