/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author sistemas
 */

public class Vertice
{
    private Object atributo;
    private int etiqueta;
    
    public Vertice(Object info)
    {
        this.atributo = info;
        this.etiqueta = 0;
    }

    public Object getAtributo() {
        return atributo;
    }

    public void setAtributo(Object atributo) {
        this.atributo = atributo;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }
    
    public String toString()
    {
        return atributo.toString();
    }
    
}

