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
public class ColaPrioridad
{
    
    ArrayList<Vertice> vertices = new ArrayList<>();
    Map<Vertice, Integer> distancias = new HashMap<>();
    Vertice minimo;
    
    public ColaPrioridad (ArrayList<Vertice> verts , Map<Vertice, Integer> dist)
    {
        vertices.addAll(verts);
        distancias = dist;
        minimo = null;
        actualizar();
    }
    
    public ColaPrioridad (Map<Vertice, Integer> dist)
    {
        distancias = dist;
        minimo = null;
    }
    
    public void añadir (Vertice vert)
    {
        vertices.add(vert);
    }
    
    public void actualizar()
    { 
        int min;
        if(minimo == null)
            min = Integer.MAX_VALUE;
        else
            min = distancias.get(minimo);
        
        for (Vertice v : vertices) 
        {
            if(distancias.get(v) < min)
            {
                minimo = v;
                min = distancias.get(v);
            }
        }
    }
    
    public Vertice minimo ()
    {
        Vertice min = minimo;
        vertices.remove(minimo);
        minimo = null;
        return min;
    }
    
    public boolean isEmpty()
    {
        return vertices.isEmpty();
    }
    
    public boolean pertenece (Vertice vert)
    {
        boolean bandera = false;
        for (Vertice v : vertices) 
        {
            if(v.equals(vert))
                bandera = true;
        }
        return bandera;
    }
    
}
