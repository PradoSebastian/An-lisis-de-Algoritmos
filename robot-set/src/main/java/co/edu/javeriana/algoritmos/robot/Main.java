package co.edu.javeriana.algoritmos.robot;

import java.io.IOException;

import co.edu.javeriana.algoritmos.proyecto.JugadorSet;


/**
 * @author danilo
 *
 */
public class Main 
{
	/**
	 * @param args
	 */
	
        public static void main(String[] args)
        {
            new Main().ejecutarRobot(args);
        }

	void ejecutarRobot( String[] args ) 
	{
		try {
			LectorPropiedades lector = LectorPropiedades.instancia( args[0] );
			JugadorSet[] jugadores = new CargadorJugadores().cargarJugadores();
			
			System.out.println( 
			        new Ronda( jugadores, new Baraja( lector.numeroAtributos(), lector.numeroValores() ) )
			            .jugarRonda() 
			);
		} 
		catch ( IOException e ) {
			System.out.println( "Error al cargar propiedades: " + e.getMessage() );
		}
	}

}
