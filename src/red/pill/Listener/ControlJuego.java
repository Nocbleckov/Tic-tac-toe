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

    private ControlJuego(Tablero tablero, boolean inicial) {

        this.tablero = tablero;
        casillas = tablero.getCasillas();
        fichas = tablero.getFichas();

        IH = new JugadorHumano("Daniel", tablero);
        IA = new IA_Tic_tac_toe("Susy", tablero);

        if (inicial) {
            IH.setTurno(true);
            
        } else {
            IA.setTurno(true);
        }

    }

    public void iniciar() {
        new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (IA.getTurno()) {
                        IA.dummiIA();
                        IA.setTurno(false);
                        IH.setTurno(true);
                    } else if (IH.getTurno()) {
                    }
                }
            }
        }.run();
    }

}
