package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Max Erling
 * Date: 2020-11-20
 * Copyright: MIT
 * Class: Java20B
 */
public class WaitingGUI extends JPanel{
    private JLabel txt = new JLabel("Waiting for both players to be done");
    private JPanel waitingPanel = new JPanel(new GridBagLayout());


    public WaitingGUI()  {

        waitingPanel.setPreferredSize(new Dimension(500,500));
        waitingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        waitingPanel.add(txt);
        add(waitingPanel);
    }


}
