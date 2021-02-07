package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSettingsWindow extends JFrame {
    GameSettingsWindow gameSettingsWindow = this;

    public GameSettingsWindow() {
        // Настраиваем окно с выбором настроек
        setTitle("Настройки игры");
        setBounds(250, 250, 500, 550);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel aILevelLabel = new JLabel("Уровень ИИ:");
        add(aILevelLabel);
        aILevelLabel.setAlignmentX(CENTER_ALIGNMENT);

        JSlider sliderAI = getSliderAILevel();
        JLabel linesCountLabel = getLinesCountLabel();
        JTextField linesCountTextField = getLinesCountTextField();
        JLabel rangeCountLabel = getRangeCountLabel();
        JTextField rangeCountTextField = getRangeCountTextField();
        JButton jButtonSetSettings = getJButtonSetSettings();
        setVisible(true);
        sliderAI.setVisible(true);

        // Обработчик событий для выбора размера поля (если размер поля не указан, то по умолчанию он равен - 3х3)
        // и количества 0 или X в раду для победы
        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameField gameField = GameField.getInstance();
                if (linesCountTextField.getText().isEmpty()) {
                    gameField.linesCount = 3;
                } else {
                    do {
                        gameField.linesCount = Integer.parseInt(linesCountTextField.getText());

                    } while (Integer.parseInt(linesCountTextField.getText()) < 3 || Integer.parseInt(linesCountTextField.getText()) > 10);
                }
                if (rangeCountTextField.getText().isEmpty()) {
                    gameField.rageCount = 3;
                } else {
                    do {
                        gameField.rageCount = Integer.parseInt(rangeCountTextField.getText());

                    } while (Integer.parseInt(rangeCountTextField.getText()) < 3 || Integer.parseInt(rangeCountTextField.getText()) > Integer.parseInt(linesCountTextField.getText()));
                }

                // Запускаем игру
                gameField.startNewGame();
                gameField.aiLevel = sliderAI.getValue();
                gameSettingsWindow.setVisible(false);
            }
        });
    }

    private JLabel getLinesCountLabel() {
        JLabel linesCountLabel = new JLabel("Размер поля от 3 (по умолчанию) до 10: ");
        add(linesCountLabel);
        linesCountLabel.setAlignmentX((CENTER_ALIGNMENT));
        return linesCountLabel;
    }

    private JTextField getLinesCountTextField() {
        JTextField linesCountTextField = new JTextField();
        linesCountTextField.setMaximumSize(new Dimension(40, 20));
        add(linesCountTextField);
        linesCountTextField.setAlignmentX(CENTER_ALIGNMENT);
        return linesCountTextField;
    }

    private JLabel getRangeCountLabel() {
        JLabel rangeCountLabel = new JLabel("Сколько 0 или X в ряду нужно для победы (от 3 до размера поля)");
        add(rangeCountLabel);
        rangeCountLabel.setAlignmentX((CENTER_ALIGNMENT));
        return rangeCountLabel;
    }

    private JTextField getRangeCountTextField() {
        JTextField rangeCountTextField = new JTextField();
        rangeCountTextField.setMaximumSize(new Dimension(40, 20));
        add(rangeCountTextField);
        rangeCountTextField.setAlignmentX(CENTER_ALIGNMENT);
        return rangeCountTextField;
    }

    private JButton getJButtonSetSettings() {
        JButton jButtonSetSettings = new JButton("Начать игру!");
        add(jButtonSetSettings);
        jButtonSetSettings.setAlignmentX(CENTER_ALIGNMENT);
        return jButtonSetSettings;
    }

    private JSlider getSliderAILevel() {
        JSlider sliderAILevel = new JSlider(0, 2, 0);
        add(sliderAILevel);
        sliderAILevel.setAlignmentX(CENTER_ALIGNMENT);
        sliderAILevel.setVisible(false);
        return sliderAILevel;
    }

}