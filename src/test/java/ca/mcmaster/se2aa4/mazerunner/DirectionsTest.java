package ca.mcmaster.se2aa4.mazerunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionsTest {
    @Test
    public void rightTurnTest() {
        assertEquals(Directions.E, Directions.N.rightTurn());
        assertEquals(Directions.S, Directions.E.rightTurn());
        assertEquals(Directions.W, Directions.S.rightTurn());
        assertEquals(Directions.N, Directions.W.rightTurn());
    }

    @Test 
    public void leftTuTest() {
        assertEquals(Directions.W, Directions.N.leftTurn());
        assertEquals(Directions.N, Directions.E.leftTurn());
        assertEquals(Directions.E, Directions.S.leftTurn());
        assertEquals(Directions.S, Directions.W.leftTurn());


}
}
