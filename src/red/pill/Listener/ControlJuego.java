/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill.Listener;

import red.pill.Casilla;
import red.pill.Ficha;
import red.pill.Tablero;
import red.pill.ia.IA_Tic_tac_toe;

/**
 *
 * @author Daniel
 */
public class ControlJuego {

    private Tablero tablero;

    private JugadorHumano IH;
    private IA_Tic_tac_toe IA;

    private Casilla[] casillas;
    private Ficha[] fichas;

    public ControlJuego(boolean inicial) {

        this.tablero = new Tablero();
        casillas = tablero.getCasillas();
        fichas = tablero.getFichas();

        IH = new JugadorHumano("Daniel", tablero);
        IA = new IA_Tic_tac_toe("Susy", tablero);

        IH.setIa(IA);
        IA.setIh(IH);

        tablero.addMouseListener(IH);

        if (inicial) {
            IH.setTurno(true);

        } else {
            IA.setTurno(true);
        }

    }

    public Tablero getTablero() {
        return tablero;
    }

}
