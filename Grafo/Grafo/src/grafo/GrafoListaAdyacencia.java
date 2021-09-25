/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author prado
 */
public abstract class GrafoListaAdyacencia extends Grafo
{
    private Map<Vertice, ArrayList<Arista>> listaAdyecencia = new HashMap<>();
    
    public GrafoListaAdyacencia(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<ArrayList<Arista>> lista ) 
    {
        super(dirigido, vertices);
        int i = 0;
        for (Vertice v : this.vertices)         
        {
            listaAdyecencia.put(v, lista.get(i));
            i++;
        }
        
    }
    
    @Override
    public ArrayList<Vertice> vecinos(Vertice v)
    {
        ArrayList<Vertice> vecinos = new ArrayList<>();
               
        for (Arista a : listaAdyecencia.get(v)) 
        {
            vecinos.add(a.getDestino());
        }

        return vecinos;
        
    }
    
    public void añadirArista(Vertice origen , Vertice destino, int costo)
    {
        Arista aux = new Arista(null, destino, costo);
        listaAdyecencia.get(origen).add(aux);
    }
    
    @Override
    public Integer costoArista (Vertice v1, Vertice v2)
    {
        int costo = Integer.MAX_VALUE;
        
        for (Arista a : listaAdyecencia.get(v1)) 
        {
            if(a.getDestino().equals(v2))
            {
                costo = a.getCosto();
                break;
            }
        }

        return costo;
    }
    
}
