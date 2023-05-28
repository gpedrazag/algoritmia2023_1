/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda.condicionales;

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

        Tienda miTienda;
        miTienda = new Tienda("Tienda todo a mil");

        //Libreta de apuntes, productos de papelería, a $5,500 pesos la unidad, en bodega 23, mínimo 15, vendidos 87
        Producto libreta = new Producto("Libreta de apuntes", Producto.PAPELERIA, 23, 15, 5500, 87);

        //Leche en bolsa de 1 litro, producto de supermercado, a $2,100 pesos, en bodega 150, mínimo 30, vendidos 30.
        Producto leche = new Producto("Leche en bolsa de 1 litro ", Producto.SUPERMERCADO, 150, 30, 2100, 30);
        //JabOn en polvo, producto de supermercado, a $4,200 el kilo, en bodega 15, mínimo 50, vendidos 80.
        Producto jabon = new Producto("Jabon en polvo", Producto.SUPERMERCADO, 15, 50, 4200, 80);
        //Aspirina, producto de droguería, a $2,400 la caja de 12 unidades, en bodega 60, mínimo 100, ven   didos 200.
        Producto aspirina = new Producto("Aspiran caja de 12 unidades", Producto.DROGUERIA, 60, 100, 2400, 80);
        //Asignar los productos a la tienda
        miTienda.setP1(libreta);
        miTienda.setP2(leche);
        miTienda.setP3(jabon);
        miTienda.setP4(aspirina);

        System.out.println("TIENDA " + miTienda.toString());

        //Expresiones aritmeticas
        //Leche cantidadBodega - cantidadMinima
        int exp1 = leche.getCantidadBodega() - leche.getCantidadMinima();
        System.out.println("Leche: cantidadBodega - cantidadMinima " + exp1);
        //valorUnitario / (cantidadBodega * 12)

        double exp2 = aspirina.getValorUnitario() / (aspirina.getCantidadBodega() * 12);

        System.out.println("valorUnitario / (cantidadBodega * 12) " + exp2);

        //( p1.darValorUnitario ( ) + p2.darValorUnitario ( ) + p3.darValorUnitario ( ) + p4.darValorUnitario ( ) ) / 4
        double exp3 = (miTienda.getP1().getValorUnitario() + miTienda.getP2().getValorUnitario() + miTienda.getP3().getValorUnitario() + miTienda.getP4().getValorUnitario()) / 4;
        System.out.println("( p1.darValorUnitario ( ) + p2.darValorUnitario ( ) + p3.darValorUnitario ( ) + p4.darValorUnitario ( ) ) / 4 es " + exp3);

        //Evaluar libreta: Tipo == PAPELERIA
        boolean expR1 = libreta.getTipo() == Producto.PAPELERIA;
        System.out.println("libreta: Tipo == PAPELERIA " + expR1);

        // Evaluar libreta: Tipo != DROGUERIA
        System.out.println("libreta: Tipo != DROGUERIA " + (libreta.getTipo() != Producto.DROGUERIA));

        //Evaluar Leche: CantidadMinima >= cantidadBodega
        System.out.println("leche: CantidadMinima >= cantidadBodega " + (leche.getCantidadMinima() >= leche.getCantidadBodega()));

        //Dinero en caja para producto papeleria
        System.out.println("Dinero en caja para todos los productos " + (miTienda.calcularDineroEnCaja()));

        //dineroEnCaja <= p4.darProductosVendidos ( ) * ( ( 1 + p4.darIVA ( ) )* p4.darValorUnitario ( ) )
        boolean expR4 = miTienda.calcularDineroEnCaja() <= miTienda.calcularDineroEnCajaProd(miTienda.getP4());
        System.out.println("dineroEnCaja <= p4.darProductosVendidos ( ) * ( ( 1 + p4.darIVA ( ) )* p4.darValorUnitario ( ) ) " + expR4);

        //Determinar si hay suficiente cantidad de productos al realizar una venta
        System.out.println("¿Hay suficiente cantidad de productos para vender 255 bolsas de leche? "
                + leche.haySuficienteCantidad(255));

        //Mostrar los tipos de producto que se han agregado a la tienda
        System.out.println(miTienda.getP1().toString());

        //Retornar iva de un prodcuto
        System.out.println("IVA de " + leche.getNombre() + " es " + miTienda.getIvaProducto(leche));
        System.out.println("IVA de " + libreta.getNombre() + " es " + miTienda.getIvaProducto(libreta));
        System.out.println("IVA de " + aspirina.getNombre() + " es " + miTienda.getIvaProducto(aspirina));

        //Sumar los numeros de 0 a 100 con un While
        int contador = 0;
        long acumulador = 0;
        while (contador <= 100) {
            //Incrementar la suma del acumulador en contador
            acumulador += contador;
            contador++;
        }
        System.out.println("Usando el while los numeros de 0 a 100 suman " + acumulador);

        //Sumar los numeros de 0 a 100 con un For
        acumulador = 0;
        for (int contad = 0; contad <= 100; contad++) {
            //Incrementar la suma del acumulador en contador
            acumulador += contad;
        }
        System.out.println("Usando el for los numeros de 0 a 100 suman " + acumulador);

        //Contar y Mostrar los numero divisibles entre 9 para valores entre 0 y 500
        int cuentaDivisibles = 0;
        for (int cuenta = 0; cuenta <= 500; cuenta++) {
            if (cuenta % 9 == 0) {
                cuentaDivisibles++;
                System.out.println("el numero " + cuenta + " es divisible por 9");
            }
        }
        System.out.println("La cantidad de numeros divisibles por 9 entre 0 y 500 es "+cuentaDivisibles);

        //Contar y Mostrar los numero divisibles entre 9 para valores entre 0 y 500
        //Usando while
        int cantidad= miTienda.contarDivisores(100, 1500, 13);
        
    }

}
