package lesson8;

public abstract class GeneralGameValue {
    // знак
    protected char sign;

    // выстрел в координаты x и y
    abstract boolean move(int x, int y);

    // проверка победы
    abstract boolean win();
}
