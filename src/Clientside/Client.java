package Clientside;

import GUI.CategoryGUI;
import GUI.QuizGUI;
import GUI.WaitingGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {
    QuizGUI quizGUI = new QuizGUI();
    CategoryGUI catGUI = new CategoryGUI();
    WaitingGUI waitGUI = new WaitingGUI();
    JPanel mainPanel = new JPanel();
    CardLayout c1 = new CardLayout();

    private final int port = 54321;
    private final String hostName = "127.0.0.1";





    public Client() {
        //setUpCategory(false);
        //setUpQuestions(true);

        mainPanel.setLayout(c1);
        mainPanel.add(catGUI,"0");
        mainPanel.add(quizGUI,"1");
        mainPanel.add(waitGUI, "3");
        c1.show(mainPanel, "0");
        add(mainPanel);
        ButtonListener buttonClick = new ButtonListener();
        catGUI.getCategory1().addActionListener(buttonClick);

        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);



        try (Socket socketToServer = new Socket(hostName, port);
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socketToServer.getInputStream()))) {

            String input;

            while ((input = in.readLine()) != null) {
                System.out.println(input);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == catGUI.getCategory1()) {
                c1.show(mainPanel,"1");

            }
        }
    }

    /*private void setUpCategory(boolean state){
        JFrame frame = new JFrame("Quizkampen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel namePanel = new JPanel();
        //namePanel.setBackground(Color.ORANGE);
        JPanel gamePanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel winnersPanel = new JPanel();

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

        frame.getContentPane().add(BorderLayout.NORTH, namePanel);
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, statusPanel);

        frame.setVisible(state);

    }

    private void setUpQuestions(boolean state){
        JFrame frame = new JFrame("Quizkampen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel namePanel = new JPanel();
        namePanel.setBackground(Color.RED);
        JPanel gamePanel = new JPanel();
        JPanel statusPanel = new JPanel();
        JPanel winnersPanel = new JPanel();

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

        frame.getContentPane().add(BorderLayout.NORTH, namePanel);
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, statusPanel);

        frame.setVisible(state);

    }

    ActionListener saveName = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            playerName = txtName.getText();
            txtName.setEnabled(false);
            nameButton.setEnabled(false);
            category1.setEnabled(true);
            category2.setEnabled(true);
            category3.setEnabled(true);
            category4.setEnabled(true);

        }
    };*/

    public static void main(String[] args) {
        Client client = new Client();
    }
}
