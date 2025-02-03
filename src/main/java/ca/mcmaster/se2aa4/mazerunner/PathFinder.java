package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
   
     
    private StringBuilder path; 

    //Constructor method to initialize a new path
    public PathFinder(){
        this.path = new StringBuilder();
    }

    // Append steps of path as Runner navigates through maze 
    public void generatePath(char step){
        path.append(step); 
    }

    // gets canonical form of path 
    private String getCanonical(){
        return path.toString();
    }

    //gets Factorized form of path 
    public String getPath(){
        return getFactorized(path.toString());
    }

    // checks user provided path 
    public void checkPath(String userPath){
        // convert path in case it is factorized 
        String cleanedPath= expandFactorizedForm(userPath);
        // reverse path to check for west - east traversal 
        String reversedPath= reversePath(cleanedPath);
        //determine if it is correct by comparing to computer generated path 
        if (cleanedPath.equals(getCanonical())|| reversedPath.equals(getCanonical())){
            System.out.println("Correct Path!");
        } else{
            System.out.println("Incorrect Path.");
        }

    }

    // Expands factorized form to canonical
    private String expandFactorizedForm(String path){
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
    private String reversePath (String path){
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
        
    
    // method to convert a pass to factorized form 
    private String getFactorized(String path) {
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


