/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.algoritmia.tienda.condicionales;

/**
 *
 * @author SG701-21
 */
public class Tienda {
    //atributos
    private String nombre;
    //Cuatro productos
    private Producto p1;
    private Producto p2;
    private Producto p3;
    private Producto p4;

    public Tienda() {
        p1=new Producto();
        p2=new Producto();
        p3=new Producto();
        p4=new Producto();
        
    }

    public Tienda(String nombre, Producto p1, Producto p2, Producto p3) {
        this.nombre = nombre;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    Tienda(String nombreTienda) {
        this.nombre = nombreTienda;
        this.p1=new Producto();
        this.p2=new Producto();
        this.p3=new Producto();
        this.p4=new Producto();
    }
    
    //Get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getP1() {
        return p1;
    }

    public void setP1(Producto p1) {
        this.p1 = p1;
    }

    public Producto getP2() {
        return p2;
    }

    public void setP2(Producto p2) {
        this.p2 = p2;
    }

    public Producto getP3() {
        return p3;
    }

    public void setP3(Producto p3) {
        this.p3 = p3;
    }

    public Producto getP4() {
        return p4;
    }

    public void setP4(Producto p4) {
        this.p4 = p4;
    }
    
    //to string

    @Override
    public String toString() {
        return "Tienda{" + "nombre=" + nombre + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + '}';
    }
    
    // Metodos de negocio
    // Calcular dinero en caja
    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaPapeleria(Producto prod){
        double dinero=(prod.getTotalProductosVendidos()*prod.getValorUnitario())
                      *(1+Producto.IVA_PAPEL);
        System.out.println("Para producto "+prod.getNombre()+" de Papeleria Valor Caja "+dinero);
        return dinero;
    }
    
    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaDrogueria(Producto prod){
        double dinero=(prod.getTotalProductosVendidos()*prod.getValorUnitario())
                      *(1+Producto.IVA_FARMACIA);
        System.out.println("Para producto "+prod.getNombre()+" de Drogueria Valor Caja "+dinero);
        return dinero;
    }
    
    //Calcular dinero en caja para papeleria
    public double calcularDineroEnCajaSupermercado(Producto prod){
        double dinero=(prod.getTotalProductosVendidos()*prod.getValorUnitario())
                      *(1+Producto.IVA_MERCADO);
        System.out.println("Para producto "+prod.getNombre()+" de supermercado Valor Caja "+dinero);
        return dinero;
    }
    
    //Calcular dinero en caja para un producto
    public double calcularDineroEnCajaProd(Producto prod){
        if (prod.getTipo()==Producto.PAPELERIA)
            return calcularDineroEnCajaPapeleria (prod);
        else
            if (prod.getTipo()==Producto.SUPERMERCADO)
                return calcularDineroEnCajaSupermercado(prod);
             else
                return calcularDineroEnCajaDrogueria(prod);
    }
    
    //Calcular el dinero en caja para todos los productos
    public double calcularDineroEnCaja(){
        return calcularDineroEnCajaProd(p1)+
                calcularDineroEnCajaProd(p2)+
                calcularDineroEnCajaProd(p3)+
                calcularDineroEnCajaProd(p4);
                
    }
    
            //Obtener el valor del IVA de un producto
    public double getIvaProducto (Producto prod){
        double ivaProd=0.0;
        switch (prod.getTipo()) {
            case Producto.PAPELERIA:
                ivaProd=Producto.IVA_PAPEL;
                break;
            case Producto.SUPERMERCADO:
                ivaProd=Producto.IVA_MERCADO;
                break;
            case Producto.DROGUERIA:
                ivaProd=Producto.IVA_FARMACIA;
                break;
        }
        return ivaProd;
        
    }
    
    //Determinar la cantidad de numeros divisores
    public int contarDivisores (int valorInicial, int valorFinal, int divisor){
        int cuentaDivisibles=0;
        int cuenta=valorInicial;
        while (cuenta<valorFinal){
            if (cuenta%divisor==0){
                cuentaDivisibles++;
                System.out.println("El numero "+cuenta+" es divisible por "+divisor);  
            }
            cuenta++;
        }
        System.out.println("La cantidad de numeros divisibles por "+divisor+" entre "+ valorInicial+" y "+ valorFinal + "es "+cuentaDivisibles);
        return cuentaDivisibles;
    }
    
    
    
}
