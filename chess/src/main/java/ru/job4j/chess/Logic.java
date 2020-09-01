package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;

/**
 * chess logic: add figure, move figure, clean cell, find cell
 * @author Aleksei Usov (usalekse@gmail.com)
 * @version 1.0
 * @since 24/08/2020
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    //add new figure
    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    //move figure
    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
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
