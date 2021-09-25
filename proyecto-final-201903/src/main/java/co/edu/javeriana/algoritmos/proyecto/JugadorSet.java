/**
 * 
 */
package co.edu.javeriana.algoritmos.proyecto;

import java.util.List;

/**
 * Esta es la interfaz que su jugador tiene que implementar.  No toque ni cambie de sitio este archivo.
 * 
 * @author Danilo Castro T.
 * 
 */
public interface JugadorSet 
{
    /**
     * 
     * @return El nombre con el cual su jugador se identifica en el juego.  Este método no debe lanzar excepciones.
     */
    String nombreJugador();

    /**
     * Este método de utilería se suministra para que su jugador haga toda la inicialización que usted juzgue
     * conveniente al inicio del juego.  Este método no debe lanzar excepciones.
     * 
     * @param numeroAtributos
     * @param numeroValores
     */
    void inicializar( int numeroAtributos, int numeroValores );
    
    /**
     * Este es el método principal.  Su jugador debe determinar si es posible obtener un conjunto a partir 
     * del grupo de cartas que llegan como parámetro.  De ser posible, el conjunto se retorna.  
     * De lo contrario, se retorna <code>null</code>.  Este método no debe lanzar excepciones.
     *   
     * @param cartasEnMesa Las cartas entre las cuales su jugador debe buscar el conjunto.
     * @return una lista de cartas con el conjunto encontrado, o <code>null</code> si no existe.
     */
    List<Carta> jugar( List<Carta> cartasEnMesa );
}
