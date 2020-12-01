package GUI;

import javax.swing.*;
import java.awt.*;

public class NextRoundGUI extends JPanel {

    private JPanel waitingPanel = new JPanel(new BorderLayout());
    private JButton continueButton = new JButton("Spela nästa runda");
    private JLabel playersResult = new JLabel();
    private JPanel resultPanel = new JPanel();

    public NextRoundGUI() {
        resultPanel.add(playersResult);
        resultPanel.setPreferredSize(new Dimension(100, 100));
        waitingPanel.setPreferredSize(new Dimension(500, 500));
        waitingPanel.add(continueButton, BorderLayout.SOUTH);
        waitingPanel.add(resultPanel, BorderLayout.CENTER);
        add(waitingPanel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }

    public void setNamesAndScore(String pxName, int pxScore, String pyName, int pyScore) {
        playersResult.setText("<html>" + pxName + " - Poäng: "
                + pxScore + "<br/>" +
                pyName + " - Poäng: " + pyScore + "</html>");

    }
}
