package ca.mcmaster.se2aa4.mazerunner;

public class PathGenerator implements MovementObserver {

    private final StringBuilder path = new StringBuilder();

    @Override
    public void onMove(MazeLocation location, Directions direction, Action action) {
        if (action == Action.left) {
            path.append("LF");
        }else if (action == Action.right) {    
            path.append("RF");
        }else if (action == Action.forward) {
            path.append("F");
        }else if (action == Action.uturn) {
            path.append("RR");
        }
    }

    public String getPath() {
        return getFactorized(path.toString());
    }

    public String getFactorized(String path){
        StringBuilder toFactorized = new StringBuilder();
        int count = 1;

        for (int i = 0; i < path.length(); i++) {
            // If this is not the last character and the next character is the same, increment the count
            if (i < path.length() - 1 && path.charAt(i) == path.charAt(i + 1)) {
                count++;
            } else {
                // Only appnd count if its greater than 1
                if (count > 1) {
                    toFactorized.append(count);
                }
                toFactorized.append(path.charAt(i));
                // Reset count for the next character
                count = 1;
                // Add a space only if it's not the last character
                if (i<path.length()-1){
                    toFactorized.append(" ");
                }  
            }
        }
    
        return toFactorized.toString();
    }
}
    

