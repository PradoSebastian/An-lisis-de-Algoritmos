package co.edu.javeriana.algoritmos.robot;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import co.edu.javeriana.algoritmos.proyecto.Carta;

public class Jugada implements Comparable<Jugada>
{
    String nombreJugador; 
    long tiempo;
    Set<Carta> cartasConjunto;
    
    public Jugada( String nombreJugador, long tiempo, List<Carta> cartasConjunto ) 
    {
        super();
        this.nombreJugador = nombreJugador;
        this.tiempo = tiempo;
        this.cartasConjunto = new HashSet<>( cartasConjunto );
    }

    public boolean esValida() 
    {
        if ( nombreJugador == null || "".equals( nombreJugador ) ) 
            return false;
        if ( tiempo < 0 || tiempo >= 3000L ) 
            return false;
        if ( cartasConjunto == null || cartasConjunto.isEmpty() ) 
            return false;
        return true;
    }

    @Override
    public int compareTo( Jugada o ) 
    {
        if ( o == null ) {
            throw new IllegalArgumentException( "Objeto nulo" );
        }
        if ( this.tiempo < o.tiempo ) {
            return -1;
        }
        else if ( this.tiempo > o.tiempo ) {
            return 1;
        }
        return 0;
    }

    @Override
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( int ) (tiempo ^ (tiempo >>> 32));
        return result;
    }

    @Override
    public boolean equals( Object obj ) 
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Jugada other = ( Jugada ) obj;
        if ( tiempo != other.tiempo )
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Jugada [nombreJugador=" + nombreJugador + ", tiempo=" + tiempo + ", cartasConjunto=" + cartasConjunto
                + "]";
    }

}