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
    private int category = 0;
    private JButton a1 = new JButton();
    private JButton a2 = new JButton();
    private JButton a3 = new JButton();
    private JButton a4 = new JButton();

    public QuizGUI() {
        setupColorsForQuiz();

        quizPanel.add(questionPanel);
        questionPanel.add(questionText);
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        quizPanel.add(answerPanel);
        Listener l = new Listener();
        //a1.addActionListener(l);
        //a2.addActionListener(l);
        //a3.addActionListener(l);
        //a4.addActionListener(l);
        answerPanel.add(a1);
        answerPanel.add(a2);
        answerPanel.add(a3);
        answerPanel.add(a4);

        quizPanel.setPreferredSize(new Dimension(500,500));

        add(quizPanel);


    }


    public void changeButtonsToDefaultColor() {
        a1.setBackground(Color.pink);
        a2.setBackground(Color.pink);
        a3.setBackground(Color.pink);
        a4.setBackground(Color.pink);

    }

    public void setupColorsForQuiz() {
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

    private class Listener implements ActionListener {
        QuestionDatabase d = new QuestionDatabase();

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == a1 || e.getSource() == a2 || e.getSource() == a3 || e.getSource() == a4) {
                pressButtonInteraction();

            }


        }

        public void pressButtonInteraction() {

            if (a1.getText().equalsIgnoreCase(d.getAnswerBasedOnText(questionText.getText(), category))) {
                a1.setBackground(Color.green);
                a2.setBackground(Color.red);
                a3.setBackground(Color.red);
                a4.setBackground(Color.red);
            } else if (a2.getText().equalsIgnoreCase(d.getAnswerBasedOnText(questionText.getText(), category))) {
                a2.setBackground(Color.green);
                a1.setBackground(Color.red);
                a3.setBackground(Color.red);
                a4.setBackground(Color.red);

            } else if (a3.getText().equalsIgnoreCase(d.getAnswerBasedOnText(questionText.getText(), category))) {
                a3.setBackground(Color.green);
                a2.setBackground(Color.red);
                a1.setBackground(Color.red);
                a4.setBackground(Color.red);
            } else if (a4.getText().equalsIgnoreCase(d.getAnswerBasedOnText(questionText.getText(), category))) {
                a4.setBackground(Color.green);
                a2.setBackground(Color.red);
                a3.setBackground(Color.red);
                a1.setBackground(Color.red);
            }
        }
    }
}

