package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Aleksei Usov (usalekse@gmail.com)
 * @version 1.0
 * @since 07/09/2020
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
    public Cell[] way(Cell dest) {
      if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.x - position.x);
        Cell[] steps = new Cell[size];
        int x = position.x, y = position.y;
        int deltaX = (dest.x - x) > 0 ? 1 : - 1;
        int deltaY = (dest.y - y) > 0 ? 1 : - 1;
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
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
