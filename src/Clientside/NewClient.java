package Clientside;

import GUI.CategoryGUI;
import GUI.NextRoundGUI;
import GUI.QuizGUI;
import GUI.WaitingGUI;
import Serverside.Category;
import Serverside.PlayerStatus;
import Serverside.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Max Erling
 * Date: 2020-11-20
 * Copyright: MIT
 * Class: Java20B
 */
public class NewClient extends JFrame {
    private final int port = 54321;
    private final String hostName = "127.0.0.1";
    Socket socketToServer = new Socket(hostName, port);
    ObjectOutputStream out = new ObjectOutputStream(socketToServer.getOutputStream());
    private CategoryGUI catGUI = new CategoryGUI();
    private QuizGUI quizGUI = new QuizGUI();
    private WaitingGUI waitGUI = new WaitingGUI("Waiting...");
    private NextRoundGUI nextRoundGUI = new NextRoundGUI("Play next round: ");
    private JPanel mainPanel = new JPanel();
    private CardLayout c1 = new CardLayout();
    private String answer;
    private PlayerStatus playerStatusClient;
    private int counter = 0;


    public NewClient() throws IOException {
        setupLayoutAndPanels();
        setupButtonInteraction();
        frameSettnings();

        try (
                //Scanner s = new Scanner(System.in); //Läser från terminalen. Ska bort sen
                //printer används inte, ska bort?
                PrintWriter outP = new PrintWriter(socketToServer.getOutputStream(), true)) {
            var in = new ObjectInputStream(socketToServer.getInputStream());
            Object fromServer;


            //Scanner och sout ska ersättas med gui
            while ((fromServer = in.readObject()) != null) {
                if (fromServer instanceof PlayerStatus) {
                    playerStatusClient = (PlayerStatus) fromServer;
                    quizGUI.setPlayerName(playerStatusClient.getPlayerName());
                    catGUI.setPlayerName(playerStatusClient.getPlayerName());
                    nextRoundGUI.setPlayerNames(playerStatusClient.getPlayerName(), playerStatusClient.getPlayerName()); //
                    if (playerStatusClient.isSelectingCategory() == true) {
                        System.out.println(playerStatusClient.getCategoriesToSelectBetween());
//                        catGUI.getCategory1().setText();
                        c1.show(mainPanel, "0");
                    } else if (((PlayerStatus) fromServer).isWaiting() == true) {
                        System.out.println(playerStatusClient.getReasonForWaiting());
                        c1.show(mainPanel, "2");
                    }
                    if (playerStatusClient.isSelectingAnswer()) {
                        System.out.println(playerStatusClient.getQuestionToAnswer());
                        c1.show(mainPanel, "1");

                        quizGUI.getQuestionText().setText(playerStatusClient.getQuestionToAnswer().getQuestionText());
                        quizGUI.getA1().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(0));
                        quizGUI.getA2().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(1));
                        quizGUI.getA3().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(2));
                        quizGUI.getA4().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(3));
                        changeAnswersToDefaultColor();
                    }

                    if (playerStatusClient.isRoundFinished()) {
                        c1.show(mainPanel, "3");
//                        System.out.println("your score in this round: " + playerStatusClient.getScore());
//                        System.out.println("round finished.Presh botton to continue ");


                        //c1.show(mainPanel, "3");
                        //System.out.println("round finished.Presh botton to continue ");
                        /*if (s.hasNext() == true) {
                            String answer = s.next();
                            out.writeObject(answer);
                        }*/
                        ;
                    }

                    if (playerStatusClient.isGameFinished()) {
                        System.out.println("Game is finished. Your score: ");
                        // Call ResultGUI class.
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) throws IOException {
        NewClient client = new NewClient();
    }

    public void setupLayoutAndPanels() {
        mainPanel.setLayout(c1);
        mainPanel.add(catGUI, "0");
        mainPanel.add(quizGUI, "1");
        mainPanel.add(waitGUI, "2");
        mainPanel.add(nextRoundGUI, "3");
        add(mainPanel);
    }

    public void setupButtonInteraction() {
        ButtonListener buttonClick = new ButtonListener();
        catGUI.getCategory1().addActionListener(buttonClick);
        catGUI.getCategory2().addActionListener(buttonClick);
        catGUI.getCategory3().addActionListener(buttonClick);
        catGUI.getCategory4().addActionListener(buttonClick);
        quizGUI.getA1().addActionListener(buttonClick);
        quizGUI.getA2().addActionListener(buttonClick);
        quizGUI.getA3().addActionListener(buttonClick);
        quizGUI.getA4().addActionListener(buttonClick);
        nextRoundGUI.getContinueButton().addActionListener(buttonClick);
    }

    public void frameSettnings() {
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void pressAnswersColorInteraction() {
        String correctAnswer = playerStatusClient.getQuestionToAnswer().getCorrectAnswer();
        if (quizGUI.getA1().getText().equals(correctAnswer)) {
            quizGUI.getA1().setBackground(Color.green);
        } else {
            quizGUI.getA1().setBackground(Color.red);
        }

        if (quizGUI.getA2().getText().equals(correctAnswer)) {
            quizGUI.getA2().setBackground(Color.green);
        } else {
            quizGUI.getA2().setBackground(Color.red);
        }

        if (quizGUI.getA3().getText().equals(correctAnswer)) {
            quizGUI.getA3().setBackground(Color.green);
        } else {
            quizGUI.getA3().setBackground(Color.red);
        }

        if (quizGUI.getA4().getText().equals(correctAnswer)) {
            quizGUI.getA4().setBackground(Color.green);
        } else {
            quizGUI.getA4().setBackground(Color.red);
        }


    }

    public void changeAnswersToDefaultColor() {
        quizGUI.getA1().setBackground(Color.pink);
        quizGUI.getA2().setBackground(Color.pink);
        quizGUI.getA3().setBackground(Color.pink);
        quizGUI.getA4().setBackground(Color.pink);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (((JButton) e.getSource()).getText() == Category.CULTURE.getCategoryName()) {
                    out.writeObject(Category.CULTURE);

                } else if (((JButton) e.getSource()).getText() == Category.MUSIC.getCategoryName()) {
                    out.writeObject(Category.MUSIC);

                } else if (((JButton) e.getSource()).getText() == Category.SPORTS.getCategoryName()) {
                    out.writeObject(Category.SPORTS);

                } else if (((JButton) e.getSource()).getText() == Category.GAMING.getCategoryName()) {
                    out.writeObject(Category.GAMING);

                }

                if (e.getSource() == quizGUI.getA1()) {
                    pressAnswersColorInteraction();
                    answer = quizGUI.getA1().getText();
                    out.writeObject(answer);

                } else if (e.getSource() == quizGUI.getA2()) {
                    pressAnswersColorInteraction();
                    answer = quizGUI.getA2().getText();
                    out.writeObject(answer);

                } else if (e.getSource() == quizGUI.getA3()) {
                    pressAnswersColorInteraction();
                    answer = quizGUI.getA3().getText();
                    out.writeObject(answer);

                } else if (e.getSource() == quizGUI.getA4()) {
                    pressAnswersColorInteraction();
                    answer = quizGUI.getA4().getText();
                    out.writeObject(answer);
                }

                if (e.getSource() == nextRoundGUI.getContinueButton()) {
                    String send = ""; // if null, jumps to next round automatically
                    out.writeObject(send);
                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }


    }


}
