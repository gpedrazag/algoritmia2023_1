/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.chequera;

/**
 *
 * @author USUARIO
 */
public class CuentaCorriente {
    
    //Atributo
    private int numero;
    private double saldo;
    
    //Constructor

    public CuentaCorriente() {
        this.numero=0;
        this.saldo=0.0;
    }

    public CuentaCorriente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    //Metodos get y set

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //Metodos de negocio
    
    public void consignar (Double valor){
        this.saldo+=valor;
    }
    
    public void retirar (Double valor){
        if (valor> this.saldo)
            System.out.println("No hay fondos suficientes para el retiro");
        else
            this.saldo-=valor;
    }
    
    
}
