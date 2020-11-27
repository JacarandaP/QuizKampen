package GUI;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;

/**
 * Created by Max Erling
 * Date: 2020-11-20
 * Copyright: MIT
 * Class: Java20B
 */
public class ResultGUI extends JPanel {

    int player1Score;
    int player2Score;
    String player1Name;
    String Player2Name;
    JLabel playersResult = new JLabel();

    private JLabel resultText = new JLabel("The winner is: XXXXX");
    private JPanel scorePanel = new JPanel(new BorderLayout());
    private JPanel centerPanel = new JPanel(new GridLayout(2,0));

    public ResultGUI() {
        scorePanel.setPreferredSize(new Dimension(500, 500));
        centerPanel.add(playersResult, SwingConstants.CENTER);
        centerPanel.add(resultText);
        scorePanel.add(centerPanel, BorderLayout.CENTER);
        add(scorePanel);



    }


    public void setNamesAndScore(String pxName, int pxScore, String pyName, int pyScore) {
        playersResult.setText("<html> <div style='text-align: center;/>" + pxName + ": your score in this round: "
                + pxScore + "<br/>" +
                "Your opponent's score in this round: " + pyScore + "</html>");

    }

}
