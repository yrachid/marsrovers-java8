package location;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    public void shouldMoveOnePointRight() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.right();

        assertEquals(3, movedPosition.x);

    }

    @Test
    public void shouldMoveOnePointLeft() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.left();

        assertEquals(1, movedPosition.x);

    }

    @Test
    public void shouldMoveOnePointUp() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.up();

        assertEquals(3, movedPosition.y);

    }

    @Test
    public void shouldMoveOnePointDown() throws Exception {

        Position position = new Position(2,2);

        Position movedPosition = position.down();

        assertEquals(1, movedPosition.y);

    }
}
