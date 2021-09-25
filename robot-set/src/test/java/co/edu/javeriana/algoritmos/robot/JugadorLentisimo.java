package co.edu.javeriana.algoritmos.robot;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

public class JugadorLentisimo implements JugadorSet 
{

    @Override
    public String nombreJugador() {
        return "Leeento";
    }

    @Override
    public void inicializar( int numeroAtributos, int numeroValores ) {
        
    }

    @Override
    public List<Carta> jugar( List<Carta> cartasEnMesa ) {
        try {
            Thread.sleep( 5000L );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        return cartasEnMesa;
    }

}
