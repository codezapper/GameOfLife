package com.codezapper;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Main {
    private Surface surface;
    private JLabel lblStats = new JLabel("");

    private Main() {
        initUI();
    }

    private void initUI() {
        JFrame frame = new JFrame("CustomLayoutDemo");
        Container pane = frame.getContentPane();
        surface = new Surface(5, 5, 30, 30);

        pane.setLayout(new BorderLayout());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnStartRandom = new JButton("Start random simulation");
        JButton btnStop = new JButton("Stop simulation");
        JButton btnNext = new JButton("Next generation");
        JButton btnQuit = new JButton("Quit");

        btnPanel.add(btnStartRandom);
        btnPanel.add(btnStop);
        btnPanel.add(btnNext);
        btnPanel.add(btnQuit);
        JPanel topPanel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());

        btnStartRandom.addActionListener(e -> {
            return;
        });
//        btnStop.addActionListener(e -> surface.showConnected());
        btnNext.addActionListener(e -> surface.nextGeneration());
        btnQuit.addActionListener(e -> System.exit(0));

        lblStats.setPreferredSize(new Dimension(100, 100));
        topPanel.add(surface);
        topPanel.add(lblStats);

        surface.open(1, 1);
        surface.open(1, 2);
        surface.open(1, 3);

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
