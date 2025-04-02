package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class RunnerTest {
    
    // test the maze solver method using the straight maze and its known solution
    @Test
    public void testSolveMaze() throws IOException{
        PathGenerator generator = new PathGenerator();
        Maze maze = new Maze("./examples/straight.maz.txt");
        MazeSolver solver = new Runner(generator);
        String solution = solver.solveMaze(maze);
        assertEquals("4F", solution);
    }
    
}
