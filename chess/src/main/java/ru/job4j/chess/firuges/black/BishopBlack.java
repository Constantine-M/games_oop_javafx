package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    /**
     * Метод используется для получения позиции фигуры на поле.
     */
    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return false;
    }

    /**
     * Этот метод создаст объект класса с позицией dest.
     * @param dest позиция клетки
     */
    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
