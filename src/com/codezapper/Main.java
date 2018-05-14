package com.codezapper;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;


public class Main {
    private Surface surface;
    private JLabel lblStats = new JLabel("");
    Timer timer;

    private Main() {
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("CustomLayoutDemo");
        Container pane = frame.getContentPane();
        surface = new Surface(15, 15, 30, 30);

        pane.setLayout(new BorderLayout());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnStart = new JButton("Start simulation");
        JButton btnStop = new JButton("Stop simulation");
        JButton btnNext = new JButton("Next generation");
        JButton btnQuit = new JButton("Quit");

        btnPanel.add(btnStart);
        btnPanel.add(btnStop);
        btnPanel.add(btnNext);
        btnPanel.add(btnQuit);
        JPanel topPanel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());

        btnStart.addActionListener(e -> {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    surface.nextGeneration();
                }
            }, 250, 250);
        });
        btnStop.addActionListener(e -> timer.cancel());
        btnNext.addActionListener(e -> surface.nextGeneration());
        btnQuit.addActionListener(e -> System.exit(0));

        lblStats.setPreferredSize(new Dimension(100, 100));
        topPanel.add(surface);
        topPanel.add(lblStats);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        pane.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main ex = new Main();
        });
    }
}
