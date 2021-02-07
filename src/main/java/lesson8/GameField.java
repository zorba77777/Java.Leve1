package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameField extends JPanel {

    private static GameField instance = null;
    // Размер игрового поля
    public static final int FIELD_SIZE = 500;

    // Начальное значение ячеек
    public final char NOT_SIGN = '*';

    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    // Игровое поле
    public static char[][] cell;

    // Значение, когда игра закончилась
    boolean gameOver = false;

    // Сообщение, которое появится при завершении игры
    String gameOverMessage = "";
    static int linesCount = 3;
    static int rageCount = 3;
    int cellSize;
    int x;
    int y;
    int aiLevel = 0;

    // Получение экземпляра GameField
    public static synchronized GameField getInstance() {
        if (instance == null)
            instance = new GameField();
        return instance;
    }

    // Запуск новой игры
    void startNewGame() {
        gameOver = false;
        gameOverMessage = "";
        // Размер одной ячейки
        cellSize = FIELD_SIZE / linesCount;
        cell = new char[linesCount][linesCount];
        // Перерисовка поля
        repaint();
        // Инициализация поля
        for (int i = 0; i < linesCount; i++) {
            for (int j = 0; j < linesCount; j++) {
                cell[i][j] = NOT_SIGN;
            }
        }
        aiLevel = 0;
        setVisible(true);
    }

    // Конструктор
    private GameField() {
        setVisible(false);

        // Получаем координаты клика мышью
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                x = e.getX() / cellSize;
                y = e.getY() / cellSize;
                System.out.println("Mouse clicked on " + e.getX() + " " + e.getY());

                if (!gameOver) {
                    gameResults();
                }
            }
        });
    }

    void gameResults() {
        Player player = new Player(DOT_X);
        AI ai = new AI(DOT_O, aiLevel, player.sign);
        if (!gameOver) {
            if (player.move(x, y)) {
                if (player.win()) {
                    gameOver = true;
                    gameOverMessage = "Победил Игрок!";
                }
                if (isFieldFull() && !player.win()) {
                    gameOver = true;
                    gameOverMessage = "Ничья!!!";
                }
                repaint();
                if (!gameOver) {
                    ai.move(x, y);
                }
                if (ai.win()) {
                    gameOver = true;
                    gameOverMessage = "Победил ИИ!";
                }
                repaint();
                if (isFieldFull() && !ai.win()) {
                    gameOver = true;
                    gameOverMessage = "Ничья!!!";
                }
            }
        }
    }

    // Проверка ячейки на занятость
    boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > linesCount - 1 || y > linesCount - 1) {
            return false;
        }
        return cell[x][y] != NOT_SIGN;
    }

    // Проверка поля на заполнение
    public boolean isFieldFull() {
        for (int i = 0; i < linesCount; i++) {
            for (int j = 0; j < linesCount; j++) {
                if (cell[i][j] == NOT_SIGN)
                    return false;
            }
        }
        return true;
    }

    // Логика победы изменена для работы с любым размером поля.
    boolean checkWin(char symb) {
        for (int col = 0; col < linesCount - rageCount + 1; col++) {
            for (int row = 0; row < linesCount - rageCount + 1; row++) {
                if (checkDiagonal(symb, col, row) || checkLanes(symb, col, row)) return true;
            }
        }
        return false;
    }

    // Проверяем диагонали
    boolean checkDiagonal(char symb, int offsetX, int offsetY) {
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i = 0; i < rageCount; i++) {
            toright &= (cell[i + offsetX][i + offsetY] == symb);
            toleft &= (cell[rageCount - i - 1 + offsetX][i + offsetY] == symb);
        }

        if (toright || toleft) return true;

        return false;
    }

    // Проверяем горизонтальные и вертикальные линии
    boolean checkLanes(char symb, int offsetX, int offsetY) {
        boolean cols, rows;
        for (int col = offsetX; col < rageCount + offsetX; col++) {
            cols = true;
            rows = true;
            for (int row = offsetY; row < rageCount + offsetY; row++) {
                cols &= (cell[col][row] == symb);
                rows &= (cell[row][col] == symb);
            }

            if (cols || rows) return true;
        }

        return false;
    }

    // Метод графики
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем линии, которые представляют собой сетку
        for (int i = 0; i <= this.linesCount; i++) {
            g.drawLine(0, i * this.cellSize, FIELD_SIZE, i * this.cellSize);
            g.drawLine(i * this.cellSize, 0, i * this.cellSize, FIELD_SIZE);
        }
        for (int i = 0; i < linesCount; i++) {
            for (int j = 0; j < linesCount; j++) {
                if (cell[i][j] != NOT_SIGN) {
                    if (cell[i][j] == DOT_X) {
                        // Рисуем крестик
                        g.setColor(Color.RED);
                        g.drawLine((i * cellSize), (j * cellSize), (i + 1) * cellSize, (j + 1) * cellSize);
                        g.drawLine((i + 1) * cellSize, (j * cellSize), (i * cellSize), (j + 1) * cellSize);
                    }
                    if (cell[i][j] == DOT_O) {
                        // Рисуем нолик
                        g.setColor(Color.BLUE);
                        g.drawOval((i * cellSize), (j * cellSize), cellSize, cellSize);
                    }
                }
            }
        }
        if (gameOver) {
            // Отрисовка сообщения при завершении игры
            g.setColor(Color.BLUE);
            g.fillRect(0, FIELD_SIZE / 2, FIELD_SIZE, FIELD_SIZE / 8);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", 10, 40));
            g.drawString(gameOverMessage, 0, 19 * FIELD_SIZE / 32);
        }
    }
}
