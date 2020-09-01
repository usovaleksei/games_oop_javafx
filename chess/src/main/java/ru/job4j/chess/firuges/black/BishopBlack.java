package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Aleksei Usov (usalekse@gmail.com)
 * @version 1.0
 * @since 24/08/2020
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    //way from position to dest
    @Override
    public Cell[] way(Cell source, Cell dest) {
      if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.x - source.x);
        Cell[] steps = new Cell[size];
        int deltaX = (dest.x - source.x) > 0 ? 1 : - 1;
        int deltaY = (dest.y - source.y) > 0 ? 1 : - 1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.x + (index + 1) * deltaX, source.y + (index + 1) * deltaY);
        }
        return steps;
    }

    //check diagonal
    public boolean isDiagonal(Cell source, Cell dest) {
            return (Math.abs(dest.x - source.x) == Math.abs(dest.y - source.y));
    }

    //copy figure
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
