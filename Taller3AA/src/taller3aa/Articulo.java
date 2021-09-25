/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller3aa;

/**
 *
 * @author sistemas
 */
public class Articulo 
{
    
    public Articulo (String nombre, int pesoKg, float valorMonetario)
    {
        this.nombre=nombre;
        this.pesoKg = pesoKg;
        this.valorMonetario = valorMonetario;
    }
    
    private String nombre;
    private int pesoKg;
    private float valorMonetario;

    public String getNombre() {
        return nombre;
    }

    public int getPesoKg() {
        return pesoKg;
    }

    public float getValorMonetario() {
        return valorMonetario;
    }
    
    public static String ToString(Articulo a)
    {
        String cadena = "\n\t Nombre: " + a.getNombre() + 
                "\n\t Peso Kg: " + a.getPesoKg() + 
                "\n\t Valor: " + a.getValorMonetario();
        return cadena;
    }
}
