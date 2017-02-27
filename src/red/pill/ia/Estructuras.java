/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill.ia;

import java.util.HashMap;
import red.pill.Casilla;
import red.pill.Tablero;

/**
 *
 * @author Daniel
 */
public class Estructuras {

    private Casilla[] casillas;
    private HashMap<Casilla, Integer> jugadas;

    public Estructuras(Tablero tab) {
        this.casillas = tab.getCasillas();
        jugadas = new HashMap<>();
    }

    private Casilla.Propietario contrario(Casilla.Propietario a) {
        if (a == Casilla.Propietario.IA) {
            return Casilla.Propietario.USUARIO;
        } else if (a == Casilla.Propietario.USUARIO) {
            return Casilla.Propietario.IA;
        } else {
            return null;
        }
    }

    public boolean colVal(Casilla.Propietario a, int numCol) {

        for (int i = numCol - 1; i <= (numCol - 1) + 6; i += 3) {
            if (casillas[i].getPropietario() != a
                    || casillas[i].getPropietario() != Casilla.Propietario.LIBRE) {
                return false;
            }
        }
        return true;
    }

    public boolean filVal(Casilla.Propietario a, int numFil) {
        for (int i = numFil - 1; i <= (numFil - 1) + 2; i++) {
            if (casillas[i].getPropietario() != a
                    || casillas[i].getPropietario() != Casilla.Propietario.LIBRE) {
                return false;
            }
        }
        return true;
    }

    public boolean diagVal(Casilla.Propietario a, int numDiag) {
        switch (numDiag) {
            case 1:
                for (int i = 0; i <= 8; i += 4) {
                    Casilla temp = casillas[i];
                    if (temp.getPropietario() != a || temp.getPropietario() != Casilla.Propietario.LIBRE) {
                        return false;
                    }
                }
                return true;
            case 2:
                for (int i = 2; i <= 6; i += 2) {
                    Casilla temp = casillas[i];
                    if (temp.getPropietario() != a || temp.getPropietario() != Casilla.Propietario.LIBRE) {
                        return false;
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public Casilla obtMM(Casilla.Propietario a) {
        Casilla temp = null;

        for (int i = 0; i < casillas.length; i++) {
            if (casillas[i].getPropietario() == Casilla.Propietario.LIBRE) {
                casillas[i].setPropietario(a);
                for (int y = 0; y < casillas.length; y++) {
                    if (casillas[i].getPropietario() == Casilla.Propietario.LIBRE) {
                        casillas[i].setPropietario(contrario(a));
                    }
                }
            }
        }
        return temp;
    }

}
