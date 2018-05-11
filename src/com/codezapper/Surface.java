package com.codezapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Surface extends JPanel {
    private Site[] sites;
    private Graphics2D g2d = null;

    private int width;
    private int height;

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    private int columns;
    private int rows;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width * (columns + 1), height * (rows + 1));
    }

    private void initSites() {
        sites = new Site[(rows * columns)];
        int i = 0;
        for (Integer row = 0; row < rows; row++) {
            for (Integer column = 0; column < columns; column++) {
                sites[i] = new Site(i, (column + 1) * width, (row + 1) * height, width, height);
                i++;
            }
        }
    }

    public Surface(Integer rows, Integer columns, Integer width, Integer height) {
        this.rows = rows;
        this.columns = columns;
        this.width = width;
        this.height = height;
        initSites();
    }

    public ArrayList<Integer> getAdjacents(int x, int y) {
        int[][] coords = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
        ArrayList<Integer> retValue = new ArrayList<>();

        for (int[] coord : coords) {
            try {
                int _x = coord[0];
                int _y = coord[1];
                if ((_x < 0) || (_x >= columns)) {
                    continue;
                }

                if (_y >= rows) {
                    continue;
                }

                if (_y < 0) {
                    continue;
                }

                int id = getIdFromCoords(_x, _y);

                if (id > -1) {
                    retValue.add(id);
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Skipping because out of bounds");
            }
        }

        return retValue;
    }

    public void startRandom() {
        initSites();
    }

    public int getIdFromCoords(int x, int y) {
        if (y < 0) {
            return -1;
        }

        if ((x < 0) || (x >= columns) || (y >= rows)) {
            return -1;
        }

        int tempId = x + (columns * y);
        if (tempId > ((columns * rows) - 1)) {
            tempId = -1;
        }
        return tempId;
    }

    public int[] getCoordsFromId(int id) {
        int[] coords = new int[2];
        if (id < 0) {
            coords[0] = -1;
            coords[1] = -1;
        } else {
            coords[0] = id % columns;
            coords[1] = id / columns;
        }
        return coords;
    }

    private void doDrawing(Graphics g) {
        if (g2d == null) {
            g2d = (Graphics2D) g;
        }

        for (Site site : sites) {
            site.draw((Graphics2D) g);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
