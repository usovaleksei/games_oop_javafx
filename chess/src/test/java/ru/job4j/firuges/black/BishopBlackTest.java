package ru.job4j.firuges.black;

import org.junit.Test;
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
}

