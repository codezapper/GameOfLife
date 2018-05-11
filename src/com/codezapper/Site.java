package com.codezapper;

import java.awt.*;

public class Site {
    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;

    private Integer id;

    public enum status {
        alive,
        dead
    }

    private status _status;

    public status getStatus() {
        return this._status;
    }

    public void setStatus(status deadOrAlive) {
        this._status = deadOrAlive;
    }

    public Site(Integer id, Integer x, Integer y, Integer width, Integer height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void draw(Graphics2D g2d) {
        if ((this.x < 0) || (this.y < 0)) {
            return;
        }
        g2d.setPaint(new Color(0, 0, 0));
        g2d.setStroke(new BasicStroke(2));
        Integer x_top_corner = x - (width / 2);
        Integer y_top_corner = y - (height / 2);
        g2d.drawRect(x_top_corner, y_top_corner, width, height);

        if (_status == status.alive) {
            g2d.setPaint(new Color(150, 150, 200));
        } else {
            g2d.setPaint(new Color(175, 175, 175));
        }
        g2d.fillRect(x_top_corner + 1, y_top_corner + 1, width - 2, height - 2);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
