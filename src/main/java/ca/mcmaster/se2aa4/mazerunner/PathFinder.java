package ca.mcmaster.se2aa4.mazerunner;
public class PathFinder {
   
    private Runner runner; 
    private String userPath;

    public PathFinder(String userPath, Runner runner){
        this.runner = runner;
        this.userPath = userPath;
        checkPath(userPath);
    }

    private void checkPath(String userPath){
        String cleanedPath= expandFactorizedForm(userPath);
        if (cleanedPath.equals(runner.generatePath())){
            System.out.println("Correct Path!");
        } else{
            System.out.println("Incorrect Path.");
        }

    }

    private String expandFactorizedForm(String path){
        StringBuilder toCanonical = new StringBuilder();
        for (int i=0; i < path.length(); i++){
            char current = path.charAt(i);
            if (Character.isDigit(current)){
                if (i+1 < path.length()){
                    char nextChar = path.charAt(i+1);
                    int count= Character.getNumericValue(current);
                    for (int j=0; j<count; j++){
                        toCanonical.append(nextChar);
                    }
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
}
