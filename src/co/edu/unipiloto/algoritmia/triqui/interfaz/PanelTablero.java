/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.interfaz;

import co.edu.unipiloto.algoritmia.triqui.mundo.Casilla;
import co.edu.unipiloto.algoritmia.triqui.mundo.Jugador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
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
    private JButton botonSI;
    private JButton botonSC;
    private JButton botonSD;
    private JButton botonMI;
    private JButton botonMC;
    private JButton botonMD;
    private JButton botonII;
    private JButton botonIC;
    private JButton botonID;

    private String marca = "X";
    private Casilla casillaMaquina;

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
        botonSI = new JButton("SI");
        //Inicializar casilla de la maquina
        casillaMaquina=new Casilla();
        botonSI.addActionListener((e) -> {
            botonSI.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.SUPERIOR_IZQUIERDA, unJugador.getMiTablero().getMarca());

            //actualizarBoton(unJugador.getMiTablero().jugarMaquina(),"+");
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().jugar(casillaMaquina.getPosicion(), unJugador.getMiTablero().getMarca());
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonSC = new JButton("SC");
        botonSC.addActionListener((e) -> {
            botonSC.setText(marca);
            
            unJugador.getMiTablero().jugar(Casilla.SUPERIOR_CENTRO, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });
        botonSD = new JButton("SD");
        botonSD.addActionListener((e) -> {
            
            botonSD.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.SUPERIOR_DERECHA, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonMI = new JButton("MI");
        botonMI.addActionListener((e) -> {
            
            botonMI.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.MEDIO_IZQUIERDA, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonMC = new JButton("MC");
        botonMC.addActionListener((e) -> {
            
            botonMC.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.MEDIO_CENTRO, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonMD = new JButton("MD");
        botonMD.addActionListener((e) -> {
            
            botonMD.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.MEDIO_DERECHA, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonII = new JButton("II");
        botonII.addActionListener((e) -> {
            
            botonII.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.INFERIOR_IZQUIERDA, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });

        botonIC = new JButton("IC");
        botonIC.addActionListener((e) -> {
           
            botonIC.setText(marca);
            unJugador.getMiTablero().jugar(Casilla.INFERIOR_CENTRO, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });
        botonID = new JButton("ID");
        botonID.addActionListener((e) -> {
            botonID.setText(marca);
          
            unJugador.getMiTablero().jugar(Casilla.INFERIOR_DERECHA, unJugador.getMiTablero().getMarca());
            casillaMaquina=unJugador.getMiTablero().jugarMaquina();
            unJugador.getMiTablero().mostrarTablero();
            actualizarBoton(casillaMaquina);
        });
        //dEFINIR EL LAYOUT
        this.setLayout(new GridLayout(3, 3));
        //Adicionar elementos al layout
        this.add(botonSI);
        this.add(botonSC);
        this.add(botonSD);
        this.add(botonMI);
        this.add(botonMC);
        this.add(botonMD);
        this.add(botonII);
        this.add(botonIC);
        this.add(botonID);

    }

    public void actualizarBoton(Casilla seleccion) {
        System.out.println("INTERFAZ actualizando "+seleccion.getPosicion());
        switch (seleccion.getPosicion()) {
            case Casilla.SUPERIOR_IZQUIERDA:
                //unJugador.getMiTablero().getMarcaAplicacion();
                botonSI.setText(seleccion.getMarca());
                break;
            case Casilla.SUPERIOR_CENTRO:
                botonSC.setText(seleccion.getMarca());
                break;
            case Casilla.SUPERIOR_DERECHA:
                botonSD.setText(seleccion.getMarca());
                break;
            case Casilla.MEDIO_IZQUIERDA:
                botonMI.setText(seleccion.getMarca());
                break;
            case Casilla.MEDIO_CENTRO:
                botonMC.setText(seleccion.getMarca());
                break;
                
            case Casilla.MEDIO_DERECHA:
                botonMD.setText(seleccion.getMarca());
                break;
            case Casilla.INFERIOR_IZQUIERDA:
                //unJugador.getMiTablero().getMarcaAplicacion();
                botonII.setText(seleccion.getMarca());
                break;
            case Casilla.INFERIOR_CENTRO:
                botonIC.setText(seleccion.getMarca());
                break;
            case Casilla.INFERIOR_DERECHA:
                botonID.setText(seleccion.getMarca());
                break;
             
            default:
                throw new AssertionError();
        }
    }

}
