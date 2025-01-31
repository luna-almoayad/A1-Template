package ca.mcmaster.se2aa4.mazerunner;

public class Runner {

    private PathFinder pathFinder;

    private void solveMaze (Maze maze){
        Directions currentDir = Directions.RIGHT; 
        MazeLocation currentPos = maze.getEntry();
        MazeLocation end = maze.getExit();
        while (currentPos != end){
            if (!maze.isWall(currentPos.makeMove(currentDir.rightTurn()))){
                currentDir = currentDir.rightTurn();
                pathFinder.generatePath('R');
                currentPos = currentPos.makeMove(currentDir);
                pathFinder.generatePath('F');
            } 
            else {
                
                if (!maze.isWall(currentPos.makeMove(currentDir.leftTurn()))){
                    currentDir= currentDir.leftTurn();
                    pathFinder.generatePath('L');
                    currentPos= currentPos.makeMove(currentDir);
                    pathFinder.generatePath('F');
                }

                else if(!maze.isWall(currentPos.makeMove(currentDir))){
                    pathFinder.generatePath('F');
                    currentPos= currentPos.makeMove(currentDir);

                }

                else{
                    currentPos= currentPos.makeMove(currentDir.rightTurn().rightTurn());
                    pathFinder.generatePath('R');
                    pathFinder.generatePath('R');
                }
            }

        }

        

    }
    


}

