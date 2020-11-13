package Clientside;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends JFrame {

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

    private final int port = 54321;
    private final String hostName = "127.0.0.1";



    public Client() {
        setUpGUI(true);

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

    private void setUpGUI(boolean state){
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

    public static void main(String[] args) {
        Client client = new Client();
    }
}
