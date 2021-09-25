/**
 * 
 */
package co.edu.javeriana.algoritmos.robot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author danilo
 *
 */
public class LectorPropiedades {
    private Properties propiedades = null;
    private static Map<String, LectorPropiedades> instancias = new HashMap<>();

    private LectorPropiedades( String propertiesPath ) throws IOException {
        propiedades = new Properties();
        propiedades.load( new FileInputStream( new File( propertiesPath ) ) );
        System.out.println( "Cargando propiedades de archivo: " + propertiesPath );
        System.out.println( propiedades );
    }

    public static LectorPropiedades instancia( String propertiesPath ) throws IOException {
        LectorPropiedades instancia = instancias.get( propertiesPath );
        if ( instancia == null ) {
            instancia = new LectorPropiedades( propertiesPath );
            instancias.put( propertiesPath, instancia );
        }
        return instancia;
    }

    public static LectorPropiedades instancia() {
        return instancias.values().iterator().next();
    }

    public List<String> clasesJugadores() {
        List<String> jugadores = new ArrayList<>();
        int i = 1;
        String claseJugador = null;

        while ( (claseJugador = propiedades.getProperty( "clase.jugador." + i )) != null ) {
            jugadores.add( claseJugador );
            i++;
        }

        return jugadores;
    }

    public int numeroAtributos() {
        try {
            return new Integer( propiedades.getProperty( "numero.atributos" ) );
        }
        catch ( NumberFormatException e ) {
            return 4;
        }
    }

    public int numeroValores() {
        try {
            return new Integer( propiedades.getProperty( "numero.valores" ) );
        }
        catch ( NumberFormatException e ) {
            return 3;
        }
    }

}
