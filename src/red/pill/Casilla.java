/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill;

import java.awt.Graphics;
import javafx.geometry.BoundingBox;

/**
 *
 * @author Daniel
 */
public class Casilla {

    public enum Propietario {
        LIBRE, IA, USUARIO;
    };

    private static final int TMN = 60;
    private int id;

    private int posX = 0;
    private int posY = 0;

    private BoundingBox box;
    private boolean ocupada = false;
    private Propietario p;

    public Casilla(int posX, int posY, int id) {
        p = Propietario.LIBRE;
        this.posX = posX;
        this.posY = posY;
        this.id = id;
        box = new BoundingBox(posX, posY, TMN, TMN);
    }

    public void colocar(Graphics g) {
        g.drawRect(posX, posY, TMN, TMN);
    }

    public boolean dentro(BoundingBox b) {
        return box.contains(b);
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getId() {
        return id;
    }

    public boolean ocupada() {
        return ocupada;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Propietario getPropietario() {
        return p;
    }

    public void setPropietario(Propietario p) {
        this.p = p;
    }

}
