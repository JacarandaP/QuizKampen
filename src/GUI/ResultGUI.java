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

    private int pxResult;
    private int pyResult;
    JLabel playersResult = new JLabel();

    private JLabel resultText = new JLabel();
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
        playersResult.setText("<html>" + pxName + " Total Score: "
                + pxScore + "<br/>" +
                pyName +  " Total Score: " + pyScore + "</html>");

        pxResult = pxScore;
        pyResult = pyScore;

    }

    public void setWinner(String px, String py) {
        if (pxResult > pyResult) {
            resultText.setText(px + " won!!!");
        } else if (pyResult > pxResult) {
            resultText.setText(py + " won!!!");
        } else {
            resultText.setText("It's a tie!!!");
        }
    }

}
