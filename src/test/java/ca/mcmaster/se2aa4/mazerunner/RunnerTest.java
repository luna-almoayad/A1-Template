package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class RunnerTest {
    
    @Test
    public void testSolveMaze() throws IOException{
        PathFinder pathFinder = new PathFinder();
        Maze maze = new Maze("./examples/straight.maz.txt");
        MazeSolver solver = new Runner(pathFinder);
        String solution = solver.solveMaze(maze);
        assertEquals("4F", solution);
    }
    
}
