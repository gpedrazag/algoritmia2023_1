/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unipiloto.algoritmia.chequera;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USUARIO
 */
public class CuentaCorrienteTest {
    
    public CuentaCorrienteTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNumero method, of class CuentaCorriente.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        CuentaCorriente instance = new CuentaCorriente();
        int expResult = 0;
        int result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class CuentaCorriente.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        int numero = 0;
        CuentaCorriente instance = new CuentaCorriente();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSaldo method, of class CuentaCorriente.
     */
    @Test
    public void testGetSaldo() {
        System.out.println("getSaldo");
        CuentaCorriente instance = new CuentaCorriente();
        double expResult = 0.0;
        double result = instance.getSaldo();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSaldo method, of class CuentaCorriente.
     */
    @Test
    public void testSetSaldo() {
        System.out.println("setSaldo");
        double saldo = 0.0;
        CuentaCorriente instance = new CuentaCorriente();
        instance.setSaldo(saldo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consignar method, of class CuentaCorriente.
     */
    @Test
    public void testConsignar() {
        System.out.println("consignar");
        Double valor = null;
        CuentaCorriente instance = new CuentaCorriente();
        instance.consignar(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retirar method, of class CuentaCorriente.
     */
    @Test
    public void testRetirar() {
        System.out.println("retirar");
        Double valor = null;
        CuentaCorriente instance = new CuentaCorriente();
        instance.retirar(valor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
