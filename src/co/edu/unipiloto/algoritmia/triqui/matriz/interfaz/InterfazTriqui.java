/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.matriz.interfaz;

import co.edu.unipiloto.algoritmia.triqui.matriz.interfaz.*;
import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.Jugador;
import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.Tablero;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author SG701-21
 */
public class InterfazTriqui extends JFrame{
    
     //Tamano del triquie
    public static final int TAMANO=3;

    //Atributos
    
    private PanelTablero panelTablero; 
    
    //Constructor
    
    public InterfazTriqui() throws HeadlessException {
        
        this.setTitle("Juego de triqui");
        this.setSize(350,460);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        //Inicializar el mundo
        //Instancia clases del mundo
        Jugador unJugador = new Jugador();
        Tablero miTablero = new Tablero();
        unJugador.setMiTablero(miTablero);
        unJugador.getMiTablero().seleccionarMarca();
        
        
        panelTablero=new PanelTablero(this,unJugador);
        this.add(panelTablero,BorderLayout.CENTER);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InterfazTriqui interfazTriqui= new InterfazTriqui();
        interfazTriqui.setVisible(true);
        
        //Instancia clases del mundo
        Jugador unJugador = new Jugador();
        //Tablero miTablero = new Tablero();
        //unJugador.setMiTablero(miTablero);
        unJugador.getMiTablero().seleccionarMarca();
        System.out.println(" Marca jugador "+unJugador.getMiTablero().getMarca()
                + " Maquina "+unJugador.getMiTablero().getMarcaAplicacion());
       
        
    }
    
}
