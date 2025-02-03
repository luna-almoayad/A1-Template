package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
   
     
    private StringBuilder path; 

    public PathFinder(){
        this.path = new StringBuilder();
    }

    public void generatePath(char step){
        path.append(step); 
    }

    private String getCanonical(){
        return path.toString();
    }

    public String getPath(){
        return getFactorized(path.toString());
    }

    public void checkPath(String userPath){
        // convert path in case it is factorized 
        String cleanedPath= expandFactorizedForm(userPath);
        String reversedPath= reversePath(cleanedPath);
        //determine if it is correct by checking to maze generated path 
        if (cleanedPath.equals(getCanonical())|| reversedPath.equals(getCanonical())){
            System.out.println("Correct Path!");
        } else{
            System.out.println("Incorrect Path.");
        }

    }

    
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
            } else{
                toCanonical.append(current);
            }

        }
        return toCanonical.toString();

    }

    private String reversePath (String path){
        StringBuilder reverse= new StringBuilder(path).reverse();
        for (int i =0; i<reverse.length(); i++){
            char current= reverse.charAt(i);
            if (current == 'R'){
                reverse.setCharAt(i, 'L');
            }else if (current == 'L'){
                reverse.setCharAt(i,'R');
            }
        }
        return reverse.toString();
    }
        
    

    private String getFactorized(String path) {
        StringBuilder toFactorized = new StringBuilder();
        int count = 1;

        for (int i = 0; i < path.length(); i++) {
            // If this is not the last character and the next character is the same, increment the count
            if (i < path.length() - 1 && path.charAt(i) == path.charAt(i + 1)) {
                count++;
            } else {
                // Append the count only if it is greater than 1, otherwise just append the character
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


