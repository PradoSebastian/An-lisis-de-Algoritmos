package co.edu.javeriana.algoritmos.proyecto;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Las instancias de esta clase representan las cartas de la baraja.  Por favor noten que las cartas
 * son inmutables, es decir, después de creadas no se pueden cambiar.  Esto es intencional.<p>  
 * 
 * No toque ni cambie de sitio esta clase.
 * 
 * @author Danilo Castro T.
 * 
 */
public class Carta 
{
    private List<Integer> valoresCarta = new ArrayList<>();
    
    public Carta( List<Integer> valoresCarta )
    {
        this.valoresCarta = valoresCarta;
    }
    
    public int valorDeAtributo( int numAtributo ) 
    {
        if ( numAtributo < 0 || numAtributo >= valoresCarta.size() ) {
            throw new IllegalArgumentException( "Atributo inexistente" );
        }
        return valoresCarta.get( numAtributo );
    }
    
    public String toString()
    {
        StringWriter sb = new StringWriter();
        
        sb.append( "Carta[" );
        for ( int i = 0; i < valoresCarta.size(); i++ ) {
            if ( i > 0 ) {
                sb.append( ", " );
            }
            sb.append( i + ": " + valoresCarta.get( i ) );
        }
        sb.append( "]" );
        return sb.toString();
    }
    
    public boolean equals( Object otraCarta ) 
    {
        return otraCarta != null && this.toString().equals( otraCarta.toString() );
    }
    
}
