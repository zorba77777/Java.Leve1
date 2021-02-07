package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow() {
        // Задаем название окна
        setTitle("Крестики-нолики");
        // Задаем размер окна
        setBounds(250, 250, 500, 575);
        // Неизменяемый размер окна
        setResizable(false);
        // Выход из игры после закрытия окна
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Создаём игровое поле
        GameField gameField = GameField.getInstance();
        // Создаём игровые кнопки
        JPanel gameButtons = new JPanel(new GridLayout());
        // Добавляем игровое поле в главное игровое окно
        add(gameField, BorderLayout.CENTER);
        // Добавляем кнопки начала и завершения игры
        add(gameButtons, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Завершить игру");
        gameButtons.add(btnStart);
        gameButtons.add(btnEnd);
        // Обработчик событий для выхода из игры
        btnEnd.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // Обработчик событий для старта новой игры
        btnStart.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                System.out.println(btnStart.getText());
                // Запуск окна с настройками игры
                GameSettingsWindow gameSettingsWindow = new GameSettingsWindow();
            }
        });
        setVisible(true);
    }
}