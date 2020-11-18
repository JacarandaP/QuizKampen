package Clientside;

import GUI.CategoryGUI;
import GUI.QuizGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Max Erling
 * Date: 2020-11-17
 * Copyright: MIT
 * Class: Java20B
 */
public class TestClient extends JFrame {
    QuizGUI quizGUI = new QuizGUI();
    CategoryGUI catGUI = new CategoryGUI();
    JPanel mainPanel = new JPanel();
    CardLayout c1 = new CardLayout();


    public TestClient() {
       mainPanel.setLayout(c1);
       mainPanel.add(catGUI,"0");
       mainPanel.add(quizGUI,"1");
       c1.show(mainPanel, "0");
       add(mainPanel);
       ButtonListener buttonClick = new ButtonListener();
       catGUI.getCategory1().addActionListener(buttonClick);



        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }



    public static void main(String[] args) {
        new TestClient();
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == catGUI.getCategory1()) {
                c1.show(mainPanel,"1");

            }
        }
    }


    /*private JPanel setupCategory() {
        JLabel label = new JLabel("Ange ditt namn");
        JLabel player2 = new JLabel("Väntar på andra spelare");
        JLabel winnerLabel = new JLabel("Vinnare:");
        String playerName;
        JTextField txtName;
        JButton nameButton;
        JButton category1;
        JButton category2;
        JButton category3;
        JButton category4;


        JPanel namePanel = new JPanel();
        //namePanel.setBackground(Color.ORANGE);
        JPanel gamePanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel winnersPanel = new JPanel();
        JPanel categoryPanel = new JPanel(new BorderLayout());

        JLabel nameLabel = new JLabel("Name:");
        txtName = new JTextField(15);
        nameButton = new JButton("Save");
        nameButton.setEnabled(true);
        //nameButton.addActionListener(saveName);
        namePanel.add(nameLabel);
        namePanel.add(txtName);
        namePanel.add(nameButton);

        gamePanel.setLayout(new GridLayout(2,2));

        category1 = new JButton("Kultur");
        //category1.addActionListener(buttonClick);
        category1.setEnabled(false);
        gamePanel.add(category1);

        category2 = new JButton("Musik");
        //category2.addActionListener(buttonClick);
        category2.setEnabled(false);
        gamePanel.add(category2);

        category3 = new JButton("Sport");
        //category3.addActionListener(buttonClick);
        category3.setEnabled(false);
        gamePanel.add(category3);

        category4 = new JButton("Gaming");
        //category4.addActionListener(buttonClick);
        category4.setEnabled(false);
        gamePanel.add(category4);

        statusPanel.add(label);
        statusPanel.add(player2);
        statusPanel.add(winnerLabel);

        categoryPanel.add(namePanel, BorderLayout.NORTH);
        categoryPanel.add(gamePanel, BorderLayout.CENTER);
        categoryPanel.add(statusPanel, BorderLayout.SOUTH);
        return categoryPanel;
    }*/

    /*private JPanel setupQuiz() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 0));
        JPanel questionPanel = new JPanel(new GridBagLayout());
        JPanel answerPanel = new JPanel(new GridLayout(2, 0));
        JLabel questionText = new JLabel("");
        int category = 0;
        JButton a1 = new JButton();
        JButton a2 = new JButton();
        JButton a3 = new JButton();
        JButton a4 = new JButton();


        mainPanel.setBackground(Color.blue);
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

        add(mainPanel);
        mainPanel.add(questionPanel);
        questionPanel.add(questionText);
        questionPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(answerPanel);
        //Listener l = new Listener();
        a1.addActionListener(l);
        a2.addActionListener(l);
        a3.addActionListener(l);
        a4.addActionListener(l);
        answerPanel.add(a1);
        answerPanel.add(a2);
        answerPanel.add(a3);
        answerPanel.add(a4);




        return mainPanel;


    }*/

}
