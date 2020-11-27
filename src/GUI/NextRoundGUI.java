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

    private JLabel txt = new JLabel();
    private JPanel waitingPanel = new JPanel(new GridBagLayout());
    private JButton continueButton = new JButton("Continue");

    private int scorePlayerX;
    private int scorePlayerY;

    private JLabel playerXName = new JLabel();
    private JLabel playerYName = new JLabel();

    public NextRoundGUI(String text)  {

        txt.setText(text);
        waitingPanel.setPreferredSize(new Dimension(500,500));
        waitingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        waitingPanel.add(txt);
        waitingPanel.add(continueButton);
        //playerXName.setText(playerX);
        //playerYName.setText(playerY);
        waitingPanel.add(playerXName);
        waitingPanel.add(playerYName);
        add(waitingPanel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setPlayerNames(String playerX, String playerY) {
        this.playerXName.setText(playerX);
        this.playerYName.setText(playerY);
    }


}
