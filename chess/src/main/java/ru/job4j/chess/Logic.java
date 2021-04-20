package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

/**
 * Данный класс управляет логикой игры.
 */
public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    /**
     * 1.int index = тут по объекту типа Cell source в массиве figures находим объект типа Figure.
     * Он возвращает индекс ячейки или выкидывает исключение. Исключение заложено внутри метода findBy.
     * 2.Cell[] steps = тут если объект найден, то нужно получить его ходы до клетки Cell dest.
     * Это нужно сделать через метод way объекта Figure.
     * 3.figures[index] = тут нужно в массив figures в позицию, полученную в пункте 1,
     * записать новый объект, полученный из метода figure.copy.
     */
    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
    }

    /**
     * В данном методе проверяем, что массив клеток от метода way не заполнен другими объектами класса Figure.
     * Тем самым проверяем, нет ли других фигур на нашем пути (на пути прохождения слона именно).
     * @param steps массив клеток, который получили в методе way
     */
    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (Figure figure : figures) {
            for (Cell step : steps) {
                if (figure != null && figure.position().equals(step)) {
                    throw new OccupiedCellException("Ячейка занята.");
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException("Фигуры нет на клетке.");
    }
}
