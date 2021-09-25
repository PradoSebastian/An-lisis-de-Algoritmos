/**
 * 
 */
package co.edu.javeriana.algoritmos.robot;

import java.util.List;
import java.util.stream.Collectors;

import co.edu.javeriana.algoritmos.proyecto.JugadorSet;

/**
 * @author danilo
 *
 */
public class CargadorJugadores {

    public JugadorSet[] cargarJugadores() {
        List<String> clasesJugadores = LectorPropiedades.instancia().clasesJugadores();
        
        List<JugadorSet> jugadores = clasesJugadores.stream()
                 .map( this::cargarJugador )
                 .collect( Collectors.toList() );
        return jugadores.toArray( new JugadorSet[0] );
    }

    private JugadorSet cargarJugador( String claseJugador ) {
        try {
            return ( JugadorSet ) Class.forName( claseJugador ).newInstance();
        } 
        catch ( Exception e ) {
            e.printStackTrace();
            return null;
        }
    }

}
