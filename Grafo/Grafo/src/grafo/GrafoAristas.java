/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;

/**
 *
 * @author prado
 */
public abstract class GrafoAristas extends Grafo
{
    
    ArrayList<Arista> aristas = new ArrayList<>();
    
    public GrafoAristas(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<Arista> arista) 
    {
        super(dirigido, vertices);
        this.aristas.addAll(arista);
    }
    
    @Override
    public ArrayList<Vertice> vecinos(Vertice v)
    {
        ArrayList<Vertice> vecinos = new ArrayList<>();
        
        for (Arista a : aristas) 
        {
            if(dirigido == true)
            {
                if(a.getOrigen().equals(v))
                {
                    vecinos.add(a.getDestino());
                }
            }
            else
            {
                if(a.getOrigen().equals(v))
                {
                    vecinos.add(a.getDestino());
                }
                else if(a.getDestino().equals(v))
                {
                    vecinos.add(a.getOrigen());
                }
            }
        }
        
        return vecinos;
        
    }
    
    public void añadirArista(Vertice origen , Vertice destino, int costo)
    {
        Arista aux = new Arista(origen, destino, costo);
        aristas.add(aux);     
    }
    
    @Override
    public Integer costoArista (Vertice v1, Vertice v2)
    {
        int costo = Integer.MAX_VALUE;
        if(dirigido == true)
        {
            for (Arista a : aristas) 
            {
                if(a.getOrigen().equals(v1) && a.getDestino().equals(v2))
                {
                    costo = a.getCosto();
                    break;
                }
            }
        }
        else
        {
            for (Arista a : aristas) 
            {
                if((a.getOrigen().equals(v1) && a.getDestino().equals(v2)) || (a.getOrigen().equals(v2) && a.getDestino().equals(v1)))
                {
                    costo = a.getCosto();
                    break;
                }
            }
        }
        return costo;
    }

    public void eliminarAristas(Vertice v1)
    {
        ArrayList<Arista> aux = new ArrayList<>();
        aux.addAll(aristas);
        for (Arista a :aristas) 
        {
            if((a.getOrigen().equals(v1) || a.getDestino().equals(v1)))
            {
                aux.remove(a);
            }
        }
        aristas.clear();
        aristas.addAll(aux);
        aux.clear();
    }
    
    public void agregarArista (Arista a)
    {
        aristas.add(a);
    }
    
}

