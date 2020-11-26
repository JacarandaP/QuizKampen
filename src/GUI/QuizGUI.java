package GUI;

import Serverside.QuestionDatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Max Erling
 * Date: 2020-11-16
 * Copyright: MIT
 * Class: Java20B
 */
public class QuizGUI extends JPanel {
    private JPanel quizPanel = new JPanel(new GridLayout(2, 0));
    private JPanel questionPanel = new JPanel(new GridBagLayout());
    private JPanel answerPanel = new JPanel(new GridLayout(2, 0));
    private JLabel questionText = new JLabel("");
    private JPanel namePanel = new JPanel();
    private JLabel nameLabel = new JLabel();
    private JButton a1 = new JButton();
    private JButton a2 = new JButton();
    private JButton a3 = new JButton();
    private JButton a4 = new JButton();

    public QuizGUI() {
        quizPanel.setBackground(Color.blue);
        questionPanel.setBackground(Color.white);
        answerPanel.setBackground(Color.yellow);
        a1.setBackground(Color.pink);
        a1.setForeground(Color.darkGray);
        a2.setBackground(Color.pink);
        a2.setForeground(Color.darkGray);
        a3.setBackground(Color.pink);
        a3.setForeground(Color.darkGray);
        a4.setBackground(Color.pink);
        a4.setForeground(Color.darkGray);

        quizPanel.add(namePanel);
        quizPanel.add(questionPanel);
        questionPanel.add(questionText);
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        quizPanel.add(answerPanel);
        namePanel.add(nameLabel);
        answerPanel.add(a1);
        answerPanel.add(a2);
        answerPanel.add(a3);
        answerPanel.add(a4);

        quizPanel.setPreferredSize(new Dimension(500,500));

        add(quizPanel);


    }

    public void setPlayerName(String name) {
        this.nameLabel.setText(name);
    }

    public void changeButtonsToDefaultColor() {
        a1.setBackground(Color.pink);
        a2.setBackground(Color.pink);
        a3.setBackground(Color.pink);
        a4.setBackground(Color.pink);

    }

    public JLabel getQuestionText() {
        return questionText;
    }

    public JButton getA1() {
        return a1;
    }

    public JButton getA2() {
        return a2;
    }

    public JButton getA3() {
        return a3;
    }

    public JButton getA4() {
        return a4;
    }

}

