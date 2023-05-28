/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.matriz.mundo;

import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.*;

/**
 *
 * @author USUARIO
 */
public class Evaluacion {

    //atributos
    private int ocupadas;
    private int marcasJugador;
    private Casilla ocupacionLibre;


    //COnstructor
    public Evaluacion() {

        this.ocupadas = 0;

        this.marcasJugador = 0;

        this.ocupacionLibre=new Casilla();
    }

    public Evaluacion(int libres, int marcasJugador, Casilla ocupacionLibre) {
        this.ocupadas = libres;
        this.marcasJugador = marcasJugador;
        this.ocupacionLibre=ocupacionLibre;
    }

    //Set y get

    public int getOcupadas() {
        return ocupadas;
    }

    public void setOcupadas(int libres) {
        this.ocupadas = libres;
    }

    public int getMarcasJugador() {
        return marcasJugador;
    }

    public void setMarcasJugador(int marcasJugador) {
        this.marcasJugador = marcasJugador;
    }

    public Casilla getOcupacionLibre() {
        return ocupacionLibre;
    }

    public void setOcupacionLibre(Casilla ocupacionLibre) {
        this.ocupacionLibre = ocupacionLibre;
    }

 
    
}
