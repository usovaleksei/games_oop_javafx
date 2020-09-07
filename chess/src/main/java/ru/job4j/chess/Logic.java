package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

/**
 * chess logic: add figure, move figure, clean cell, find cell
 * @author Aleksei Usov (usalekse@gmail.com)
 * @version 1.0
 * @since 07/09/2020
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    //add new figure
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    //move figure
    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        Cell[] steps = figures[index].way(dest);
        if(free(steps)) {
            figures[index] = figures[index].copy(dest);
        }
    }

    //check free cells to figure way
    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Cell cell : steps) {
            if (findBy(cell) != -1) {
                throw new OccupiedCellException();
            }
        }
        return true;
    }

    //clean cell
    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    //find cell by enum index
    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    //display figure
    @Override
    public String toString() {
        return "Logic{" +
                "figures=" + Arrays.toString(this.figures) +
                '}';
    }
}
