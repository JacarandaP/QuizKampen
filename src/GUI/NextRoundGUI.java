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

    public NextRoundGUI(String text)  {

        txt.setText(text);
        waitingPanel.setPreferredSize(new Dimension(500,500));
        waitingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        waitingPanel.add(txt);
        waitingPanel.add(continueButton);
        add(waitingPanel);
    }

    public JButton getContinueButton() {
        return continueButton;
    }
}
