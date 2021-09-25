/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javafx.print.Collation;

/**
 *
 * @author prado
 */
public class GrafoAsignación extends GrafoAristas
{
    
    public GrafoAsignación(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<Arista> arista) {
        super(dirigido, vertices, arista);
    }
    
    public void llenar(int n, ArrayList<Integer> costos)
    {
        for (int i = 1; i <= n; i++) 
        {
            vertices.add(new Vertice("Persona "+ i));
        }
        for (int i = 1; i <= n; i++) 
        {
            vertices.add(new Vertice("Labor " + i));
        }
        int k = 0;
         for (int i = 0; i < n; i++) 
        {
            for(int j = n; j<2*n; j++)
            {
                aristas.add(new Arista(vertices.get(i), vertices.get(j), costos.get(k)));
                k++;
            }
        }
    }
    
    public Vertice minimo(Map<Vertice, Integer> m)
    {
        int min = Integer.MAX_VALUE;
        Vertice minimo = null;
        
        for (Vertice v : vertices) 
        {
            if(m.get(v) != 0 && m.get(v) < min)
            {
                min = m.get(v);
                minimo = v;
            }
        }
        
        return minimo;
    }
    
    public static void main(String[] args) 
    {
        ArrayList<Integer> costos = new ArrayList<>();
        for(int i=0; i<16; i++)
        {
            costos.add((int)(Math.random()*100+1));
        }
        GrafoAsignación g = new GrafoAsignación(true, new ArrayList<>(), new ArrayList<>());
        g.llenar(4, costos);
        Integer total = 0;
        
        System.out.println(g.vertices);
        System.out.println(g.aristas);
        
        for(int i=0; i<4; i++)
        {
            Map<Vertice, Integer> m = g.dijkstra(g.vertices.get(i));
            Vertice min = g.minimo(m);
            System.out.println("Se asigna " + g.vertices.get(i).getAtributo() + " al " + min.getAtributo() 
                    + " con costo " + m.get(min));
            total += m.get(min);
            g.eliminarAristas(min);
        }
        
        System.out.println("Costo Total: " + total);
        
    }
    
}
