/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill.ia;

import red.pill.Casilla;
import red.pill.Tablero;

/**
 *
 * @author Daniel
 */
public class Estructuras {

    private Casilla[] casillas;

    public Estructuras(Tablero tab) {
        this.casillas = tab.getCasillas();
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

}
