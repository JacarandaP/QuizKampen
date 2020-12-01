package GUI;

import javax.swing.*;
import java.awt.*;

public class ResultGUI extends JPanel {

    private int pxResult;
    private int pyResult;

    private JLabel playersResult = new JLabel();
    private JLabel winnerText = new JLabel();
    private JPanel scorePanel = new JPanel(new BorderLayout());
    private JPanel panelHolder = new JPanel(new GridLayout(2, 0));
    private JPanel resultPanel = new JPanel();
    private JPanel winnerPanel = new JPanel();

    public ResultGUI() {
        resultPanel.add(playersResult);
        winnerPanel.add(winnerText);
        panelHolder.add(resultPanel);
        panelHolder.add(winnerPanel);
        scorePanel.add(panelHolder, BorderLayout.CENTER);
        scorePanel.setPreferredSize(new Dimension(500, 500));
        add(scorePanel);
    }

    public void setNamesAndScore(String pxName, int pxScore, String pyName, int pyScore) {
        playersResult.setText("<html>" + pxName + " - Total poängställning: "
                + pxScore + "<br/>" +
                pyName + " - Total poängställning: " + pyScore + "</html>");

        pxResult = pxScore;
        pyResult = pyScore;
    }

    public void setWinner(String px, String py) {
        if (pxResult > pyResult) {
            winnerText.setText(px + " vann!!!");
            winnerText.setForeground(Color.GREEN);
        } else if (pyResult > pxResult) {
            winnerText.setText(py + " vann!!!");
            winnerText.setForeground(Color.GREEN);
        } else {
            winnerText.setText("Det blev oavgjort!!!");
        }
    }
}
