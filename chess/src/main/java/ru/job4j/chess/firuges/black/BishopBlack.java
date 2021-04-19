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
        /**Сравниваются 2 объекта, т.к. position возвращает объект.*/
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        /**Переменная size как раз обозначает ДЛИНУ того самого пути,
         * который фигура собирается пройти. Т.к. у нас по логике
         * разница в координатах по обеим осям одинаковая (см. метод is diagonal),
         * то можно взять координату Х и посчитать.*/
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        /**Поле position относится в данном случае только к классу черного слона,
         * а значит когда мы вызываем position, то запрашиваем текущие координаты нашего слона
         * и далее сравниваем с координатами dest.
         */
        int deltaX = position.getX() < dest.getX() ? 1 : -1;
        int deltaY = position.getY() < dest.getY() ? 1 : -1;
        /**С каждым циклом позиция не меняется и в массив будет записываться одно и то же.
         * Чтобы менялась, необходимо index*delta.
         * index + 1 нужен, чтобы начать не с первой клетки а со второй.*/
        for (int index = 0; index < size; index++) {
            int x = position.getX() + ((index + 1) * deltaX);
            int y = position.getY() + ((index + 1) * deltaY);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            return true;
        }
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
