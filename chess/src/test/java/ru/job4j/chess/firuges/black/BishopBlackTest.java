package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void WhenPositionIsTrue() {
        Figure bishop = new BishopBlack(Cell.F8);
        assertThat(bishop.position(), is(Cell.F8));
    }

    @Test
    public void copy() {
        Figure bishop = new BishopBlack(Cell.F8);
        assertThat(bishop.position(), is(Cell.F8));
    }

    @Test
    public void whenWayIsTrue() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] cellWay = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishop.way(Cell.G5), is(cellWay));
    }

    @Test
    public void whenLineIsDiagonal() {
        Figure bishop = new BishopBlack(Cell.A4);
        Cell[] cellWay = {Cell.B3, Cell.C2, Cell.D1};
        assertThat(bishop.way(Cell.D1), is(cellWay));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonalThenEx() {
        Figure bishop = new BishopBlack(Cell.A4);
        bishop.way(Cell.C1);
    }
}