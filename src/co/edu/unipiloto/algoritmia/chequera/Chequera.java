/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.algoritmia.chequera;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Chequera {

    //Atributos
    private static Scanner scan = new Scanner(System.in);

    public static void mostrar_menu() {

        System.out.println("APLICACION PARA MANEJO DE CHEQUERA");
        System.out.println("1. Consignar en cuenta corriente");
        System.out.println("2. Cobrar cheque en cuenta corriente");
        System.out.println("3. Consultar saldo de la cuenta corriente");
        System.out.println("0. Terminar");
        System.out.println("Escriba el numero de la opcion deseada ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CuentaCorriente miCuenta = new CuentaCorriente();
        int opcion = 0;
        double valor = 0.0;
        do {
            mostrar_menu();
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Valor a consignar");
                    valor = scan.nextInt();
                    miCuenta.consignar(valor);
                    break;
                case 2:
                    System.out.println("Valor del cheque");
                    valor = scan.nextInt();
                    miCuenta.retirar(valor);
                    break;
                case 3:
                    System.out.println("Saldo en la cuenta "+miCuenta.getSaldo());
                    break;
                default:
                    System.out.println("Accion alternativo");
            }

        } while (opcion != 0);

    }

}
