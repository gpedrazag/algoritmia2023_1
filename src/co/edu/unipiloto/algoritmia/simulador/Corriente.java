/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.simulador;

/**
 *
 * @author USUARIO
 */
class Corriente {
    
    //Atributos
    
    private double saldo;
    
    //Constructo

    public Corriente() {
    }

    public Corriente(double saldo) {
        this.saldo = saldo;
    }
    
    //Get y set

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
    //Mostrasr contenido

    @Override
    public String toString() {
        return "Corriente{" + "saldo=" + saldo + '}';
    }
    
    
}
