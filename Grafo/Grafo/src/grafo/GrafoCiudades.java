/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author prado
 */
public class GrafoCiudades extends GrafoAristas 
{
    
    public GrafoCiudades(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<Arista> arista) {
        super(dirigido, vertices, arista);
    }
    
    
    public static void main(String[] args) 
    {
        ArrayList<Vertice> verts = new ArrayList<Vertice>();
        for (int i = 1; i <= 5; i++) 
        {
            verts.add(new Vertice("Ciudad "+ i));
        }
        System.out.println(verts);
        
        ArrayList<Arista> arist1 = new ArrayList<>();
        arist1.add(new Arista(verts.get(0), verts.get(1), 5));
        arist1.add(new Arista(verts.get(0), verts.get(3), 6));
        arist1.add(new Arista(verts.get(1), verts.get(2), 3));
        arist1.add(new Arista(verts.get(1), verts.get(4), 7));
        arist1.add(new Arista(verts.get(2), verts.get(4), 1));
        arist1.add(new Arista(verts.get(3), verts.get(4), 2));
        
        ArrayList<Arista> arist2 = new ArrayList<>();
        arist2.add(new Arista(verts.get(0), verts.get(2), 3));
        arist2.add(new Arista(verts.get(0), verts.get(4), 2));
        arist2.add(new Arista(verts.get(3), verts.get(1), 1));
        arist2.add(new Arista(verts.get(3), verts.get(2), 3));
        
        Vertice s = verts.get(0), t = verts.get(4);
        
        GrafoCiudades gO = new GrafoCiudades(false, verts, arist1);
        GrafoCiudades g1 = new GrafoCiudades(false, verts, arist1);
        g1.agregarArista(arist2.get(0));
        GrafoCiudades g2 = new GrafoCiudades(false, verts, arist1);
        g2.agregarArista(arist2.get(1));
        GrafoCiudades g3 = new GrafoCiudades(false, verts, arist1);
        g3.agregarArista(arist2.get(2));
        GrafoCiudades g4 = new GrafoCiudades(false, verts, arist1);
        g4.agregarArista(arist2.get(3));
        
        ArrayList<Integer> distancias = new ArrayList<>();
        Map<Vertice, Integer> m = g1.dijkstra(s);
        //System.out.println(m);
        distancias.add(m.get(t));
        m = g2.dijkstra(s);
        distancias.add(m.get(t));
        m = g3.dijkstra(s);
        distancias.add(m.get(t));
        m = g4.dijkstra(s);
        distancias.add(m.get(t));
        //System.out.println(distancias);
        
        System.out.println("El mejor camino es: " + arist2.get(gO.minimo(distancias)));
        
    }
    
    public int minimo(ArrayList<Integer> m)
    {
        int min = Integer.MAX_VALUE;
        int minimo = -1;
        
        for (int i = 0; i< m.size(); i++) 
        {
            if(m.get(i) < min)
            {
                min = m.get(i);
                minimo = i;
            }
        }
        
        return minimo;
    }
    
}
