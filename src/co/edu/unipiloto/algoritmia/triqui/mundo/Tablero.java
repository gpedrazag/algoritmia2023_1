/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.triqui.mundo;

import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class Tablero {

    //Declaracion atributos
    private Casilla SI;
    private Casilla SC;
    private Casilla SD;
    private Casilla MI;
    private Casilla MC;
    private Casilla MD;
    private Casilla II;
    private Casilla IC;
    private Casilla ID;
    private String marca;

    //Constructo
    public Tablero() {
        System.out.println("Creando tablero");
        SI = new Casilla(Casilla.SUPERIOR_IZQUIERDA);
        SC = new Casilla(Casilla.SUPERIOR_CENTRO);
        SD = new Casilla(Casilla.SUPERIOR_DERECHA);
        MI = new Casilla(Casilla.MEDIO_IZQUIERDA);
        MC = new Casilla(Casilla.MEDIO_CENTRO);
        MD = new Casilla(Casilla.MEDIO_DERECHA);
        II = new Casilla(Casilla.INFERIOR_IZQUIERDA);
        IC = new Casilla(Casilla.INFERIOR_CENTRO);
        ID = new Casilla(Casilla.INFERIOR_DERECHA);
        this.marca = " ";

    }

    public Tablero(Casilla SI, Casilla SC, Casilla SD, Casilla MI, Casilla MC, Casilla MD, Casilla II, Casilla IC, Casilla ID, String marca) {
        this.SI = SI;
        this.SC = SC;
        this.SD = SD;
        this.MI = MI;
        this.MC = MC;
        this.MD = MD;
        this.II = II;
        this.IC = IC;
        this.ID = ID;
        this.marca = marca;
    }

    //Metodos get y set 
    public Casilla getSI() {
        return SI;
    }

    public void setSI(Casilla SI) {
        this.SI = SI;
    }

    public Casilla getSC() {
        return SC;
    }

    public void setSC(Casilla SC) {
        this.SC = SC;
    }

    public Casilla getSD() {
        return SD;
    }

    public void setSD(Casilla SD) {
        this.SD = SD;
    }

    public Casilla getMI() {
        return MI;
    }

    public void setMI(Casilla MI) {
        this.MI = MI;
    }

    public Casilla getMC() {
        return MC;
    }

    public void setMC(Casilla MC) {
        this.MC = MC;
    }

    public Casilla getMD() {
        return MD;
    }

    public void setMD(Casilla MD) {
        this.MD = MD;
    }

    public Casilla getII() {
        return II;
    }

    public void setII(Casilla II) {
        this.II = II;
    }

    public Casilla getIC() {
        return IC;
    }

    public void setIC(Casilla IC) {
        this.IC = IC;
    }

    public Casilla getID() {
        return ID;
    }

    public void setID(Casilla ID) {
        this.ID = ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Metodo mostrar tablero
    public void mostrarTablero() {
        System.out.println("+-+-+-+");
        System.out.println("|" + SI.getMarca() + "|" + SC.getMarca() + "|" + SD.getMarca() + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + MI.getMarca() + "|" + MC.getMarca() + "|" + MD.getMarca() + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + II.getMarca() + "|" + IC.getMarca() + "|" + ID.getMarca() + "|");
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
    }

    //Jugar triqui
    public Casilla jugar(int posicion, String simbolo) {
        System.out.println("MARCANDO pos " + posicion + " marca " + simbolo);
        Casilla cas = new Casilla();
        cas.setMarca(simbolo);
        switch (posicion) {
            case Casilla.SUPERIOR_IZQUIERDA:
                SI.setMarca(simbolo);
                cas.setPosicion(Casilla.SUPERIOR_IZQUIERDA);
                System.out.println("asignando a SI " + simbolo);
                break;
            case 2:
                SC.setMarca(simbolo);
                cas.setPosicion(Casilla.SUPERIOR_CENTRO);
                break;
            case 3:
                SD.setMarca(simbolo);
                cas.setPosicion(Casilla.SUPERIOR_DERECHA);
                break;
            case 4:
                MI.setMarca(simbolo);
                cas.setPosicion(Casilla.MEDIO_IZQUIERDA);
                break;
            case 5:
                MC.setMarca(simbolo);
                cas.setPosicion(Casilla.MEDIO_CENTRO);
                break;
            case 6:
                MD.setMarca(simbolo);
                cas.setPosicion(Casilla.MEDIO_DERECHA);
                break;
            case 7:
                II.setMarca(simbolo);
                cas.setPosicion(Casilla.INFERIOR_IZQUIERDA);
                break;
            case 8:
                IC.setMarca(simbolo);
                cas.setPosicion(Casilla.INFERIOR_CENTRO);
                break;
            case 9:
                ID.setMarca(simbolo);
                cas.setPosicion(Casilla.INFERIOR_DERECHA);
                break;
            default:
                throw new AssertionError();
        }
        System.out.println("MARCANDO " + cas.getMarca() + " pos " + cas.getPosicion());
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
        System.out.println("INICIO jugada maquina-----------");
        boolean yaMarco = false;
        Evaluacion ocupacion[] = new Evaluacion[8];
        int i = 0;
        Casilla seleccion = new Casilla();
        seleccion.setMarca(getMarcaAplicacion());
        while (!yaMarco && i < 8) {
            if (i < 3) {
                ocupacion[i] = evaluarFila(i);
            } else if (i < 6) {
                ocupacion[i] = evaluarCol(i);
            } else {
                ocupacion[i] = evaluarDiagonal(i);
            }

            if (ocupacion[i].getMarcasJugador() == 3) {
                System.out.println("Hay un ganador: es jugador en linea " + i);
            }
            if ((ocupacion[i].getOcupadas() == 3 && ocupacion[i].getMarcasJugador() == 0)) {
                System.out.println("Gana la maquina por la linea " + i);
            }
            if (ocupacion[i].getOcupadas() == 2) {
                if (ocupacion[i].getMarcasJugador() == 0) {
                    System.out.println("PUEDE ganar con " + ocupacion[i].getOcupacionLibre().getPosicion());
                    seleccion = jugar(ocupacion[i].getOcupacionLibre().getPosicion(), getMarcaAplicacion());
                    yaMarco = true;

                } else {
                    System.out.println("Bloquear  linea " + i + " en posicion " + ocupacion[i].getOcupacionLibre().getPosicion());
                    seleccion = jugar(ocupacion[i].getOcupacionLibre().getPosicion(), getMarcaAplicacion());
                    yaMarco = true;
                }
            }

            i++;

        }
        if (!yaMarco) {

            System.out.println("Buscando primera casilla libre");
            for (i = 1; i < 10 && !yaMarco; i++) {

                switch (i) {
                    case Casilla.SUPERIOR_IZQUIERDA:
                        if (SI.getMarca().equals(" ")) {
                            //SI.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            //seleccion=getSI();
                            seleccion = jugar(Casilla.SUPERIOR_IZQUIERDA, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.SUPERIOR_CENTRO:
                        if (SC.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.SUPERIOR_CENTRO, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.SUPERIOR_DERECHA:
                        if (SD.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.SUPERIOR_DERECHA, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.MEDIO_IZQUIERDA:
                        if (MI.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.MEDIO_IZQUIERDA, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.MEDIO_CENTRO:
                        if (MC.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.MEDIO_CENTRO, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.MEDIO_DERECHA:
                        if (MD.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.MEDIO_DERECHA, getMarcaAplicacion());
                            System.out.println("Maquina marca " + MD.getMarca());
                        }
                        break;
                    case Casilla.INFERIOR_IZQUIERDA:
                        if (II.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.INFERIOR_IZQUIERDA, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.INFERIOR_CENTRO:
                        if (IC.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.INFERIOR_CENTRO, getMarcaAplicacion());

                        }
                        break;
                    case Casilla.INFERIOR_DERECHA:
                        if (ID.getMarca().equals(" ")) {
                            yaMarco = true;
                            seleccion = jugar(Casilla.INFERIOR_DERECHA, getMarcaAplicacion());

                        }
                        break;
                    default:
                        throw new AssertionError();
                }
                System.out.println("Aplico primera libre " + seleccion.getPosicion() + "marcado con " + seleccion.getMarca());
            }
        }

        System.out.println(
                "----------- Finaliza jugada maquina " + seleccion.getMarca() + "--" + seleccion.getPosicion());
        return seleccion;

    }

    public Evaluacion evaluarFila(int fila) {
        //System.out.println("EVALUANDO fila "+fila);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla posicion = new Casilla();
        posicion.setMarca(getMarcaAplicacion());
        switch (fila) {
            case 0:

                if (!(SI.getMarca().equals(" "))) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_IZQUIERDA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.SUPERIOR_IZQUIERDA);
                }
                if (!SC.getMarca().equals(" ")) {
                    cont++;
                    if (SC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_CENTRO);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.SUPERIOR_CENTRO);
                }

                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_DERECHA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.SUPERIOR_DERECHA);
                }

                break;

            case 1:

                if (!MI.getMarca().equals(" ")) {
                    cont++;
                    if (MI.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_IZQUIERDA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.MEDIO_IZQUIERDA);
                }

                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_CENTRO);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.MEDIO_CENTRO);
                }

                if (!MD.getMarca().equals(" ")) {
                    cont++;
                    if (MD.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_DERECHA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.MEDIO_DERECHA);

                }

                break;
            case 2:
                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_IZQUIERDA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.INFERIOR_IZQUIERDA);
                }

                if (!IC.getMarca().equals(" ")) {
                    cont++;
                    if (IC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_CENTRO);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.INFERIOR_CENTRO);
                }

                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_DERECHA);
                    System.out.println("Evaluando fila " + fila + " candidata " + Casilla.INFERIOR_DERECHA);
                }

                break;

            default:
                throw new AssertionError();
        }

        eval.setOcupadas(cont);

        eval.setMarcasJugador(contMarcasJugador);

        eval.setOcupacionLibre(posicion);

        System.out.println(
                "finaliza evaluacion fila " + fila + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + posicion.getPosicion());
        return eval;
    }

    public Evaluacion evaluarCol(int col) {
        //System.out.println("EVALUANDO columna " + col);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla posicion = new Casilla();
        posicion.setMarca(getMarcaAplicacion());
        switch (col) {
            case 3:
                if (!SI.getMarca().equals(" ")) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_IZQUIERDA);
                }

                if (!MI.getMarca().equals(" ")) {
                    cont++;
                    if (MI.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_IZQUIERDA);
                }

                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_IZQUIERDA);
                }

                break;
            case 4:
                if (!SC.getMarca().equals(" ")) {
                    cont++;
                    if (SC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_CENTRO);
                }

                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_CENTRO);
                }

                if (!IC.getMarca().equals(" ")) {
                    cont++;
                    if (IC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_CENTRO);
                }

                break;
            case 5:
                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_DERECHA);
                }

                if (!MD.getMarca().equals(" ")) {
                    cont++;
                    if (MD.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_DERECHA);
                }

                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_DERECHA);
                }

                break;

            default:
                throw new AssertionError();
        }

        //if(cont==3)
        //   return cont;
        //return contMarcasJugador;
        eval.setOcupadas(cont);
        eval.setMarcasJugador(contMarcasJugador);
        eval.setOcupacionLibre(posicion);
        System.out.println(
                "finaliza evaluacion columna " + col + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + posicion.getPosicion());
        return eval;
    }

    public Evaluacion evaluarDiagonal(int diag) {
        //System.out.println("EVALUANDO diagonal " + diag);
        Evaluacion eval = new Evaluacion();
        int cont = 0;
        int contMarcasJugador = 0;
        Casilla posicion = new Casilla();
        posicion.setMarca(getMarcaAplicacion());
        switch (diag) {
            case 6:
                if (!SI.getMarca().equals(" ")) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_IZQUIERDA);
                }

                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_CENTRO);
                }

                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_DERECHA);
                }

                break;
            case 7:
                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.SUPERIOR_DERECHA);
                }

                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.MEDIO_CENTRO);
                }

                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        contMarcasJugador++;
                    }
                } else {
                    posicion.setPosicion(Casilla.INFERIOR_DERECHA);
                }

                break;
            default:
                throw new AssertionError();
        }
        eval.setOcupadas(cont);
        eval.setMarcasJugador(contMarcasJugador);
        eval.setOcupacionLibre(posicion);
        System.out.println(
                "finaliza evaluacion diagonal " + diag + " Ocupadas " + cont + " ocupadas jugador" + contMarcasJugador + " libre " + posicion.getPosicion());
        return eval;
    }

    public boolean jugarFila(int fila) {

        switch (fila) {
            case 0:
                if (SI.getMarca().equals(" ")) {
                    System.out.println("SI libre");
                    SI.setMarca(getMarcaAplicacion());
                }
                if (SC.getMarca().equals(" ")) {
                    System.out.println("SC libre");
                    SC.setMarca(getMarcaAplicacion());
                }
                if (SD.getMarca().equals(" ")) {
                    System.out.println("SD libre");
                    SD.setMarca(getMarcaAplicacion());
                }
                break;
            case 1:
                if (MI.getMarca().equals(" ")) {
                    System.out.println("MI libre");
                    MI.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (MD.getMarca().equals(" ")) {
                    System.out.println("MD libre");
                    MD.setMarca(getMarcaAplicacion());
                }
                break;
            case 2:
                if (II.getMarca().equals(" ")) {
                    System.out.println("II libre");
                    II.setMarca(getMarcaAplicacion());
                }
                if (IC.getMarca().equals(" ")) {
                    System.out.println("IC libre");
                    IC.setMarca(getMarcaAplicacion());
                }
                if (ID.getMarca().equals(" ")) {
                    System.out.println("ID libre");
                    ID.setMarca(getMarcaAplicacion());
                }
                break;

            default:
                throw new AssertionError();
        }
        return true;
    }

    public boolean jugarCol(int col) {

        switch (col) {
            case 0:
                if (SI.getMarca().equals(" ")) {
                    System.out.println("Col: SI libre");
                    SI.setMarca(getMarcaAplicacion());
                }
                if (MI.getMarca().equals(" ")) {
                    System.out.println("Col: MI libre");
                    MI.setMarca(getMarcaAplicacion());
                }
                if (II.getMarca().equals(" ")) {
                    System.out.println("Col: II libre");
                    II.setMarca(getMarcaAplicacion());
                }
                break;
            case 1:
                if (SC.getMarca().equals(" ")) {
                    System.out.println("Col: SC libre");
                    SC.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("Col: MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (IC.getMarca().equals(" ")) {
                    System.out.println("Col IC libre");
                    IC.setMarca(getMarcaAplicacion());
                }
                break;
            case 2:
                if (SD.getMarca().equals(" ")) {
                    System.out.println("Col: SD libre");
                    II.setMarca(getMarcaAplicacion());
                }
                if (MD.getMarca().equals(" ")) {
                    System.out.println("Col: MD libre");
                    MD.setMarca(getMarcaAplicacion());
                }
                if (ID.getMarca().equals(" ")) {
                    System.out.println("Col: ID libre");
                    ID.setMarca(getMarcaAplicacion());
                }
                break;

            default:
                throw new AssertionError();
        }
        return true;
    }

}
