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

    /**
     * Данный метод показывает путь прохождения фигуры.
     * !isDiagonal - Сравниваются 2 объекта, т.к. position возвращает объект.
     * int size - Переменная size как раз обозначает ДЛИНУ того самого пути,
     *            который фигура собирается пройти. Т.к. у нас по логике
     *            разница в координатах по обеим осям одинаковая (см. метод is diagonal),
     *            то можно взять координату Х и посчитать.
     * int deltaX - Поле position относится в данном случае только к классу черного слона,
     *            а значит когда мы вызываем position, то запрашиваем текущие координаты нашего слона
     *            и далее сравниваем с координатами dest.
     * цикл - С каждым циклом позиция не меняется и в массив будет записываться одно и то же.
     *        Чтобы менялась, до цикла объявили переменные х и у, а внутри цикла их "наращивали" (спасибо, ментор^^).
     * @param dest клета-конечная точка маршрута
     * @return массив клеток, которые составляют путь прохождения фигуры
     */
    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() < dest.getX() ? 1 : -1;
        int deltaY = position.getY() < dest.getY() ? 1 : -1;
        int x = position.getX();
        int y = position.getY();
        for (int index = 0; index < size; index++) {
            x += deltaX;
            y += deltaY;
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
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
