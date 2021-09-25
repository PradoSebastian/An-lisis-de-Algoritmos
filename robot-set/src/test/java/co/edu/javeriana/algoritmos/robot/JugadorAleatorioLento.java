package co.edu.javeriana.algoritmos.robot;

import java.util.List;

import co.edu.javeriana.algoritmos.proyecto.Carta;

public class JugadorAleatorioLento extends JugadorAleatorioRapido 
{

    @Override
    public String nombreJugador() 
    {
        return "JugadorAleatorioLento";
    }

    @Override
    public List<Carta> jugar( List<Carta> cartasEnMesa ) 
    {
        if ( cartasEnMesa.size() < this.valores ) 
            return null;
        try {
            Thread.sleep( 2000L );
        }
        catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        return super.jugar( cartasEnMesa );
    }

}
