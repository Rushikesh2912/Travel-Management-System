package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {

    Thread t;
    JProgressBar bar;
    String username;

    public void run() {
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum(); //100
                int value = bar.getValue(); //1--100

                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);

        setBounds(430, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //Application name
        JLabel text = new JLabel("Travel And Tourism Application");
        text.setBounds(50, 20, 600, 40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        //Progress Bar
        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        //Loadiing PLeases Wait Bar
        JLabel loading = new JLabel("Loading,Please wait...");
        loading.setBounds(230, 130, 200, 30);
        loading.setForeground(Color.RED);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);

        //Loadiing PLeases Wait Bar
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblusername);

        t.start();
        setVisible(true);
    }

    public static void main(String args[]) {
        new Loading("");
    }
}