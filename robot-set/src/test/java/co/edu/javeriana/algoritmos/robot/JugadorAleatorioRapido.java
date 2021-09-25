package co.edu.javeriana.algoritmos.robot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import co.edu.javeriana.algoritmos.proyecto.Carta;
import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

public class JugadorAleatorioRapido implements JugadorSet 
{
    int atributos, valores;
    
    @Override
    public String nombreJugador() 
    {
        return "Jugador aleatorio rápido";
    }

    @Override
    public void inicializar( int numeroAtributos, int numeroValores ) 
    {
        this.atributos = numeroAtributos;
        this.valores = numeroValores;
    }

    @Override
    public List<Carta> jugar( List<Carta> cartasEnMesa ) 
    {
        Random rnd = new Random( System.currentTimeMillis() );
        List<Carta> retorno = new ArrayList<>();
        int i = 0;

        while ( i < valores && !cartasEnMesa.isEmpty() ) {
            retorno.add( cartasEnMesa.remove( rnd.nextInt( cartasEnMesa.size() ) ) );
            i++;
        }
        return ( i == valores ) ? retorno : null;
    }

}
