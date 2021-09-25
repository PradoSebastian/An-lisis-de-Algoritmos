/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.algoritmos.proyecto;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author prado
 */
public class JugadorTest {
    
    public JugadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nombreJugador method, of class Jugador.
     */
    @org.junit.Test
    public void testNombreJugador() {
        System.out.println("nombreJugador");
        Jugador instance = new Jugador();
        String expResult = "Jugador_GSS";
        String result = instance.nombreJugador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
            fail("The test case is a prototype.");
    }

    /**
     * Test of inicializar method, of class Jugador.
     */
    @org.junit.Test
    public void testInicializar() {
        System.out.println("inicializar");
        int numeroAtributos = 4;
        int numeroValores = 3;
        Jugador instance = new Jugador();
        instance.inicializar(numeroAtributos, numeroValores);
        // TODO review the generated test code and remove the default call to fail.
        if(instance.getN() != numeroAtributos || instance.getM() != numeroValores)
            fail("The test case is a prototype.");
    }

    /**
     * Test of condicionConjunto method, of class Jugador.
     */
    @org.junit.Test
    public void testCondicionConjunto() {
        System.out.println("condicionConjunto");
        ArrayList<Carta> lista = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        aux.add(1); aux.add(1); aux.add(1); aux.add(1);
        Carta aux2 = new Carta(aux);
        lista.add(aux2);
        aux = new ArrayList<>();
        aux.add(2); aux.add(1); aux.add(1); aux.add(2);
        aux2 = new Carta(aux);
        lista.add(aux2);
        aux = new ArrayList<>();
        aux.add(3); aux.add(1); aux.add(1); aux.add(3);
        aux2 = new Carta(aux);
        Carta nueva = aux2;
        int numeroAtributos = 4;
        int numeroValores = 3;
        Jugador instance = new Jugador();
        instance.inicializar(numeroAtributos, numeroValores);
        boolean expResult = true;
        boolean result = instance.condicionConjunto(lista, nueva);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result != expResult)
            fail("The test case is a prototype.");
    }

    /**
     * Test of jugar method, of class Jugador.
     */
    @org.junit.Test
    public void testJugar() {
        System.out.println("jugar");
        List<Carta> cartasEnMesa = new ArrayList<>();
        List<Carta> lista = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        
        aux = new ArrayList<>();
        aux.add(3); aux.add(2); aux.add(3); aux.add(3);
        Carta aux2 = new Carta(aux);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(1); aux.add(1); aux.add(1); aux.add(1);
        aux2 = new Carta(aux);
        lista.add(aux2);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(1); aux.add(3); aux.add(2); aux.add(1);
        aux2 = new Carta(aux);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(2); aux.add(1); aux.add(1); aux.add(2);
        aux2 = new Carta(aux);
        lista.add(aux2);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(3); aux.add(3); aux.add(1); aux.add(2);
        aux2 = new Carta(aux);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(3); aux.add(1); aux.add(1); aux.add(3);
        aux2 = new Carta(aux);
        lista.add(aux2);
        cartasEnMesa.add(aux2);
        
        aux = new ArrayList<>();
        aux.add(3); aux.add(6); aux.add(8); aux.add(9);
        aux2 = new Carta(aux);
        cartasEnMesa.add(aux2);
        
        int numeroAtributos = 4;
        int numeroValores = 3;
        Jugador instance = new Jugador();
        instance.inicializar(numeroAtributos, numeroValores);
        List<Carta> expResult = lista;
        List<Carta> result = instance.jugar(cartasEnMesa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(!result.equals(expResult))
            fail("The test case is a prototype.");
    }
    
}
