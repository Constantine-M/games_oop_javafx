package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {

    @Test
    public void WhenPositionIsTrue() {
        Figure bishop = new BishopBlack(Cell.F8);
        Assert.assertThat(bishop.position(), is(Cell.F8));
    }

    @Test
    public void copy() {
    }
}