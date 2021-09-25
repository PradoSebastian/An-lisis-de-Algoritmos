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
public class Gallada 
{
    ArrayList<Vertice> gallada;
    
    public boolean de(Vertice v)
    {
        return this.gallada.contains(v);
    }
    
    public void unirGallada(Vertice origen, Vertice destino){
        if(this.gallada.contains(origen)&&!this.gallada.contains(destino)){
            this.gallada.add(destino);
        }else if(this.gallada.contains(destino)&&!this.gallada.contains(origen)){
            this.gallada.add(origen);
        }
    }

    public void setGallada(ArrayList<Vertice> gallada) {
        this.gallada = gallada;
    }

    public ArrayList<Vertice> getGallada() {
        return gallada;
    }
    
    public void eliminarGallada(){
        this.gallada.clear();
    }
    
    
}