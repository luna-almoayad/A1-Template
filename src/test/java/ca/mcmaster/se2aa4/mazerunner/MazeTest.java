package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import ca.mcmaster.se2aa4.mazerunner.MazeInfo.*;

public class MazeTest {
    private Maze maze; 

    // set up a maze object before every test
    @BeforeEach
    public void setUp() throws IOException{
        maze = new Maze("./examples/straight.maz.txt");
    }
    
    // test the getEntry method to ensure proper entry location is returned
    @Test
    public void testGetEntry(){
        MazeLocation entry = new MazeLocation(0,2);
        assertEquals(entry, maze.getEntry());
        
    }

    // test the getExit method to ensure proper exit location is returned
    @Test
    public void testGetExit(){
        MazeLocation exit = new MazeLocation(4,2);
        assertEquals(exit, maze.getExit());

    }
    
    // test the isWall method to ensure proper wall detection
    @Test
    public void testisWall(){
        assertTrue(maze.isWall(new MazeLocation(0,0)));
        assertFalse(maze.isWall(new MazeLocation(0,2)));

    }

}
