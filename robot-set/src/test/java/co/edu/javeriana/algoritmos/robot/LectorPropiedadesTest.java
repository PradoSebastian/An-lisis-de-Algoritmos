package co.edu.javeriana.algoritmos.robot;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class LectorPropiedadesTest {

    @Test
    public void testDeberiaRetornarCorrectamenteValoresClasesYTableros() {
        try {
            LectorPropiedades lector = LectorPropiedades.instancia( "src/test/resources/props1.properties" );
            assertEquals( 5, lector.numeroAtributos() );
            assertEquals( 4, lector.numeroValores() );
            List<String> clases = lector.clasesJugadores();
            assertNotNull( clases );
            assertEquals( 2, clases.size() );
            System.out.println( clases );
        }
        catch ( IOException e ) {
            e.printStackTrace();
            fail();
        }
    }
    
    @Test
    public void testDeberiaRetornarCorrectamenteClasesSinTableros() {
        try {
            LectorPropiedades lector = LectorPropiedades.instancia( "src/test/resources/props2.properties" );
            assertEquals( 4, lector.numeroAtributos() );
            assertEquals( 3, lector.numeroValores() );
            List<String> clases = lector.clasesJugadores();
            assertNotNull( clases );
            assertEquals( 4, clases.size() );
            System.out.println( clases );
        }
        catch ( IOException e ) {
            e.printStackTrace();
            fail();
        }
    }

}
