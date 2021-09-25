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
public class GrafoAjedres4x4 extends GrafoAristas
{
    
    public GrafoAjedres4x4(boolean dirigido, ArrayList<Vertice> vertices, ArrayList<Arista> aristas) 
    {
        super(dirigido, vertices, aristas);
    }
    
    public void llenar()
    {
        ArrayList<Vertice> verts = new ArrayList<>();
        ArrayList<Arista> arist = new ArrayList<>();
        for(int i=1; i<=16; i++)
        {
            Vertice v = new Vertice(i);
            verts.add(v);
        }
        for(int j = 0; j<16; j++)
        {
            Arista a = new Arista(verts.get(j),verts.get(j+1), 1);
            arist.add(a);
            a = new Arista(verts.get(j),verts.get(j+4), 1);
            arist.add(a);
            a = new Arista(verts.get(j),verts.get(j+5), 1);
            arist.add(a);
        }
        vertices.addAll(verts);
    }
    
}
