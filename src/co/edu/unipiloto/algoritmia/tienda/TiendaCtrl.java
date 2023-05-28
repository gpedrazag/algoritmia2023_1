/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda;

/**
 *
 * @author SG701-21
 */
public class TiendaCtrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Primer producto libreta de apuntes
        Producto libreta=new Producto("Libreta de apuntes", Producto.PAPELERIA, 23, 15, 5500, 87);
        System.out.println(" OBJETO"+ libreta.toString());
        
        //Seguno producto
        Producto leche=new Producto("Leche en bolsa de 1 litro", Producto.SUPERMERCADO, 150, 30, 2100, 30);
        System.out.println(" OBJETO"+ leche.toString());
        
        //Tercer producto Jabon
        Producto jabon=new Producto("Jabon en polvo", Producto.SUPERMERCADO, 15, 50, 4200, 80);
        System.out.println(" OBJETO"+ jabon.toString());
        
        //cuarto producto
        Producto aspirina=new Producto("Aspirina caja de 12 unidades", Producto.DROGUERIA, 60, 100, 2400, 200);
        System.out.println(" OBJETO"+ aspirina.toString());
        
        //Crear un objeto tienda
       
        Tienda miTienda=new Tienda(libreta,leche,jabon,aspirina);
        System.out.println("MI TIENDA" +miTienda.toString());
        
        
        //Expresion cantidad en bodega - cantidad minima de leche
        int diferenciaBodegaMinimo= leche.getCantidadBodega()-leche.getCantidadMinima();
        System.out.println(" Expresion cantidad en bodega - cantidad minima de leche"+ diferenciaBodegaMinimo);
    }
    
}
