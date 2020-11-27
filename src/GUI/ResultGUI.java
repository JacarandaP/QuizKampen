package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Max Erling
 * Date: 2020-11-20
 * Copyright: MIT
 * Class: Java20B
 */
public class ResultGUI {

    int player1Score;
    int player2Score;
    String player1Name;
    String Player2Name;

    private JLabel resultText = new JLabel("The winner is: XXXXX");
    private JLabel playerScoreContent = new JLabel("Scoring: PlayerX: 1 correct answers / PlayerY: 3 correct answers");
    private JButton pressContinue = new JButton("continue");
    private JPanel scorePanel = new JPanel(new BorderLayout());
}
