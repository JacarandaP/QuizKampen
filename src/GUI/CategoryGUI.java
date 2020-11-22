package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Max Erling
 * Date: 2020-11-17
 * Copyright: MIT
 * Class: Java20B
 */
public class CategoryGUI extends JPanel {

    JLabel winnerLabel = new JLabel("Vinnare:");
    JButton category1 = new JButton("Kultur");
    JButton category2 = new JButton("Musik");
    JButton category3 = new JButton("Sport");
    JButton category4 = new JButton("Gaming");
    private JPanel gamePanel = new JPanel();
    private JPanel statusPanel = new JPanel();
    private JPanel categoryPanel = new JPanel(new BorderLayout());
    JPanel namePanel = new JPanel();
    JLabel nameLabel = new JLabel("Fråga:");




    public CategoryGUI() {
        gamePanel.setLayout(new GridLayout(2,2));
        //category1.addActionListener(buttonClick); //***
        category1.setEnabled(true);
        category1.setBackground(Color.lightGray);
        gamePanel.add(category1);


        //category2.addActionListener(buttonClick);
        category2.setEnabled(true);
        gamePanel.add(category2);

        //category3.addActionListener(buttonClick);
        category3.setEnabled(true);
        gamePanel.add(category3);

        //category4.addActionListener(buttonClick);
        category4.setEnabled(true);
        gamePanel.add(category4);


        statusPanel.add(winnerLabel);

        namePanel.setBackground(Color.RED);
        namePanel.add(nameLabel);

        categoryPanel.add(namePanel,BorderLayout.NORTH);
        categoryPanel.add(gamePanel, BorderLayout.CENTER);
        categoryPanel.add(statusPanel, BorderLayout.SOUTH);
        categoryPanel.setPreferredSize(new Dimension(500,500));
        add(categoryPanel);
    }







    public JButton getCategory1() {
        return category1;
    }

    public JButton getCategory2() {
        return category2;
    }

    public JButton getCategory3() {
        return category3;
    }

    public JButton getCategory4() {
        return category4;
    }
}

