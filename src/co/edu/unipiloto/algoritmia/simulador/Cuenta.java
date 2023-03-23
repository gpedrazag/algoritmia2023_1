/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.simulador;

/**
 *
 * @author USUARIO
 */
class Cuenta {
    
    //Atributos
    private String cliente;
    private String correo;
    private String cedula;
    private Ahorro ahorro;
    private Corriente corriente;
    private CDT cdt;
    private int mesesSimulacion;
    
    //Constructores

    public Cuenta() {
        this.ahorro=new Ahorro();
        this.corriente=new Corriente();
        this.cdt=new CDT();
    }

    public Cuenta(String cliente, String correo, String cedula, Ahorro ahorro, Corriente corriente, CDT cdt, int mesesSimulacion) {
        this.cliente = cliente;
        this.correo = correo;
        this.cedula = cedula;
        this.ahorro = ahorro;
        this.corriente = corriente;
        this.cdt = cdt;
        this.mesesSimulacion = mesesSimulacion;
    }

   
    
    //Set y get

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Ahorro getAhorro() {
        return ahorro;
    }

    public void setAhorro(Ahorro ahorro) {
        this.ahorro = ahorro;
    }

    public Corriente getCorriente() {
        return corriente;
    }

    public void setCorriente(Corriente corriente) {
        this.corriente = corriente;
    }

    public CDT getCdt() {
        return cdt;
    }

    public void setCdt(CDT cdt) {
        this.cdt = cdt;
    }

    public int getMesesSimulacion() {
        return mesesSimulacion;
    }

    public void setMesesSimulacion(int mesesSimulacion) {
        this.mesesSimulacion = mesesSimulacion;
    }
    
    
    // MOstrar contenido

  
    @Override
    public String toString() {
        return "Cuenta{" + "cliente=" + cliente + ", correo=" + correo + ", cedula=" + cedula + ", \n ahorro=" + ahorro + ", \n corriente=" + corriente + ", \n cdt=" + cdt + ", mesesSimulacion=" + mesesSimulacion + '}';
    }
    
    
    
    
}
