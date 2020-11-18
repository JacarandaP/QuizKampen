package Clientside;

import Serverside.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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


    Socket socketToServer = new Socket(hostName, port);
    ObjectOutputStream out = new ObjectOutputStream(socketToServer.getOutputStream());

    public Client() throws IOException {
        setUpCategory(false);
        setUpQuestions(true);

        try (
             PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true)) {
            var in = new ObjectInputStream(socketToServer.getInputStream());
            Object fromServer;

            while ((fromServer = in.readObject()) != null) {
                System.out.println("jag fick nagot");
                if(fromServer instanceof String) {
                    System.out.println("Resultat: " + fromServer);
                }
                if( fromServer instanceof Question) {
                    System.out.println(((Question)fromServer).getQuestionText());
                }

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    private void setUpCategory(boolean state){
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

        JLabel nameLabel = new JLabel("Fråga:");
        //txtName = new JTextField(15);
        //nameButton = new JButton("Save");
       // nameButton.setEnabled(true);
       // nameButton.addActionListener(saveName);
        namePanel.add(nameLabel);
       // namePanel.add(txtName);
        //namePanel.add(nameButton);

        gamePanel.setLayout(new GridLayout(2,2));

        category1 = new JButton("Kultur");
        category1.addActionListener(buttonClick);
        category1.setEnabled(true);
        gamePanel.add(category1);

        category2 = new JButton("Musik");
        category2.addActionListener(buttonClick);
        category2.setEnabled(true);
        gamePanel.add(category2);

        category3 = new JButton("Sport");
        category3.addActionListener(buttonClick);
        category3.setEnabled(true);
        gamePanel.add(category3);

        category4 = new JButton("Gaming");
        category4.addActionListener(buttonClick);
        category4.setEnabled(true);
        gamePanel.add(category4);

        statusPanel.add(label);
        statusPanel.add(player2);
        statusPanel.add(winnerLabel);

        frame.getContentPane().add(BorderLayout.NORTH, namePanel);
        frame.getContentPane().add(BorderLayout.CENTER, gamePanel);
        frame.getContentPane().add(BorderLayout.SOUTH, statusPanel);

        frame.setVisible(state);

    }

    ActionListener buttonClick = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                try {
                     if(((JButton)e.getSource()).getText() == "Kultur") {
                        out.writeObject("KULTUR");
                        category1.setEnabled(true);
                        category2.setEnabled(false);
                        category3.setEnabled(false);
                        category4.setEnabled(false);
                    }
                    else if(((JButton)e.getSource()).getText() == "Musik") {
                        out.writeObject("MUSIK");
                        category1.setEnabled(false);
                        category2.setEnabled(true);
                        category3.setEnabled(false);
                        category4.setEnabled(false);
                    }
                    else if(((JButton)e.getSource()).getText() == "Sport") {
                        out.writeObject("SPORT");
                        category1.setEnabled(false);
                        category2.setEnabled(false);
                        category3.setEnabled(true);
                        category4.setEnabled(false);
                    }
                     else if(((JButton)e.getSource()).getText() == "Gaming") {
                         out.writeObject("GAMING");
                         category1.setEnabled(false);
                         category2.setEnabled(false);
                         category3.setEnabled(false);
                         category4.setEnabled(true);
                     }

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                /*
                * 1. Skicka vald kategori till servern
                * 2. Valj en fraga i vald kategori pa servern
                * 3. Skicka fragan till klienten
                * ?. Vilken av klienterna ar det som skickar?
                * ?. Hur haller vi reda pa totala scoren?
                * */

        }
        };


    public static void main(String[] args) throws IOException {
        Client client = new Client();
    }
}
