package Clientside;

import GUI.CategoryGUI;
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
    private WaitingGUI waitGUI = new WaitingGUI();
    private JPanel mainPanel = new JPanel();
    private CardLayout c1 = new CardLayout();


    public NewClient() throws IOException {
        setupLayoutAndPanels();
        setupButtonInteraction();
        frameSettnings();

        try (
                Scanner s = new Scanner(System.in); //Läser från terminalen. Ska bort sen
                //printer används inte, ska bort?
                PrintWriter outP = new PrintWriter(socketToServer.getOutputStream(), true)) {
            var in = new ObjectInputStream(socketToServer.getInputStream());
            Object fromServer;
            PlayerStatus playerStatusClient = new PlayerStatus();


            //Scanner och sout ska ersättas med gui
            while ((fromServer = in.readObject()) != null) {
                    if(fromServer instanceof PlayerStatus) {
                        playerStatusClient = (PlayerStatus) fromServer;
                        if (playerStatusClient.isSelectingCategory() == true) {
                            System.out.println(playerStatusClient.getCategoriesToSelectBetween());
                            c1.show(mainPanel, "0");
                        } else if (((PlayerStatus) fromServer).isWaiting() == true){
                            System.out.println(playerStatusClient.getReasonForWaiting());
                            c1.show(mainPanel,"2");
                        }
                        if(playerStatusClient.isSelectingAnswer() == true){
                            System.out.println(playerStatusClient.getQuestionToAnswer());
                            c1.show(mainPanel,"1");

                            quizGUI.getQuestionText().setText(playerStatusClient.getQuestionToAnswer().getQuestionText());
                            quizGUI.getA1().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(0));
                            quizGUI.getA2().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(1));
                            quizGUI.getA3().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(2));
                            quizGUI.getA4().setText(playerStatusClient.getQuestionToAnswer().getAnswers().get(3));

                                if(s.hasNext() == true){ String answer = s.next();
                                out.writeObject(answer); }
                        }

                        if(playerStatusClient.isRoundFinished()){
                            System.out.println("round finished.Presh botton to continue ");
                            if(s.hasNext() == true){ String answer = s.next();
                                out.writeObject(answer); };
                        }

                        if(playerStatusClient.isGameFinished()){
                            System.out.println("Game is finished. Your score: ");
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
        add(mainPanel);
    }

    public void setupButtonInteraction() {
        ButtonListener buttonClick = new ButtonListener();
        catGUI.getCategory1().addActionListener(buttonClick);
        catGUI.getCategory2().addActionListener(buttonClick);
        catGUI.getCategory3().addActionListener(buttonClick);
        catGUI.getCategory4().addActionListener(buttonClick);
        quizGUI.getA4().addActionListener(buttonClick);
    }

    public void frameSettnings() {
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if(((JButton)e.getSource()).getText() == "Kultur") {
                    out.writeObject(Category.CULTURE);

                }
                else if(((JButton)e.getSource()).getText() == "Musik") {
                    out.writeObject(Category.MUSIC);

                }
                else if(((JButton)e.getSource()).getText() == "Sport") {
                    out.writeObject(Category.SPORTS);

                }
                else if(((JButton)e.getSource()).getText() == "Gaming") {
                    out.writeObject(Category.GAMING);

                }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }



}
