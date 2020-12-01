package GUI;

import Serverside.Category;
import Serverside.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryGUI extends JPanel {

    JButton category1 = new JButton(Category.CULTURE.getCategoryName());
    JButton category2 = new JButton(Category.MUSIC.getCategoryName());
    JButton category3 = new JButton(Category.SPORTS.getCategoryName());
    JButton category4 = new JButton(Category.GAMING.getCategoryName());
    private JPanel gamePanel = new JPanel();
    private JPanel statusPanel = new JPanel();
    private JPanel categoryPanel = new JPanel(new BorderLayout());
    JPanel namePanel = new JPanel();
    JLabel nameLabel = new JLabel("Kategori: ");

    public CategoryGUI() {
        gamePanel.setLayout(new GridLayout(2,2));
        category1.setBackground(Color.lightGray);
        category2.setBackground(Color.lightGray);
        category3.setBackground(Color.lightGray);
        category4.setBackground(Color.lightGray);
        gamePanel.add(category1);
        gamePanel.add(category2);
        gamePanel.add(category3);
        gamePanel.add(category4);
        namePanel.setBackground(Color.PINK);
        namePanel.add(nameLabel);

        categoryPanel.add(namePanel,BorderLayout.NORTH);
        categoryPanel.add(gamePanel, BorderLayout.CENTER);
        categoryPanel.add(statusPanel, BorderLayout.SOUTH);
        categoryPanel.setPreferredSize(new Dimension(500,500));
        add(categoryPanel);
    }

    public void setPlayerName(String name) {
        this.nameLabel.setText(name);
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

