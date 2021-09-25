package co.edu.javeriana.algoritmos.robot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

/**
 * @author danilo
 *
 */
public class Ronda 
{
    private Map<String, JugadorSet> jugadores;
    private Map<String, Integer> marcador = new HashMap<>(); 
    private Baraja barajaActual = null;
    private List<Carta> cartasEnMesa = null;
    
    public Ronda( JugadorSet[] jugadores, Baraja baraja ) 
    {
        this.jugadores = new HashMap<>();
        for ( int i = 0; i < jugadores.length ;i++ ) {
            try {
                this.jugadores.put( jugadores[i].nombreJugador(), jugadores[i] );
            }
            catch ( Exception e ) {
                e.printStackTrace();
                descalificar( jugadores[i].toString() );
            }
        }
        System.out.println( "Jugadores: " + this.jugadores );
        barajaActual = baraja;
    }

    public Map<String, Integer> jugarRonda() 
    {
        marcador = new HashMap<>();
        jugarBaraja();
        return marcador;
    }

    private void jugarBaraja() 
    {
        List<String> descalificados = new ArrayList<>();
        cartasEnMesa = new ArrayList<>(); 
        for ( JugadorSet jugador : jugadores.values() ) {
            try {
                jugador.inicializar( barajaActual.getAtributos(), barajaActual.getValores() );
            }
            catch ( Exception e ) {
                System.out.println( 
                        "El jugador " + jugador.nombreJugador() 
                        + " causó una excepción al inicializar y será descalificado" );
                e.printStackTrace();
                descalificados.add( jugador.nombreJugador() );
            }
        }
        descalificados.forEach( this::descalificar );
        int i = 1;
        for ( Carta carta: barajaActual ) {
            System.out.println( i + ": " );
            jugarCarta( carta );
            i++;
        }
        
    }

    private void jugarCarta( Carta carta ) 
    {
        List<Jugada> jugadas = new ArrayList<>();
        List<String> descalificados = new ArrayList<>();
        
        cartasEnMesa.add( carta );
        System.out.println( "La mesa es: " + cartasEnMesa );
        for ( JugadorSet jugador: jugadores.values() ) {
            try {
                Jugada jugada = jugarCartaJugador( jugador );
                if ( jugada != null ) {
                    if ( jugada.tiempo <= 3000L ) {
                        jugadas.add( jugada );
                    }
                    else {
                        System.out.println( "El jugador " + jugada.nombreJugador + " tardó más del límite y será descalificado" );
                        descalificados.add( jugador.nombreJugador() );
                    }
                }
            }
            catch ( Exception e ) {
                descalificados.add( jugador.nombreJugador() );
            }
        }
        descalificados.forEach( this::descalificar );
        Collections.sort( jugadas );
        verificarYAplicarJugadas( jugadas );
    }

    void verificarYAplicarJugadas( List<Jugada> jugadas ) {
        Jugada jugadaEscogida = null;
        
        for ( Jugada jugada: jugadas ) {
            if ( esJugadaConConjuntoValido( jugada ) ) {
                if ( jugadaEscogida == null ) {
                    sumarPuntosMarcador( jugada.nombreJugador, 3 );
                    jugadaEscogida = jugada;
                    System.out.println( "Se selecciona la jugada de " + jugada.nombreJugador + ": " + jugada );
                }
            }
            else {
                sumarPuntosMarcador( jugada.nombreJugador, -1 );
            }
        }
        if ( jugadaEscogida != null ) {
            jugadaEscogida.cartasConjunto.stream()
                .forEach( cartasEnMesa::remove );
            System.out.println( marcador );
        }
    }

    boolean esJugadaConConjuntoValido( Jugada jugada ) {
        return jugada.esValida() 
                && jugada.cartasConjunto.stream()
                    .allMatch( c -> cartasEnMesa.contains( c ) )
                && barajaActual.cartasSonConjunto( jugada.cartasConjunto );
    }

    Jugada jugarCartaJugador( JugadorSet jugador ) throws Exception 
    {
        Jugada jugada = null;
        
        try {
            List<Carta> copiaMesa = cartasEnMesa.stream().collect( Collectors.toList() );
            long inicio = System.currentTimeMillis();
            List<Carta> posibleConjunto = jugador.jugar( copiaMesa );
            if ( posibleConjunto != null && !posibleConjunto.isEmpty() ) {
                jugada = new Jugada( jugador.nombreJugador(), System.currentTimeMillis() - inicio, posibleConjunto );
                return jugada;
            }
        }
        catch ( Exception e ) {
            System.out.println( "El jugador " + jugador.nombreJugador() + " ha causado una excepción y será descalificado" );
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    private void descalificar( String nombreJugador ) 
    {
        jugadores.remove( nombreJugador );
        asignarPuntosMarcador( nombreJugador, -100 );
    }

    
    private void sumarPuntosMarcador( String nombreJugador, int puntos ) 
    {
        Integer puntajePrevio = marcador.get( nombreJugador );
        
        if ( puntajePrevio == null ) {
            asignarPuntosMarcador( nombreJugador, puntos );
        }
        else {
            asignarPuntosMarcador( nombreJugador, puntajePrevio + puntos );
        }
    }

    private void asignarPuntosMarcador( String nombreJugador, int puntos ) 
    {
        marcador.put( nombreJugador, puntos );
    }
    
}
