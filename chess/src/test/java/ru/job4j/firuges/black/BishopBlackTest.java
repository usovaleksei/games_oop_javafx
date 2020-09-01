package ru.job4j.firuges.black;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    //check figure position after creation
    @Test
    public void positionWhenCreateFigure() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell createPosition = bishopBlack.position();
        Cell expectedPosition = Cell.C1;
        assertThat(createPosition, is(expectedPosition));
    }

    //check figure position after move
    @Test
    public void positionWhenMoveFigure() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure bishopBlackMove = bishopBlack.copy(Cell.F4);
        Cell movePosition = bishopBlackMove.position();
        Cell expectedPosition = Cell.F4;
        assertThat(movePosition, is(expectedPosition));
    }

    //chek way from position to dest
    @Test
    public void wayFromPositionToDest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] bishopWay = bishopBlack.way(Cell.C1, Cell.G5);
        Cell[] expectedWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopWay, is(expectedWay));
    }

    //check exception when not diagonal
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenIsNotDiagonalStep() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        exception.expect(IllegalStateException.class);
        exception.expectMessage("Could not way by diagonal from C1 to C5");
        Cell[] bishopWay = bishopBlack.way(Cell.C1, Cell.C5);
    }
}

