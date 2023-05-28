/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.matriz.interfaz;

import co.edu.unipiloto.algoritmia.triqui.matriz.interfaz.*;
import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.Casilla;
import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author SG701-21
 */
public class PanelTablero extends JPanel {

    //Referencia a la clase controladora
    private InterfazTriqui principal;
    private Jugador unJugador;

        //Declarar las casillas del triqui
    private JButton[][] botones;
   

    private String marca = " ";
    private Casilla casillaMaquina;
    private int i,j=0;

    //Declarar casillas triquie
    //Definir el constructor
    public PanelTablero(InterfazTriqui principal, Jugador jugador) {
        //Asigna referencia a la interfaz Frame
        this.principal = principal;
        this.unJugador = jugador;
        //Asignar layout
        this.setLayout(new GridLayout(3, 3));
        //Definir tamaño de ventana
        this.setPreferredSize(new Dimension(0, 200));
        //Adicionar titulo
        TitledBorder border = BorderFactory.createTitledBorder("Tablero");
        border.setTitleColor(Color.DARK_GRAY);
        this.setBorder(border);
 
        //Inicializar los botones
          botones=new JButton [InterfazTriqui.TAMANO][InterfazTriqui.TAMANO];
           casillaMaquina=new Casilla();
        for ( i=0; i<InterfazTriqui.TAMANO;i++){
            for (j=0; j<InterfazTriqui.TAMANO; j++) {
                //Instanciando cada boton del arreglo
                botones [i][j]=new JButton("F"+i+"C"+j);
                botones [i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("EVENTO "+e.getActionCommand().toString().substring(1, 1));
                        String accion= e.getActionCommand().toString();
                        i=Integer.parseInt(accion.substring(1, 2));
                        j=Integer.parseInt(accion.substring(3, 4));
                        botones [i][j].setText(unJugador.getMiTablero().getMarca());
                        unJugador.getMiTablero().jugar(i, j, unJugador.getMiTablero().getMarca());
                        casillaMaquina=unJugador.getMiTablero().jugarMaquina();
                        unJugador.getMiTablero().mostrarTablero();
                        actualizarBoton(casillaMaquina);
                    }
                });
                this.add (botones[i][j]);
            }
                
        }
        
       
    
        //Adicionar elementos al layout
        

    }

    public void actualizarBoton(Casilla seleccion) {
        botones[seleccion.getPosx()][seleccion.getPosy()].setText(seleccion.getMarca());
    }

}
