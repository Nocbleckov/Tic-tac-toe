/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class Tablero extends JPanel {

    private Casilla[] casillas;
    private Ficha[] fichas;

    private boolean casF = false;

    public Tablero() {
        genCasill();
        fichas = new Ficha[9];
    }

    public void genCasill() {
        casillas = new Casilla[9];
        int x = 190;
        int y = 190;
        int os = 20;
        for (int i = 0; i < 9; i++) {
            casillas[i] = new Casilla(x, y, i + 1);
            x += 50 + os;
            if (i == 2 || i == 5) {
                x = 190;
                y += 50 + os;
            }
        }
        casF = true;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (casF) {
            for (Casilla casilla : casillas) {
                if (casilla != null) {
                    casilla.colocar(g);
                }
            }
            for (Ficha ficha : fichas) {
                if (ficha != null) {
                    ficha.Colocar(g);
                }
            }
        }
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public Ficha[] getFichas() {
        return fichas;
    }

}
