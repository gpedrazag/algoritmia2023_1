/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda.arreglos;

import co.edu.unipiloto.algoritmia.tienda.*;

/**
 *
 * @author SG701-21
 */
public class Producto {

    //Constantes
    public final static int PAPELERIA = 1;
    public final static int SUPERMERCADO = 2;
    public final static int DROGUERIA = 3;

    //Constantes para el IVA
    public final static double IVA_PAPEL = 0.16;
    public final static double IVA_MERCADO = 0.04;
    public final static double IVA_FARMACIA = 0.12;

    //Atributos
    private String nombre;
    private int tipo;
    private int cantidadBodega;
    private int cantidadMinima;
    private double valorUnitario;
    private int totalProductosVendidos;

    //Declarar constructores
    public Producto() {
        this.nombre = "";
    }

    public Producto(String nombre, int tipo, int cantidadBodega, int cantidadMinima, double valorUnitario, int totalProductosVendidos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMinima = cantidadMinima;
        this.valorUnitario = valorUnitario;
        this.totalProductosVendidos = totalProductosVendidos;
    }

    //Metodos get y set 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(int cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getTotalProductosVendidos() {
        return totalProductosVendidos;
    }

    public void setTotalProductosVendidos(int totalProductosVendidos) {
        this.totalProductosVendidos = totalProductosVendidos;
    }

    //Visualizar los contenidos de los objetos Producto to string
    @Override
    public String toString() {
        return "\n Producto{" + "nombre=" + nombre + ", tipo=" + getTipoNombre() + ", cantidadBodega=" + cantidadBodega + ", cantidadMinima=" + cantidadMinima + ", valorUnitario=" + valorUnitario + ", totalProductosVendidos=" + totalProductosVendidos + '}';
    }

    //Metodos de negocio
    //determinar si hay suficiente stock para la venta
    public boolean haySuficienteCantidad(int cant_venta) {

        if (this.cantidadBodega >= cant_venta) {
            return true;
        }
        return false;
    }

    //Calcular el valor de un producto de papelería con o sin IVA.
    //  public double valorConSinIVA(boolean conIVA) {
    //      if()
    //  }
    //subir Valor Unitario
    public double subirValorUnitario() {

        if (this.valorUnitario < 1000) {
            return (this.valorUnitario * (1 + 0.01));
        } else if (this.valorUnitario >= 1000 && this.valorUnitario <= 5000) {
            return (this.valorUnitario * (1 + 0.02));
        }
        return (this.valorUnitario * (1 + 0.03));

    }

    //Se vende una cantidad de productos
    public boolean venderCantidadProductosSiHay(int cantVendida) {
        //Analizamos si hay suficientes productos

        //Si hay suficientes productos actualizamos
        if (haySuficienteCantidad(cantVendida)) {
            this.totalProductosVendidos += cantVendida;
            this.cantidadBodega -= cantVendida;
            return true;
        }
        //Sino hay suficentes productos rechazamos la venta

        return false;
    }

    //Vender hasta completar la cantidad disponible
    public void venderLoQueHay(int cantSolicitada) {
        //SI la cantidad a vender es mayor que la cantidad disponible en bodega
        if (haySuficienteCantidad(cantSolicitada)) {
            this.totalProductosVendidos += cantSolicitada;
            this.cantidadBodega -= cantSolicitada;
        } else {
            this.totalProductosVendidos += this.cantidadBodega;
            this.cantidadBodega = 0;
        }

    }
    
    //AJustar precio dependiendo de las ventas alcanzadas
    public double ajustarPrecioPorVentas (){
        //Si se han vendido menos de 100 productos 
        if(this.totalProductosVendidos<100)
            
        //se hace descuento del 20%. 
            return (this.valorUnitario*(1-0.2));

    //Si se han vendido 100 o más productos 
        else
        //se hace un incremento del 10% al valor unitario.
            return (this.valorUnitario*(1+0.1));

    }
    
    //Retornar el nombre del tipo de producto
    public String getTipoNombre(){
        String tipoNombre="";
        switch (this.tipo) {
            case Producto.PAPELERIA:
                tipoNombre="Papeleria";
                break;
            case Producto.SUPERMERCADO:
                 tipoNombre="Supermercado";
                break;
            case Producto.DROGUERIA:
                 tipoNombre="Drogueria";;
                break;
        }
        return tipoNombre;
    }
    
   

}
