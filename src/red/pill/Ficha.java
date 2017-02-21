/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Daniel
 */
public class Ficha {

    private static final int TMN = 50;

    private int posX = 0;
    private int posY = 0;

    private int x2 = 0;
    private int y2 = 0;

    private Color col;

    public Ficha(int x1, int y1, Color col) {
        this.col = col;

        x2 = x1 + 10;
        y2 = y1 + 10;

        posX = (x1 + x2) / 2;
        posY = (y1 + y2) / 2;

    }

    public void Colocar(Graphics g) {
        g.setColor(col);
        g.fillOval(posX, posY, TMN, TMN);
    }

}
