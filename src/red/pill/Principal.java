/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package red.pill;

import javax.swing.JFrame;
import red.pill.Listener.ClickListener;

/**
 *
 * @author Daniel
 */
public class Principal {

    public static void main(String[] args) {

        JFrame ventana = new JFrame("Tic-Tac-Toe");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 600);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);

        Tablero tab = new Tablero();
        /*tab.addMouseListener(new ClickListener(tab));*/
        ventana.add(tab);
        ventana.repaint();

    }
}
