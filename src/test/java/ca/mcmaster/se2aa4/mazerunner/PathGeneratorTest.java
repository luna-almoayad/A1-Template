package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PathGeneratorTest {

    private PathGenerator generator;

    @BeforeEach 
    public void setUp(){
        generator = new PathGenerator();
    }


    //test conversion of canonical path to factorized path using sample path
    @Test
    public void testgetFactorizedTest(){
        String path = "FFFRFFLFF";
        String factorized= "3F R 2F L 2F";
        assertEquals(factorized, generator.getFactorized(path));
    }

}
