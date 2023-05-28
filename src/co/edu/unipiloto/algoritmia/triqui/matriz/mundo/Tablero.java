/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.matriz.mundo;

import co.edu.unipiloto.algoritmia.triqui.matriz.mundo.*;
import co.edu.unipiloto.algoritmia.triqui.matriz.interfaz.*;
import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class Tablero {

    //Declaracion atributos
    private Casilla[][] casillas ;

    private String marca;

    //Constructo
    public Tablero() {
        System.out.println("Creando tablero...");
        //Instanciar el espacio para la matriz que representa el tablero
        casillas = new Casilla[InterfazTriqui.TAMANO][InterfazTriqui.TAMANO];

        for (int i = 0; i < InterfazTriqui.TAMANO; i++) {
            for (int j = 0; j < InterfazTriqui.TAMANO; j++) {
                casillas[i][j]=new Casilla();
                casillas[i][j].setMarca(" ");
            }
        }
        this.marca = "-";

    }
    
    

    public Tablero(Casilla SI, Casilla SC, Casilla SD, Casilla MI, Casilla MC, Casilla MD, Casilla II, Casilla IC, Casilla ID, String marca) {
        
        this.marca = marca;
    }

    //Metodos get y set 
  public Casilla getCasilla(int x, int y) {
        return casillas[x][y];
    }

    public void setCasilla(Casilla casilla) {
        this.casillas[casilla.getPosx()][casilla.getPosy()] = casilla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Metodo mostrar tablero
    public void mostrarTablero() {

        for (int i = 0; i < InterfazTriqui.TAMANO; i++) {
            System.out.println("+-+-+-+");
            for (int j = 0; j < InterfazTriqui.TAMANO; j++) {
                System.out.print("|" + casillas[i][j].getMarca());
            }
            System.out.println("|");
        }
        System.out.println("+-+-+-+");
    }

    public void seleccionarMarca() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione una marca (X - O)");
        String valor = scan.next();
        if (valor.equals("X") || valor.equals("O")) {
            this.marca = valor;
        }
        this.marca = "X";
        System.out.println(" Marca de JUGADOR es "+marca);
    }

    //Jugar triqui
    public Casilla jugar(int posx, int posy, String simbolo) {
        System.out.println("MARCANDO pos " + posx + " marca " + simbolo);
        Casilla cas = new Casilla();
        cas.setPosx(posx);
        cas.setPosy(posy);
        cas.setMarca(simbolo);
        casillas[posx][posy].setMarca(simbolo);

        return cas;
    }

    //Retornar marca del jugador aplicacion
    public String getMarcaAplicacion() {
        if (this.marca.equals("X")) {
            return "O";
        }
        return "X";
    }

    public Casilla jugarMaquina() {
        System.out.println("INICIO jugada maquina----------- Marca "+getMarcaAplicacion());
        boolean yaMarco = false;
        Evaluacion ocupacion[] = new Evaluacion[8];
        int i = 0;
        int j = 0;
        Casilla seleccion = new Casilla();
        seleccion.setMarca(getMarcaAplicacion());
        while (!yaMarco && i < 8) {
            if (i < 3) {
                ocupacion[i] = evaluarFila(i);
            } else if (i < 6) {
                ocupacion[i] = evaluarCol(i-3);
            } else {
                ocupacion[i] = evaluarDiagonal(i-6);
            }

            if (ocupacion[i].getMarcasJugador() == 3) {
                System.out.println("Hay un ganador: es jugador en linea " + i);
            }
            if ((ocupacion[i].getOcupadas() == 3 && ocupacion[i].getMarcasJugador() == 0)) {
                System.out.println("Gana la maquina por la linea " + i);
            }
            if (ocupacion[i].getOcupadas() == 2) {
                if (ocupacion[i].getMarcasJugador() == 0) {
                    System.out.println("PUEDE ganar con " + ocupacion[i].getOcupacionLibre().getPosx());
                    seleccion = jugar(ocupacion[i].getOcupacionLibre().getPosx(),
                            ocupacion[i].getOcupacionLibre().getPosy(),
                            getMarcaAplicacion());
                    yaMarco = true;

                } else {
                    System.out.println("Bloquear  linea " + i + " en posicion " + ocupacion[i].getOcupacionLibre().getPosx());
                    seleccion = jugar(ocupacion[i].getOcupacionLibre().getPosx(),
                            ocupacion[i].getOcupacionLibre().getPosy(),
                            getMarcaAplicacion());
                    yaMarco = true;
                }
            }

            i++;

        }
        if (!yaMarco) {

            System.out.println("Buscando primera casilla libre");
            for (i = 0; i < InterfazTriqui.TAMANO && !yaMarco; i++) {
                for (j = 0; j < InterfazTriqui.TAMANO && !yaMarco; j++) {
                    if (casillas[i][j].getMarca().equals(" ")) {
                        seleccion = jugar(i, j, getMarcaAplicacion());
                        yaMarco = true;
                    }
                }
            }
            System.out.println("Aplico primera libre " + seleccion.getPosx() + "marcado con " + seleccion.getMarca());
        }

        System.out.println(
                "----------- Finaliza jugada maquina " + seleccion.getMarca() + "--" + seleccion.getPosx());
        return seleccion;

    }

    public Evaluacion evaluarFila(int fila) {
        //System.out.println("EVALUANDO fila "+fila);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla cas = new Casilla();
        cas.setMarca(getMarcaAplicacion());

        for (int j = 0; j < InterfazTriqui.TAMANO; j++) {
            if (!casillas[fila][j].getMarca().equals(" ")) {
                cont++;
                if (casillas[fila][j].getMarca().equals(this.marca)) {
                    contMarcasJugador++;
                }
            } else {
                cas.setPosx(fila);
                cas.setPosy(j);
            }
        }
        eval.setOcupadas(cont);

        eval.setMarcasJugador(contMarcasJugador);

        eval.setOcupacionLibre(cas);

        System.out.println("finaliza evaluacion fila " + fila + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + cas.getPosy());
        return eval;
    }

    public Evaluacion evaluarCol(int col) {
        System.out.println("EVALUANDO col"+col);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla cas = new Casilla();
        cas.setMarca(getMarcaAplicacion());
        cas.setPosy(col);

        for (int i = 0; i < InterfazTriqui.TAMANO; i++) {
            if (!casillas[i][col].getMarca().equals(" ")) {
                cont++;
                if (casillas[i][col].getMarca().equals(this.marca)) {
                    contMarcasJugador++;
                }
            } else {
                cas.setPosx(i);
                cas.setPosy(col);
            }
        }
        eval.setOcupadas(cont);
        eval.setMarcasJugador(contMarcasJugador);
        eval.setOcupacionLibre(cas);
        System.out.println("finaliza evaluacion columna " + col + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + cas.getPosx());
        return eval;
    }

    public Evaluacion evaluarDiagonal(int diag) {
        //System.out.println("EVALUANDO fila "+fila);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla cas = new Casilla();
        cas.setMarca(getMarcaAplicacion());

        if (diag == 0) {

            for (int k = 0; k < InterfazTriqui.TAMANO; k++) {
                if (!casillas[k][k].getMarca().equals(" ")) {
                    cont++;
                    if (casillas[k][k].getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    cas.setPosx(k);
                    cas.setPosy(k);
                }
            }
        } else {
            for (int k = 0; k < InterfazTriqui.TAMANO; k++) {
                if (!casillas[k][2 - k].getMarca().equals(" ")) {
                    cont++;
                    if (casillas[k][2 - k].getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    cas.setPosx(k);
                    cas.setPosy(2 - k);
                }
            }

        }
        eval.setOcupadas(cont);

        eval.setMarcasJugador(contMarcasJugador);

        eval.setOcupacionLibre(cas);

        System.out.println("finaliza evaluacion diag " + diag + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + cas.getPosy());
        return eval;
    }
}
