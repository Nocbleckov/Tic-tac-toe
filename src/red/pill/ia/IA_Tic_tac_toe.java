package red.pill.ia;

import java.awt.Color;
import red.pill.Casilla;
import red.pill.Ficha;
import red.pill.Listener.JugadorHumano;
import red.pill.Tablero;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel Noblecias
 */
public class IA_Tic_tac_toe {

    private Tablero tablero;
    private String nombre = "";
    private int numMov = 0;

    private Ficha[] fichas;
    private Casilla[] casillas;
    private JugadorHumano ih;

    private boolean turno = false;

    public IA_Tic_tac_toe(String nombre, Tablero tablero) {
        this.tablero = tablero;
        this.nombre = nombre;
        this.fichas = tablero.getFichas();
        this.casillas = tablero.getCasillas();
    }

    public void tirada() {
        casillas[4] = colocarFicha(casillas[4]);
        tablero.repaint();
    }

    public void dummiIA() {
        if (turno && ih.getTurno() == false) {
            for (int i = 0; i < casillas.length; i++) {
                if (casillas[i].getPropietario() == Casilla.Propietario.LIBRE) {
                    casillas[i] = colocarFicha(casillas[i]);
                    System.out.println(casillas[i].getPropietario());
                    break;
                }
            }
            tablero.repaint();
            setTurno(false);
            ih.setTurno(true);
        }
    }

    public void IA() {
        if (turno) {
            
        }
    }

    private Casilla colocarFicha(Casilla casilla) {
        if (!casilla.ocupada()) {
            Ficha temp = new Ficha(casilla.getPosX(), casilla.getPosY(), Color.blue);
            for (int i = 0; i < fichas.length; i++) {
                if (fichas[i] == null) {
                    fichas[i] = temp;
                    break;
                }
            }
            casilla.setOcupada(true);
            casilla.setPropietario(Casilla.Propietario.IA);
        }
        return casilla;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean getTurno() {
        return this.turno;
    }

    public void setIh(JugadorHumano ih) {
        this.ih = ih;
    }
}
