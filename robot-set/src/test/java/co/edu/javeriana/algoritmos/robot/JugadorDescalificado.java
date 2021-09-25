package co.edu.javeriana.algoritmos.robot;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

public class JugadorDescalificado implements JugadorSet 
{

    @Override
    public String nombreJugador() {
        return "Necio";
    }

    @Override
    public void inicializar( int numeroAtributos, int numeroValores ) {
        
    }

    @Override
    public List<Carta> jugar( List<Carta> cartasEnMesa ) {
        throw new RuntimeException( "Jajajaj" );
    }

}
