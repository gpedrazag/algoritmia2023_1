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
public class Casilla {
    
     //Declarar constantes para la posicion
    public static final int SUPERIOR_IZQUIERDA=1;
    public static final int SUPERIOR_CENTRO=2;
    public static final int SUPERIOR_DERECHA=3;
    public static final int MEDIO_IZQUIERDA=4;
    public static final int MEDIO_CENTRO=5;
    public static final int MEDIO_DERECHA=6;
    public static final int INFERIOR_IZQUIERDA=7;
    public static final int INFERIOR_CENTRO=8;
    public static final int INFERIOR_DERECHA=9;
    
    //Atributos
    
     //Atributos
    
    private int posx;
    private int posy;
    private String marca;
    
    //Constructores

    public Casilla() {
        this.marca=" ";
        this.posx=-1;
        this.posx=-1;
    }

    public Casilla(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
        this.marca=" ";        
    }

    
    public Casilla(int posx, String marca) {
        this.posx = posx;
        this.posy = posy;
        this.marca = marca;
    }
    
    
    //Metodos get y set

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posicion) {
        this.posx = posicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    
}
