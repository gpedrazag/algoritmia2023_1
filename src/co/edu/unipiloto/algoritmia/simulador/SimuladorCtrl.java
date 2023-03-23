/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.simulador;

/**
 *
 * @author USUARIO
 */
public class SimuladorCtrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Banco miBanco=new Banco();
        miBanco.setNombre("Mi propio Banco");
        miBanco.setCorreo("banco@gmail.com");
        miBanco.setNit("900000001");
        System.out.println(" DATOS DEL BANCO "+miBanco.toString());
        
        //Crear cuentas ahorro, corrienet y cdt
        Ahorro ahorro01=new Ahorro(1500000,0);
        Corriente corriente01=new Corriente(500000);
        CDT cdt01=new CDT();
        // Crear cuenta
        Cuenta miCuenta=new Cuenta("Gonzalo Jimenez", "gonzaloj@gmail.com", "79000000", ahorro01, corriente01, cdt01, 0);
        //Asociar la cuental banco
        miBanco.setPrimera(miCuenta);
        //Mostrar banco
        System.out.println(" DATOS DEL BANCO "+miBanco.toString());
        
        //Relacionar cuentas de ahorro, corriente y CDT a la miCuenta
        miCuenta.setAhorro(ahorro01);
        miCuenta.setCorriente(corriente01);
        miCuenta.setCdt(cdt01);

        //Consignar en ahorros
        System.out.println("Cuenta de ahorros"+ahorro01.toString());
        ahorro01.consignar(500000);        
        System.out.println("Cuenta ahorros consigna 500000 "+ahorro01.toString());
        
        //Calcular intereses
        System.out.println("Los intereses son "+ahorro01.calcularIntereses());
        
        //Retirar de ahorros
        System.out.println("Retiro de 700000 es " + ahorro01.retirar(700000));
        System.out.println("Cuenta de ahorros"+ahorro01.toString());
        
        //Apertura de un CDT
        System.out.println("Activar el CDT");
        
        cdt01.abrirCDT(new Fecha(21,3,2023), 3400000,2);
        System.out.println("CDT "+ cdt01.toString());
    }
    
}
