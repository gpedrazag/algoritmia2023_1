/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda.arreglos;

import co.edu.unipiloto.algoritmia.tienda.*;
import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class Tienda {

    //atributos
    private String nombre;
    //Arreglo de productos
    //Declaracion de referencia a productos
    private Producto[] productos;
    //cantidad maxima de productos
    private int tamano;

    public Tienda() {
        //Instanciar el arreglo de productos
        productos = new Producto[tamano];

        //Inicializar cada producto del arreglo
        for (int i = 0; i < tamano; i++) {
            productos[i] = new Producto();
        }
    }

    public Tienda(String nombre, int tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
        //Inicializar el arreglo de productos y crear cada uno
        //Instanciar el arreglo de productos
        productos = new Producto[tamano];
        //Inicializar cada producto del arreglo
        // for (int i = 0; i < tamano; i++) {
        //     productos[i] = new Producto();
        // }
        int i = 0;
        while (i < tamano) {
            productos[i] = new Producto();
            i++;
        }

    }

    public int getTamano() {
        return tamano;
    }

    //Get y set
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getProducto(int posicion) {
        return productos[posicion];
    }

    public void setProducto(Producto prod, int posicion) {
        this.productos[posicion] = prod;
    }

    //to string
    @Override
    public String toString() {
        String cadena = "Tienda{" + "nombre=" + this.nombre + ", PRODUCTOS";
        for (int i = 0; i < tamano; i++) {
            cadena = cadena + "\n Producto " + productos[i].toString();
        }
        return cadena;
    }

    // Metodos de negocio
    // Calcular dinero en caja
    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaPapeleria(Producto prod) {
        double dinero = (prod.getTotalProductosVendidos() * prod.getValorUnitario())
                * (1 + Producto.IVA_PAPEL);
        System.out.println("Para producto " + prod.getNombre() + " de Papeleria Valor Caja " + dinero);
        return dinero;
    }

    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaDrogueria(Producto prod) {
        double dinero = (prod.getTotalProductosVendidos() * prod.getValorUnitario())
                * (1 + Producto.IVA_FARMACIA);
        System.out.println("Para producto " + prod.getNombre() + " de Drogueria Valor Caja " + dinero);
        return dinero;
    }

    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaSupermercado(Producto prod) {
        double dinero = (prod.getTotalProductosVendidos() * prod.getValorUnitario())
                * (1 + Producto.IVA_MERCADO);
        System.out.println("Para producto " + prod.getNombre() + " de supermercado Valor Caja " + dinero);
        return dinero;
    }

    //Calcular dinero en caja para un producto
    public double calcularDineroEnCajaProd(Producto prod) {
        if (prod.getTipo() == Producto.PAPELERIA) {
            return calcularDineroEnCajaPapeleria(prod);
        } else if (prod.getTipo() == Producto.SUPERMERCADO) {
            return calcularDineroEnCajaSupermercado(prod);
        } else {
            return calcularDineroEnCajaDrogueria(prod);
        }
    }

    //Calcular el dinero en caja para todos los productos
    public double calcularDineroEnCaja() {
        return -1;

    }

    //Obtener el valor del IVA de un producto
    public double getIvaProducto(Producto prod) {
        double ivaProd = 0.0;
        switch (prod.getTipo()) {
            case Producto.PAPELERIA:
                ivaProd = Producto.IVA_PAPEL;
                break;
            case Producto.SUPERMERCADO:
                ivaProd = Producto.IVA_MERCADO;
                break;
            case Producto.DROGUERIA:
                ivaProd = Producto.IVA_FARMACIA;
                break;
        }
        return ivaProd;

    }

    //Inicializar el arreglo de productos
    public void inicializarProductos(int cantidad) {
        this.tamano = cantidad;
        //Instanciar el arreglo de productos
        productos = new Producto[tamano];

        //Inicializar cada producto del arreglo
        for (int i = 0; i < tamano; i++) {
            productos[i] = new Producto();
        }
    }

    //Leer los datos del iesimo producto
    public void leerProducto(int posicion) {

        System.out.println("Indique los datos del producto");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite el nombre ");
        String nombre = sc.nextLine();
        productos[posicion].setNombre(nombre);
        //Leer el tipo de producto
        System.out.println("Escriba el tipo de producto: 1. Papeleria, 2. SUpermercado, 3.Drogueria");
        productos[posicion].setTipo(sc.nextInt());
        //Leer valor unitario
        System.out.println("Escriba el Valor unitario");
        productos[posicion].setValorUnitario(sc.nextDouble());
        //Leer cantidad en bodega
        System.out.println("Escriba la cantidad actual en bodega");
        productos[posicion].setCantidadBodega(sc.nextInt());
        //Leer cantidad minima
        System.out.println("Escriba la cantidad minima para pedido");
        productos[posicion].setCantidadMinima(sc.nextInt());
        //Leer total productos vendidos
        System.out.println("Escriba el total de productos vendidos");
        productos[posicion].setTotalProductosVendidos(sc.nextInt());

    }

    public void leerProductos() {
        for (int i = 0; i < this.tamano; i++) {
            leerProducto(i);
        }
    }

    //Contar los productos por tipo
    public void contarProductosTipo() {
        // inicializar un contador por cada tipo
        int cuentaPapeleria = 0;
        int cuentaSupermercado = 0;
        int cuentaDrogueria = 0;

        //Recorrer el arreglo de productos
        for (int i = 0; i < this.tamano; i++) {
            switch (productos[i].getTipo()) {
                case Producto.PAPELERIA:
                    cuentaPapeleria++;
                    break;
                case Producto.SUPERMERCADO:
                    cuentaSupermercado++;
                    break;
                case Producto.DROGUERIA:
                    cuentaDrogueria++;
                    break;
            }
        }
        System.out.println("En la tienda hay " + cuentaPapeleria + " productos de papeleria");
        System.out.println("En la tienda hay " + cuentaSupermercado + " productos de supermercdo");
        System.out.println("En la tienda hay " + cuentaDrogueria + " productos de drogueria");
    }
    
    //Mostrar los datos de un producto
    public Producto buscarProductoXNombre(String nombreProd){
        //Recorrer arreglo de productos
        for(int i=0;i<tamano;i++){
            if (nombreProd.equals(productos[i].getNombre()))
                return productos[i];
              }
        return null;
    }
}
