package co.edu.javeriana.algoritmos.robot;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

public class JugadorColaLista implements JugadorSet 
{
    private int valores;

    @Override
    public String nombreJugador() {
        return "Jugador cola";
    }

    @Override
    public void inicializar( int numeroAtributos, int numeroValores ) {
        this.valores = numeroValores;
    }

    @Override
    public List<Carta> jugar( List<Carta> cartasEnMesa ) {
        if ( cartasEnMesa.size() < valores )
            return null;
        else 
            return cartasEnMesa.subList( cartasEnMesa.size() - valores, cartasEnMesa.size() );
    }

}
