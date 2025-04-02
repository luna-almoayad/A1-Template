package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class MazeLocationTest {
    
    // test the makeMove method to ensure oroper direction and coordinate change with each move 
    @Test
    public void testmakeMove() throws IllegalStateException{
        MazeLocation test = new MazeLocation(0,0);
        MazeLocation test2 = new MazeLocation(0,1);
        MazeLocation test3 = new MazeLocation(1,0);
        MazeLocation test4 = new MazeLocation(0,-1);
        MazeLocation test5 = new MazeLocation(-1,0);
        assertEquals(test2, test.makeMove(Directions.S));
        assertEquals(test3, test.makeMove(Directions.E));
        assertEquals(test4, test.makeMove(Directions.N));
        assertEquals(test5, test.makeMove(Directions.W));
    }
}
