/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javeriana.algoritmos.proyecto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Sebastián Prado
 * @author Santos David Nuñez Villamil
 * 
 */
public class Jugador implements JugadorSet
{
    
    private int n;
    private int m;

    @Override
    public String nombreJugador() {
        return "Jugador_GSS";
    }

    @Override
    public void inicializar(int numeroAtributos, int numeroValores) {
        
        this.n = numeroAtributos;
        this.m = numeroValores;
        
    }
    
    boolean condicionConjunto ( ArrayList<Carta> lista, Carta nueva)
    {
        boolean iguales = true, distintos = true, resultado = true;
        for ( int i = 0; i < n; i++)
        {
            for( Carta card : lista )
            {
                if ( card.valorDeAtributo(i) == nueva.valorDeAtributo(i))
                    distintos = false;
                else
                    iguales = false;
            }
            if ( distintos == true || iguales == true)
                resultado = true;
            else
                return false;
            iguales = true;
            distintos = true;
        }
        return true;
    }

    @Override
    public List<Carta> jugar(List<Carta> cartasEnMesa) {
        
        ArrayList<ArrayList<Carta>> c = new ArrayList<>();
        for(int i = 0; i < m; i++)
        {
            ArrayList<Carta> aux = new ArrayList<>();
            c.add(aux);
        }
        c.get(0).add(cartasEnMesa.get(0));
        int cont = 1, cont2 = 1, p = cartasEnMesa.size();
        for(int i = 1; i<m; i++)
        {
            if(condicionConjunto(c.get(i-1), cartasEnMesa.get(cont)))
            {
                c.get(i).addAll(c.get(i-1));
                c.get(i).add(cartasEnMesa.get(cont));
            }
            else
            {
                for(int k = cont+1; k< p; k++)
                {
                    if(condicionConjunto(c.get(i-1), cartasEnMesa.get(k)))
                    {
                        c.get(i).addAll(c.get(i-1));
                        c.get(i).add(cartasEnMesa.get(k));
                        cont = k;
                        break;
                    }
                }
                if(c.get(i).isEmpty())
                {
                    if(condicionConjunto(c.get(i-2), cartasEnMesa.get(cont)))
                    {
                        c.get(i-1).addAll(c.get(i-2));
                        c.get(i-1).add(cartasEnMesa.get(cont));
                        i--;
                    }
                    else
                    {
                        ArrayList<Carta> aux = new ArrayList<>();
                        c.set(i-1, aux);
                        i=i-2;
                    }
                }
            }
            if(!c.get(m-1).isEmpty())
                break;
            if(cont == p-1)
            {
                c.clear();
                for(int j = 0; j < m; j++)
                {
                    ArrayList<Carta> aux = new ArrayList<>();
                    c.add(aux);
                }
                c.get(0).add(cartasEnMesa.get(cont2));
                cont2++;
                cont = cont2;
                i = 0;
            }
            if(cont2 == p-m)
                break;
            cont++;
        }
        return c.get(m-1);
        
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
    
}
