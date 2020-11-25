package GUI;

import javax.swing.*;
import java.awt.*;

public class WaitingGUI extends JPanel {
    private JLabel txt = new JLabel("Waiting...");
    private JPanel waitingPanel = new JPanel(new GridBagLayout());


    public WaitingGUI()  {

        waitingPanel.setPreferredSize(new Dimension(500,500));
        waitingPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        waitingPanel.add(txt);
        add(waitingPanel);
    }


}
