package co.edu.javeriana.algoritmos.robot;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.edu.javeriana.algoritmos.proyecto.Carta;

/**
 * Esta es la clase que representa la baraja
 *
 */
public class Baraja implements Iterable<Carta> 
{
	private int atributos, valores;
	private Map<Integer, Integer> cartasYaDadas;
	private int numeroCartas = 0;
	private SecureRandom random = new SecureRandom();
	private List<Integer> potencias;

	/**
	 * En la constructora no solamente se da valor a los atributos sino que se
	 * genera la baraja.
	 * 
	 * @param atributos
	 * @param valores
	 */
	public Baraja( int atributos, int valores ) 
	{
		this.atributos = atributos;
		this.valores = valores;
        this.numeroCartas = new Double( Math.pow( valores, atributos ) ).intValue();
        this.cartasYaDadas = new HashMap<>();
		generarPotencias();
	}

	private void generarPotencias() 
	{
	    int potencia = 1;
	    
	    potencias = new ArrayList<>();
	    for ( int i = 1; i <= atributos ;i++ ) {
	        potencias.add( potencia );
	        potencia *= valores;
	    }
    }

	private List<Integer> generarValoresParaCarta( int numero ) 
	{
	    List<Integer> lista = new ArrayList<>();
	    
	    for ( int exponente = atributos-1; exponente >= 0 ;exponente-- ) {
	        int potencia = potencias.get( exponente );
	        lista.add( numero / potencia );
	        numero = numero % potencia;
	    }
        return lista;
    }

	/**
	 * En este método se debe implementar el mecanismo de iterador de las cartas.
	 * Debe devolverlas todas, una por una, sin repetir (o sea, implementar
	 * adecuadamente el contrato de <code>Iterator</code>). 
	 */
	@Override
	public Iterator<Carta> iterator() 
	{
	    return new Iterator<Carta>() 
	    {
            @Override
            public boolean hasNext() 
            {
                return cartasYaDadas.size() < numeroCartas;
            }

            @Override
            public Carta next() 
            {
                int valor = random.nextInt( numeroCartas );
                while ( cartasYaDadas.containsKey( valor ) ) {
                    valor = random.nextInt( numeroCartas );
                }
                Carta carta = new Carta( generarValoresParaCarta( valor ) );
                cartasYaDadas.put( valor, valor );
                return carta;
            }
	    };
	}

	/**
	 * Este método verifica que las cartas que llegan como parámetro son un
	 * conjunto. Una lista de cartas es un conjunto si y solamente si cumplen con
	 * las siguientes dos condiciones:
	 * <ul>
	 * <li>Son tantas como el número de valores posibles.
	 * <li>Para todos los atributos, o las cartas tienen el mismo valor o
	 * tienen valores diferentes.
	 * </ul>
	 * 
	 * @param posibleConjunto Colección de cartas para verificar.
	 * @return <code>true</code> si y sólo si las cartas son un conjunto en esta
	 *         baraja
	 */
	public boolean cartasSonConjunto( Set<Carta> posibleConjunto ) 
	{
	    if ( posibleConjunto == null || posibleConjunto.size() != this.valores ) 
	        return false;
	    
	    for ( int i = 0; i < this.atributos ;i++ ) {
	        if ( !atributoCumple( posibleConjunto, i ) ) 
	            return false;
	    }
		return true;
	}

	private boolean atributoCumple( Set<Carta> posibleConjunto, int numAtributo ) 
	{
	    int[] valoresEnConjunto = new int[this.valores];
	    
	    for ( Carta carta: posibleConjunto ) {
	        valoresEnConjunto[carta.valorDeAtributo( numAtributo )]++;
	    }
	    
	    int casillasConUno = 0, casillasConTodo = 0, casillasConCero = 0;
	    for ( int i = 0; i < valoresEnConjunto.length ;i++ ) {
	        if ( valoresEnConjunto[i] == 0 ) 
	            casillasConCero++;
	        else if ( valoresEnConjunto[i] == 1 ) 
	            casillasConUno++;
	        else if ( valoresEnConjunto[i] == this.valores ) 
	            casillasConTodo++;
	    }
        return ( casillasConUno == this.valores ) || ( casillasConTodo == 1 && casillasConCero == this.valores-1 );
    }

    public int getAtributos() 
    {
		return atributos;
	}

	public int getValores() 
	{
		return valores;
	}
	
}
