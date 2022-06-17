package FrontEnd;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends SistakaPanel {
    private static JButton startButton = new JButton("Start to Draw!");
    private static JButton exitButton = new JButton("Exit");

    public WelcomePanel(HomeGUI homeGUI) {
        super(homeGUI);
        setLayout(null);
        ImageIcon welcomeImg = new ImageIcon("Assets/bg-home.png");
        JPanel iconWelcome = new JPanel();
        JLabel imgWelcome = new JLabel();
        imgWelcome.setIcon(welcomeImg);
        iconWelcome.add(imgWelcome);
        iconWelcome.setBounds(0, 0, 900, 600);
        welcomeImg.setImage(welcomeImg.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT));

        startButton.setBounds(80, 380, 200, 40);
        startButton.setBackground(Color.decode("#4552FE"));

        exitButton.setBounds(300, 380, 100, 40);
        exitButton.setBackground(Color.decode("#4552FE"));

        add(startButton);
        add(exitButton);
        add(iconWelcome);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.setPanel("drawIOPanel");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.exit();
            }
        });
    }

}
