/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.Comparator;

/**
 *
 * @author prado
 */
public class OrdenarAristaPorPeso implements Comparator<Arista> {
    @Override
    public int compare(Arista o1, Arista o2) {
        return o1.getCosto()- o2.getCosto();
    }
}