package Clientside;

import GUI.CategoryGUI;
import GUI.QuizGUI;
import GUI.WaitingGUI;
import Serverside.Category;
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
                PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true)) {
            var in = new ObjectInputStream(socketToServer.getInputStream());
            Object fromServer;

            while ((fromServer = in.readObject()) != null) {
                System.out.println("jag fick nagot");
                if (fromServer instanceof String) {
                    System.out.println("Resultat: " + fromServer);
                }
                if (fromServer instanceof Question) {
                    System.out.println(((Question) fromServer).getQuestionText());
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
        c1.show(mainPanel, "0");
        add(mainPanel);
    }

    public void setupButtonInteraction() {
        ButtonListener buttonClick = new ButtonListener();
        catGUI.getCategory1().addActionListener(buttonClick);
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

            if (e.getSource() == quizGUI.getA4()) {
                c1.show(mainPanel, "2");
            }
        }
    }



}
