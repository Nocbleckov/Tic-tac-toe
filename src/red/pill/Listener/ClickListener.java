/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill.Listener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.geometry.BoundingBox;
import red.pill.Casilla;
import red.pill.Ficha;
import red.pill.Tablero;

/**
 *
 * @author Daniel
 */
public class ClickListener implements MouseListener {

    public BoundingBox clcBox;
    private Casilla[] casillas;
    private Ficha[] fichas;
    int contador = 0;
    Tablero tab;

    public ClickListener(Tablero tab) {
        this.casillas = tab.getCasillas();
        this.fichas = tab.getFichas();
        this.tab = tab;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clcBox = new BoundingBox(e.getPoint().x, e.getPoint().y, 5, 5);
        Casilla temp = enCasilla();
        if (temp != null && !temp.ocupada()) {
            System.out.println(temp.getId());
            temp.setOcupada(true);
            temp.setPropietario(Casilla.Propietario.USUARIO);
            agregarFicha(temp);
        }
        tab.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        clcBox = null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public Casilla enCasilla() {
        Casilla casSlc = null;
        for (Casilla casilla : casillas) {
            if (casilla.dentro(clcBox)) {
                casSlc = casilla;
                break;
            }
        }
        return casSlc;
    }

    public void agregarFicha(Casilla cas) {
        /*fichas[contador] = new Ficha(cas.getPosX(), cas.getPosY(), Color.RED);
        contador++;*/
        Ficha temp = new Ficha(cas.getPosX(), cas.getPosY(), Color.red);
        for (int i = 0; i < fichas.length; i++) {
            if (fichas[i] == null) {
                fichas[i] = temp;
                break;
            }
        }
    }

}
