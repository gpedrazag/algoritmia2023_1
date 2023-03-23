/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.simulador;

/**
 *
 * @author USUARIO
 */
class CDT {
    //KConstantes
    
    public static final double tasa_CDT=0.01;
    
    //Atributos
    private double valorApertura;
    private Fecha fechaApertura;
    private double valorLiquidacion;
    private int meses;
    
    
    // Constructor

    public CDT() {
        this.fechaApertura=new Fecha();
        
    }

    public CDT(double valorApertura, Fecha fechaApertura, double valorLiquidacion, int meses) {
        this.valorApertura = valorApertura;
        this.fechaApertura = fechaApertura;
        this.valorLiquidacion = valorLiquidacion;
        this.meses = meses;
    }
    
    //Get y seat

    public double getValorApertura() {
        return valorApertura;
    }

    public void setValorApertura(double valorApertura) {
        this.valorApertura = valorApertura;
    }

    public Fecha getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Fecha fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getValorLiquidacion() {
        return valorLiquidacion;
    }

    public void setValorLiquidacion(double valorLiquidacion) {
        this.valorLiquidacion = valorLiquidacion;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
    
    // MOstrar contenido

    @Override
    public String toString() {
        return "CDT{" + "valorApertura=" + valorApertura + ", fechaApertura=" + fechaApertura + ", valorLiquidacion=" + valorLiquidacion + ", meses=" + meses + '}';
    }
    
    //Abrir CDT
    
    public void abrirCDT(Fecha apertura, double valor, int meses){
        this.fechaApertura=apertura;
        this.valorApertura=valor;
        this.meses=meses;
        
    }
    
    // Liquidar CDT
    
    
    
    
}
