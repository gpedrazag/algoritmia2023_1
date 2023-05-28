/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda.arreglos;

import co.edu.unipiloto.algoritmia.tienda.*;
import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class TiendaCtrl {

    private static Scanner scan = new Scanner(System.in);

    ;

    /**
     * @param args the command line arguments
     */
    //Mostrar menu de opciones
    public static void mostrar_menu() {
        limpiar_consola();
        System.out.println("APLICACION PARA MANEJO DE TIENDA");
        System.out.println("1. Leer datos de tienda");
        System.out.println("2. Leer datos de los productos");
        System.out.println("3. Mostrar productos de la tienda");
        System.out.println("4. Calcular valor del inventario");
        System.out.println("5. Precio promedio de productos");
        System.out.println("6. Vender un producto");
        System.out.println("7. Cantidad de productos por tipo");
        System.out.println("8. Buscar producto dado el nombre");
        System.out.println("0. Terminar");
        System.out.println("Escriba el numero de la opcion deseada ");
    }

    private static void limpiar_consola() {
        System.out.println("\033[H\033[2J");
        System.out.println("\f");
        System.out.flush();
    }

    public static void leerDatosInicialesTienda(Tienda tienda) {

        System.out.println("Escriba el nombre de la tienda ");
        String nombre = scan.next();

        tienda.setNombre(nombre);
        //Leer cantidad de productos
        System.out.print(" Maxima cantidad de productos ");
        int cantidad = scan.nextInt();
        tienda.setTamano(cantidad);
        tienda.inicializarProductos(cantidad);

    }

    public static void main(String[] args) {
        // TODO code application logic here
        Tienda miTienda;
        miTienda = new Tienda();
        int opcion = 0;
        //scan = new Scanner(System.in);
        do {
            mostrar_menu();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Leer datos de tienda");
                    leerDatosInicialesTienda(miTienda);
                    System.out.println(miTienda.toString());
                    break;
                case 2:
                    System.out.println("Leer datos de los productos");
                    miTienda.leerProductos();
                    break;
                case 3:
                    System.out.println("Mostrar productos de la tienda");
                    System.out.println(miTienda.toString());
                    break;
                case 4:
                    System.out.println("Calcular valor del inventario");
                    break;
                case 5:
                    System.out.println("Precio promedio de productos");
                    break;
                case 6:
                    System.out.println("Vender un producto");
                    break;
                case 7:
                    System.out.println("Cantidad de productos por tipo");
                    miTienda.contarProductosTipo();
                    break;
                case 8:
                    System.out.println("Buscar un producto dado el nombre");
                    buscarProducto(miTienda);
                    break;
                default:
                    System.out.println("Accion alternativo");
            }

        } while (opcion != 0);

        /*      
      
      miTienda=new Tienda("Tienda todo a mil");
      
      //Libreta de apuntes, productos de papelería, a $5,500 pesos la unidad, en bodega 23, mínimo 15, vendidos 87
      Producto libreta=new Producto ("Libreta de apuntes", Producto.PAPELERIA, 23, 15, 5500, 87);

      //Leche en bolsa de 1 litro, producto de supermercado, a $2,100 pesos, en bodega 150, mínimo 30, vendidos 30.
      Producto leche=new Producto("Leche en bolsa de 1 litro ", Producto.SUPERMERCADO,150,30,2100,30);
    //JabOn en polvo, producto de supermercado, a $4,200 el kilo, en bodega 15, mínimo 50, vendidos 80.
      Producto jabon=new Producto ("Jabon en polvo",Producto.SUPERMERCADO,15,50,4200,80);
    //Aspirina, producto de droguería, a $2,400 la caja de 12 unidades, en bodega 60, mínimo 100, ven   didos 200.
      Producto aspirina= new Producto( "Aspiran caja de 12 unidades", Producto.DROGUERIA, 60, 100, 2400, 80);
      //Asignar los productos a la tienda
      miTienda.setP1(libreta);
      miTienda.setP2(leche);
      miTienda.setP3(jabon);
      miTienda.setP4(aspirina);
      
      System.out.println("TIENDA "+miTienda.toString());
      
      //Expresiones aritmeticas
      
      //Leche cantidadBodega - cantidadMinima
      
      int exp1=leche.getCantidadBodega()-leche.getCantidadMinima();
        System.out.println("Leche: cantidadBodega - cantidadMinima "+exp1);
    //valorUnitario / (cantidadBodega * 12)

       double exp2= aspirina.getValorUnitario()/(aspirina.getCantidadBodega()*12);
 
       System.out.println("valorUnitario / (cantidadBodega * 12) "+exp2);
    
       
       //( p1.darValorUnitario ( ) + p2.darValorUnitario ( ) + p3.darValorUnitario ( ) + p4.darValorUnitario ( ) ) / 4
        double exp3=( miTienda.getP1().getValorUnitario ( ) + miTienda.getP2().getValorUnitario ( ) + miTienda.getP3().getValorUnitario ( ) + miTienda.getP4().getValorUnitario ( ) ) / 4;
        System.out.println("( p1.darValorUnitario ( ) + p2.darValorUnitario ( ) + p3.darValorUnitario ( ) + p4.darValorUnitario ( ) ) / 4 es "+exp3);
    
        //Evaluar libreta: Tipo == PAPELERIA

        boolean expR1= libreta.getTipo()== Producto.PAPELERIA;
        System.out.println("libreta: Tipo == PAPELERIA "+expR1);

        // Evaluar libreta: Tipo != DROGUERIA
        System.out.println("libreta: Tipo != DROGUERIA "+(libreta.getTipo() != Producto.DROGUERIA));
        
        //Evaluar Leche: CantidadMinima >= cantidadBodega
        System.out.println("leche: CantidadMinima >= cantidadBodega "+(leche.getCantidadMinima() >= leche.getCantidadBodega()));
   
        //Dinero en caja para producto papeleria
        System.out.println("Dinero en caja para todos los productos "+(miTienda.calcularDineroEnCaja()));
        
        //dineroEnCaja <= p4.darProductosVendidos ( ) * ( ( 1 + p4.darIVA ( ) )* p4.darValorUnitario ( ) )
        
        boolean expR4=miTienda.calcularDineroEnCaja()<=miTienda.calcularDineroEnCajaProd (miTienda.getP4());
        System.out.println("dineroEnCaja <= p4.darProductosVendidos ( ) * ( ( 1 + p4.darIVA ( ) )* p4.darValorUnitario ( ) ) "+expR4);
        
        //Incrementar el valor unitario
        double incremento=miTienda.getP1().subirValorUnitario();
        System.out.println("Para el producto "+miTienda.getP1().getNombre()+" el incremento es "+incremento);
        
        incremento=miTienda.getP2().subirValorUnitario();
        System.out.println("Para el producto "+miTienda.getP2().getNombre()+" el incremento es "+incremento);
                
        incremento=miTienda.getP3().subirValorUnitario();
        System.out.println("Para el producto "+miTienda.getP3().getNombre()+" el incremento es "+incremento);        
                
        //Retornar iva de un prodcuto
       
        
        System.out.println("IVA de "+leche.getNombre()+" es "+miTienda.getIvaProducto(leche));
        System.out.println("IVA de "+libreta.getNombre()+" es "+miTienda.getIvaProducto(libreta));
        System.out.println("IVA de "+aspirina.getNombre()+" es "+miTienda.getIvaProducto(aspirina));
        
        //Sumar los numeros de 0 a 100
        
         int indice=0;
        long acumulador=0;
        while (indice <= 100){
            //SUmar los numeros de 0 a 100
            acumulador+=indice;
            indice++;
        }
        System.out.println("Los numeros de 0 a 100 suman "+acumulador);
        
        mostrar_menu();
    }


         */
    }

    private static void buscarProducto(Tienda tienda) {
        System.out.println("Escriba el nombre del producto");
        String nombreProd = scan.next();
        Producto prod = tienda.buscarProductoXNombre(nombreProd);
        if (prod != null) {
            System.out.println("Datos del producto " + prod.toString());
        } else {
            System.out.println("El producto no existe");
        }
    }
}
