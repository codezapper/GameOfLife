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
        surface = new Surface(50, 50, 15, 15);

        pane.setLayout(new BorderLayout());
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnOpenUntilConnected = new JButton("Open until connected");
        JButton btnShowConnected = new JButton("Show connection");
        JButton btnOpen = new JButton("Open random site");
        JButton btnQuit = new JButton("Quit");

        btnPanel.add(btnOpenUntilConnected);
        btnPanel.add(btnShowConnected);
        btnPanel.add(btnOpen);
        btnPanel.add(btnQuit);
        JPanel topPanel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());

        btnOpenUntilConnected.addActionListener(e -> {
            return;
        });
//        btnShowConnected.addActionListener(e -> surface.showConnected());
//        btnOpen.addActionListener(e -> surface.open(new Random().nextInt(surface.getColumns()), new Random().nextInt(surface.getRows())));
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
