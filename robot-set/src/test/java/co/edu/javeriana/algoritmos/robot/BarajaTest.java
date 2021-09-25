package co.edu.javeriana.algoritmos.robot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import co.edu.javeriana.algoritmos.proyecto.Carta;

public class BarajaTest {

    @Test
    public void testDeberiaGenerarTodasCartas3x2() {
        probarCon( 2, 3 );
    }

    @Test
    public void testDeberiaGenerarTodasCartas7x8() {
        probarCon( 7, 8 );
    }

    @Test
    public void testDeberiaGenerarTodasCartas9x5() {
        probarCon( 9, 5 );
    }
    
    @Test
    public void testDeberiaGenerarTodasCartas9x6() {
        probarCon( 9, 6 );
    }

    void probarCon( int atributos, int valores ) {
        Baraja baraja = new Baraja( atributos, valores );
        int numCartas = new Double( Math.pow( valores, atributos ) ).intValue();
        Iterator<Carta> it = baraja.iterator();
        for ( int i = 1; i <= numCartas ;i++ ) {
            it.next();
            if ( i % 200000 == 0 )
                System.out.println( i );
        }
        assertFalse( it.hasNext() );
    }


    @Test
    public void testDeberiaCantarConjuntoCorrecto4x3() {
        Baraja baraja = new Baraja( 4, 3 );
        Carta carta1 = new Carta( Arrays.asList( 0, 1, 2, 0 ) );
        Carta carta2 = new Carta( Arrays.asList( 1, 2, 0, 1 ) );
        Carta carta3 = new Carta( Arrays.asList( 2, 0, 1, 2 ) );
        Set<Carta> cartas = new HashSet<>( Arrays.asList( carta1, carta2, carta3 ) );
        assertTrue( baraja.cartasSonConjunto( cartas ) );
    }
    
    @Test
    public void testDeberiaCantarConjuntoCorrecto3x4() {
        Baraja baraja = new Baraja( 3, 4 );
        Carta carta1 = new Carta( Arrays.asList( 0, 1, 2 ) );
        Carta carta2 = new Carta( Arrays.asList( 1, 2, 0 ) );
        Carta carta3 = new Carta( Arrays.asList( 2, 0, 1 ) );
        Carta carta4 = new Carta( Arrays.asList( 3, 3, 3 ) );
        Set<Carta> cartas = new HashSet<>( Arrays.asList( carta1, carta2, carta3, carta4 ) );
        assertTrue( baraja.cartasSonConjunto( cartas ) );
    }

    @Test
    public void testDeberiaCantarConjuntoNoCorrecto3x4() {
        Baraja baraja = new Baraja( 3, 4 );
        Carta carta1 = new Carta( Arrays.asList( 0, 1, 2 ) );
        Carta carta2 = new Carta( Arrays.asList( 1, 2, 0 ) );
        Carta carta3 = new Carta( Arrays.asList( 2, 0, 1 ) );
        Set<Carta> cartas = new HashSet<>( Arrays.asList( carta1, carta2, carta3 ) );
        assertFalse( baraja.cartasSonConjunto( cartas ) );
    }

}
