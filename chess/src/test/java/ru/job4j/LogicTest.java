package ru.job4j;

import javafx.css.converter.LadderConverter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.job4j.chess.Chess;
import ru.job4j.chess.Logic;
import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    //check exception when anyone figure on the way
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void whenAnyoneFigureOnTheWay() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        PawnBlack pawnBlack = new PawnBlack(Cell.B2);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        exception.expect(OccupiedCellException.class);
        logic.move(Cell.C1, Cell.A3);
    }

    //check No exception when way is free
    @Test
    public void whenWayIsFreeAndNoException() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.move(Cell.C1, Cell.A3);
    }

    //check exception when figure no on the cell
    @Rule
    public ExpectedException exceptionFigureNotFound = ExpectedException.none();

    @Test
    public void whenFigureNotOnTheCell() throws OccupiedCellException, FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        exceptionFigureNotFound.expect(FigureNotFoundException.class);
        logic.move(Cell.C2, Cell.A3);
    }
}
