package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;

public class PathFinderTest {
    private PathFinder pathFinder;

    //Set up pathfinder object before every test 
    @BeforeEach 
    public void setUp(){
        pathFinder = new PathFinder();
    }


    //test conversion of path to reverse (for traversing maze from opposite start point)
    @Test
    public void testreversePath(){
        String path = "FFFRFFLFF";
        String reversed = "FFRFFLFFF";
        assertEquals(reversed, pathFinder.reversePath(path));
    }

    //test conversion of factorized path to canonical path 
    @Test
    public void testexpandFactorizedForm(){
        String factorized = "3F R 2F L 2F";
        String expanded = "FFFRFFLFF";
        assertEquals(expanded, pathFinder.expandFactorizedForm(factorized));
    }

    // test the validation of a user provided path 
    @Test
    public void testCheckPath() throws IOException{
        Maze maze = new Maze("./examples/straight.maz.txt");
        String path = "FFFF";
        assertTrue(pathFinder.checkPath(maze, path));
    }
}
