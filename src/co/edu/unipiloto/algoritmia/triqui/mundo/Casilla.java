/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.mundo;

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
    
    private int posicion;
    private String marca;
    
    //Constructores

    public Casilla() {
        this.marca=" ";
        this.posicion=0;
    }

    public Casilla(int posicion) {
        this.posicion = posicion;
        this.marca=" ";        
    }

    
    public Casilla(int posicion, String marca) {
        this.posicion = posicion;
        this.marca = marca;
    }
    
    
    //Metodos get y set

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
    
}
