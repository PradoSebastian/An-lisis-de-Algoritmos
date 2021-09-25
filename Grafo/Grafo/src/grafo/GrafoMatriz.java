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
 * @author sistemas
 */
public abstract class GrafoMatriz extends Grafo {

    private Map<Vertice, HashMap<Vertice, Integer>> MatrizAdyecencia = new HashMap<>();

    public GrafoMatriz(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<HashMap<Vertice, Integer>> lista) {
        super(dirigido, vertices);
        int i = 0;
        for (Vertice v : this.vertices) {
            MatrizAdyecencia.put(v, lista.get(i));
            i++;
        }
    }

    @Override
    public ArrayList<Vertice> vecinos(Vertice v) {
        ArrayList<Vertice> vecinos = new ArrayList<>();

        HashMap<Vertice, Integer> vertice = MatrizAdyecencia.get(v);
        for (Vertice p : this.vertices) {
            if (vertice.containsKey(p)) {
                vecinos.add(p);
            }
        }
        return vecinos;
    }

    public void añadirArista(Vertice origen, Vertice destino, int costo) {

        MatrizAdyecencia.get(origen).put(destino, costo);
    }

    @Override
    public Integer costoArista(Vertice v1, Vertice v2) {
        int costo = Integer.MAX_VALUE;

        HashMap<Vertice, Integer> lista = MatrizAdyecencia.get(v1);

        if (lista.containsKey(v2)) {
            costo = lista.get(v2);
        }
        return costo;
    }

}