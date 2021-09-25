/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author sistemas
 */
public abstract class Grafo 
{
    boolean dirigido;
    ArrayList<Vertice> vertices = new ArrayList<>();

    public Grafo(boolean dirigido, ArrayList<Vertice> vertices) 
    {
        this.dirigido = dirigido;
        this.vertices.addAll(vertices);
    }
    
    public boolean isDirigido() {
        return dirigido;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    public void añadirVertice (Vertice v)
    {
        vertices.add(v);
    }
    
    public abstract ArrayList<Vertice> vecinos (Vertice v);
    
    public abstract Integer costoArista (Vertice a, Vertice b);
    
    public void explorar(Vertice v, int num)
    {
        v.setEtiqueta(num);
        
        for (Vertice vecino : vecinos(v)) 
        {
            if(vecino.getEtiqueta() == 0)
            {
                explorar(vecino, num);
            }
        }
    }
    
    public void dfs()
    {
        int num = 1;
        
        for (Vertice v : vertices) 
        {
            if(v.getEtiqueta() == 0)
            {
                explorar(v, num);
                num++;
            }
        }
    }
    
    public boolean hayCamino (Vertice v1, Vertice v2)
    {
        boolean bandera = false;
        
        if(v1.getEtiqueta() == v2.getEtiqueta())
        {
            bandera = true;
        }
        return bandera;
    }
    
    public Map<Vertice, Integer> bfs (Vertice s) // Sin pesos
    {
        Integer infinito = Integer.MAX_VALUE;
        
        Queue <Vertice> cola = new LinkedList<>();
        
        Map<Vertice, Integer> dist = new HashMap<>();
        
        for (Vertice v : vertices) 
        {
            dist.put(v, infinito);
        }
        dist.replace(s, 0);
        cola.add(s);
        
        while(!cola.isEmpty())
        {
            Vertice u = cola.remove();
            
            for (Vertice v : vecinos(u)) 
            {
                if(dist.get(v).equals(infinito))
                {
                    cola.add(v);
                    dist.replace(v, (dist.get(u) + 1) );
                }
            }    
        }
        return dist;
    }
    
    public Map<Vertice, Integer> dijkstra (Vertice s)
    {
        Integer infinito = Integer.MAX_VALUE;
        
        Map<Vertice, Integer> dist = new HashMap<>();
        Map<Vertice, Vertice> pred = new HashMap<>();
        
        for (Vertice v : vertices) 
        {
            dist.put(v, infinito);
            pred.put(v, null);
        }
        
        dist.replace(s, 0);
        ColaPrioridad cola = new ColaPrioridad(vertices, dist); 
        
        while(!cola.isEmpty())
        {
            Vertice u = cola.minimo(); //Remover el minimo
            //System.out.println(cola.vertices);
            if(vecinos(u).isEmpty())
                break;
            for (Vertice v : vecinos(u)) 
            {
                if(dist.get(v) > (dist.get(u) + costoArista(u, v)))
                {
                    dist.replace(v, dist.get(u)+ costoArista(u, v));
                    pred.replace(v, u);
                    cola.actualizar();
                    //System.out.println(dist);
                }
            }
        }
        return dist;
    }
    
    public boolean bellmanFord (Vertice s)
    {
        Integer infinito = Integer.MAX_VALUE;
        
        Queue <Vertice> cola = new LinkedList<>();
        
        Map<Vertice, Integer> dist = new HashMap<>();
        Map<Vertice, Vertice> pred = new HashMap<>();
        
        for (Vertice v : vertices) 
        {
            dist.put(v, infinito);
            pred.put(v, null);
        }
        dist.replace(s, 0);
        
        for (int i = 1; i < vertices.size(); i++) 
        {
            cola.add(s);
            while(!cola.isEmpty())
            {
                Vertice u = cola.remove();
                for (Vertice v : vecinos(u)) 
                {
                    if(dist.get(v)> dist.get(u)+ costoArista(u, v))
                    {
                        cola.add(v);
                        dist.replace(v, dist.get(u)+ costoArista(u, v));
                        pred.replace(v, u);
                    }
                }    
            }
        }
        boolean bandera = true;
        cola.add(s);
        while(!cola.isEmpty())
        {
            Vertice u = cola.remove();
            for (Vertice v : vecinos(u)) 
            {
                if(dist.get(v)> dist.get(u)+ costoArista(u, v))
                {
                    cola.add(v);
                    System.out.println("Hay ciclo negativo");
                    bandera = false;
                }
            }    
        }
        return bandera;     
    }
    
    public Map<Vertice, Vertice> Prim (Vertice s)
    {
        Integer infinito = Integer.MAX_VALUE;
        Map<Vertice, Integer> dist = new HashMap<>();
        Map<Vertice, Vertice> padres = new HashMap<>();
        for (Vertice v : vertices) 
        {
            dist.put(v, infinito);
            padres.put(v, null);
        }
        dist.replace(s, 0);
        ColaPrioridad cola = new ColaPrioridad(vertices, dist); 

        while(!cola.isEmpty())
        {
            Vertice u = cola.minimo();
            for (Vertice v : vecinos(u)) 
            {
                if(cola.pertenece(v) && (dist.get(v) > costoArista(u, v)))
                {
                    padres.replace(v, u);
                    dist.replace(v, costoArista(u, v));
                    cola.actualizar();
                }
            }
        } 
        return padres;
    }
    
    public ArrayList<Arista> kruskal()
    {
        ArrayList<Arista> arbol = new ArrayList<>();
        ArrayList<Gallada> galladas = new ArrayList<>();
        ArrayList<Arista> aristas =  new ArrayList<>();
        for (Vertice v : vertices) 
        {
            Gallada gAux = new Gallada();
            gAux.gallada.add(v);
            galladas.add(gAux);
            for(Vertice u: this.vecinos(v)){
                Arista aux= new Arista(v,u,this.costoArista(v,u));
                if(!aristas.contains(aux))
                    aristas.add(aux);
            }                
        }
        Collections.sort(aristas,new OrdenarAristaPorPeso());
        for(Arista a: aristas){
            for(Gallada gallada:galladas){
                if(gallada.de(a.getOrigen())!=gallada.de(a.getDestino())){
                    arbol.add(a);
                    gallada.unirGallada(a.getOrigen(), a.getDestino());
                    for(Gallada aux:galladas){
                        if(aux.getGallada().contains(a.getOrigen())){
                            aux.eliminarGallada();
                        }
                        if(aux.getGallada().contains(a.getDestino())){
                            aux.eliminarGallada();
                        }
                    }
                }
                    
            }
            
        }
        return arbol;
    }
    
}
