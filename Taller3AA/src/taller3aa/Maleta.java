/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3aa;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Maleta 
{

    public Maleta() 
    {            
        this.pesoKg= 0;
        this.monto = 0;
        this.articulos = new ArrayList<>();
    }

    private int pesoKg;
    private float monto;
    private ArrayList<Articulo> articulos;

    public int getPesoKg() {
        return pesoKg;
    }

    public float getMonto() {
        return monto;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void insertarArticulo(Articulo art)
    {
        articulos.add(art);
        monto += art.getValorMonetario();
        pesoKg += art.getPesoKg();
    }

    public void copiarMaleta(Maleta m)
    {
        this.monto = m.getMonto();
        this.pesoKg = m.getPesoKg();
        for (Articulo a : m.getArticulos()) 
        {
            this.articulos.add(a);
        }
    }

    public static Maleta MaxValor (Maleta a, Maleta b, Articulo art)
    {
        float aux = Float.max(a.getMonto(), b.getMonto()+art.getValorMonetario());

        if(aux == a.getMonto())
        {
            return a;
        }
        else
        {
            return b;
        } 
    }

    public static String ToString (Maleta m)
    {
        String cadena = "\nPeso kg: " + m.getPesoKg() + "\nMonto: " + m.getMonto() + "\nArticulos: ";
        for (Articulo a : m.getArticulos()) 
        {
            cadena += Articulo.ToString(a);
        }
        return cadena;
    }        
}
