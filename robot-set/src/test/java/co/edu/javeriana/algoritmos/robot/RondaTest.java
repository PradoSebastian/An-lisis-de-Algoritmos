package co.edu.javeriana.algoritmos.robot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

public class RondaTest {

    @Test
    public void testDeberiaAsignarPuntajeCorrectamente() 
    {
        Baraja barajaMock = new BarajaMock();
        JugadorSet[] jugadores = new JugadorSet[] { 
                new JugadorAleatorioRapido(), new JugadorAleatorioLento(), 
                new JugadorColaLista(), new JugadorLentisimo(), new JugadorDescalificado() };
        Ronda ronda = new Ronda( jugadores, barajaMock );
        Map<String, Integer> marcador = ronda.jugarRonda();
        System.out.println( marcador );
    }
    
    static class BarajaMock extends Baraja 
    {
        int[][] cartas = new int[][] {{0, 1, 2, 0}, {0, 2, 0, 1}, {0, 2, 1, 2}, {0, 2, 2, 0}};
        int ventana = 0;
        
        public BarajaMock() 
        {
            super( 4, 3 );
        }
        
        public Iterator<Carta> iterator()
        {
            return new Iterator<Carta>() {

                @Override
                public boolean hasNext() {
                    return ventana < 4;
                }

                @Override
                public Carta next() {
                    ArrayList<Integer> lista = new ArrayList<>();
                    for ( int x : cartas[ventana] ) {
                        lista.add( x );
                    }
                    ventana++;
                    return new Carta( lista );
                }
                
            };
        }
        
    }

}
