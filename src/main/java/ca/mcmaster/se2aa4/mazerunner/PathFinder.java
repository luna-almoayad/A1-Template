package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
   
    private Runner runner; 
    private String userPath;

    public PathFinder(String userPath, Runner runner){
        this.runner = runner;
        this.userPath = userPath;
        String canon= runner.generatePath();
        getFactorized(canon);
        checkPath(userPath);
    }

    
    public void checkPath(String userPath){
        // convert path in case it is factorized 
        String cleanedPath= expandFactorizedForm(userPath);
        //determine if it is correct 
        if (cleanedPath.equals(runner.generatePath())){
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

    public String getFactorized(String path){
        StringBuilder toFactorized= new StringBuilder();
        int count=1;
        
        for (int i=0; i<path.length(); i++){
            if (i < (path.length() -1) && path.charAt(i)== path.charAt(i+1)){
                count++;
            } else{
                toFactorized.append(count).append(path.charAt(i));
                count=1;
            }
        }

        return("The factorized path is: "+ toFactorized.toString());
    }
}


