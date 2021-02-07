package lesson8;

public class Player extends GeneralGameValue {
    // экземпляр игрового поля
    GameField gameField;

    // Конструктор
    public Player(char sign) {
        this.sign = sign;
    }

    // Ход игрока
    boolean move(int x, int y) {
        gameField = GameField.getInstance();
        if (!gameField.isCellBusy(x, y)) {
            gameField.cell[x][y] = sign;
            return true;
        }
        return false;
    }

    // Проверка победы
    boolean win() {
        gameField = GameField.getInstance();
        return gameField.checkWin(this.sign);
    }
}
