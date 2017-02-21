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

    public boolean col(Casilla.Propietario a, int numCol) {

        for (int i = numCol - 1; i <= 8; i += 3) {
            if (casillas[i].getPropietario() != a) {
                return false;
            }
        }
        return true;
    }

    public boolean fil(Casilla.Propietario a, int numFil) {
        return false;
    }

}
