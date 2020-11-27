package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Karl Danielsson - JAVA 20B
 * Date: 2020-11-25
 * Time: 13:48
 * Project: QuizKampen
 */
public class NextRoundGUI extends JPanel {


    private JPanel waitingPanel = new JPanel(new BorderLayout());
    private JButton continueButton = new JButton("Continue");
    private JLabel playersResult = new JLabel();
    private JPanel resultPanel = new JPanel();

    public NextRoundGUI()  {

        resultPanel.add(playersResult);
        resultPanel.setPreferredSize(new Dimension(100,100));
        resultPanel.setBackground(Color.CYAN);
        waitingPanel.setPreferredSize(new Dimension(500,500));
        waitingPanel.add(continueButton, BorderLayout.SOUTH);
        //playerXName.setText(playerX);
        //playerYName.setText(playerY);
        waitingPanel.add(resultPanel, BorderLayout.CENTER);
        add(waitingPanel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }
    public void setNamesAndScore(String pxName, int pxScore, String pyName, int pyScore) {
        playersResult.setText("<html>" + pxName + " Score: "
                + pxScore + "<br/>" +
                pyName +  " Score: " + pyScore + "</html>");

    }





}
