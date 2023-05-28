/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.matriz.mundo;

import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.*;

/**
 *
 * @author SG701-21
 */
public class Jugador {
    
    //Atributos
    
    private String nombre;
    private String simbolo;
    private int numJuegos;
    private int numGanados;
    private Tablero miTablero;
    
    //Constructor

    public Jugador() {
        miTablero=new Tablero();
    }

    public Jugador(String nombre, String simbolo, int numJuegos, int numGanados, Tablero miTablero) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.numJuegos = numJuegos;
        this.numGanados = numGanados;
        this.miTablero = miTablero;
    }
    
    // MEtodos get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getNumJuegos() {
        return numJuegos;
    }

    public void setNumJuegos(int numJuegos) {
        this.numJuegos = numJuegos;
    }

    public int getNumGanados() {
        return numGanados;
    }

    public void setNumGanados(int numGanados) {
        this.numGanados = numGanados;
    }

    public Tablero getMiTablero() {
        return miTablero;
    }

    public void setMiTablero(Tablero miTablero) {
        this.miTablero = miTablero;
    }
    
    
    
    
}
